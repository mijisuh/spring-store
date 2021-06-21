package ssd0206.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import ssd0206.service.StoreFacade;

@Controller
@SessionAttributes("userSession")
public class ListOrdersController {

	private StoreFacade store;

	@Autowired
	public void setStore(StoreFacade store) {
		this.store = store;
	}

	@RequestMapping("/shop/listOrders.do")
	public ModelAndView handleRequest(
		@ModelAttribute("userSession") UserSession userSession
		) throws Exception {
		String username = userSession.getAccount().getUsername();
		return new ModelAndView("order/ListOrders", "orderList", 
				store.getOrdersByUsername(username));
	}

}
