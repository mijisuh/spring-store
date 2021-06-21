package ssd0206.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import ssd0206.domain.ACOrder;
import ssd0206.domain.Order;
import ssd0206.service.StoreFacade;

@Controller
@SessionAttributes("userSession")
public class ViewOrderController {

	private StoreFacade store;

	@Autowired
	public void setStore(StoreFacade store) {
		this.store = store;
	}

	@RequestMapping("/shop/viewOrder.do")
	public ModelAndView handleRequest(
			@ModelAttribute("userSession") UserSession userSession,
			@RequestParam("orderId") int orderId
			) throws Exception {
		Order order = this.store.getOrder(orderId);
		if (userSession.getAccount().getUsername().equals(order.getUsername())) {
			return new ModelAndView("order/ViewOrder", "order", order);
		}
		else {
			return new ModelAndView("Error", "message", "You may only view your own orders.");
		}
	}
	

	@GetMapping("/shop/acOrders.do")
	private ModelAndView getmyOrderList(HttpSession session) {
		UserSession user = (UserSession) session.getAttribute("userSession");
		List<ACOrder> acOrderList = null;
		
		acOrderList = store.getACOrder(user.getAccount().getUserId());
				
		return new ModelAndView("order/ACOrders", "acOrderList", acOrderList);
		
	
	}
}
