package ssd0206.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.ModelAndViewDefiningException;

import ssd0206.domain.Account;
import ssd0206.domain.Cart;
import ssd0206.service.OrderValidator;
import ssd0206.service.StoreFacade;


@Controller
@SessionAttributes({"sessionCart", "orderForm"})
public class OrderController {
	@Autowired
	private StoreFacade store;
	@Autowired
	private OrderValidator orderValidator;
	
	@ModelAttribute("orderForm")
	public OrderForm createOrderForm() {
		return new OrderForm();
	}

	@ModelAttribute("creditCardTypes")
	public List<String> referenceData() {
		ArrayList<String> creditCardTypes = new ArrayList<String>();
		creditCardTypes.add("Visa");
		creditCardTypes.add("MasterCard");
		creditCardTypes.add("American Express");
		return creditCardTypes;			
	}
	
	@RequestMapping("/shop/newOrder.do")
	public String initNewOrder(HttpServletRequest request,
			@ModelAttribute("sessionCart") Cart cart,
			@ModelAttribute("orderForm") OrderForm orderForm
			) throws ModelAndViewDefiningException {
		UserSession userSession = (UserSession) request.getSession().getAttribute("userSession");
		if (cart != null) {
			// Re-read account from DB at team's request.
			Account account = store.getAccount(userSession.getAccount().getUserId());
			orderForm.getOrder().initOrder(account, cart);
			return "NewOrderForm";	
		}
		else {
			ModelAndView modelAndView = new ModelAndView("Error");
			modelAndView.addObject("message", "An order could not be created because a cart could not be found.");
			throw new ModelAndViewDefiningException(modelAndView);
		}
	}
	
	@RequestMapping("/shop/newOrderSubmitted.do")
	public String bindAndValidateOrder(HttpServletRequest request,
			@ModelAttribute("orderForm") OrderForm orderForm, 
			BindingResult result) {
		if (orderForm.didShippingAddressProvided() == false) {	
			// from NewOrderForm
			orderValidator.validateCreditCard(orderForm.getOrder(), result);
			orderValidator.validateBillingAddress(orderForm.getOrder(), result);
			if (result.hasErrors()) return "NewOrderForm";
			
			if (orderForm.isShippingAddressRequired() == true) {
				orderForm.setShippingAddressProvided(true);
				return "ShippingForm";
			}
			else {			
				return "ConfirmOrder";
			}
		}
		else {		// from ShippingForm
			orderValidator.validateShippingAddress(orderForm.getOrder(), result);
			if (result.hasErrors()) return "ShippingForm";
			return "ConfirmOrder";
		}
	}
	
	@RequestMapping("/shop/confirmOrder.do")
	protected ModelAndView confirmOrder(
			@ModelAttribute("orderForm") OrderForm orderForm, 
			SessionStatus status) {
		store.insertOrder(orderForm.getOrder());
		ModelAndView mav = new ModelAndView("ViewOrder");
		mav.addObject("order", orderForm.getOrder());
		mav.addObject("message", "Thank you, your order has been submitted.");
		status.setComplete();  // remove sessionCart and orderForm from session
		return mav;
	}
}
