package ssd0206.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ssd0206.domain.SalesItem;
import ssd0206.service.StoreFacade;

@Controller
public class ViewSalesItemController { 

	private StoreFacade store;

	@Autowired
	public void setStore(StoreFacade store) {
		this.store = store;
	}

	@RequestMapping("/shop/sales/salesItem.do")
	private ModelAndView getSalesItem(@RequestParam("itemId") int itemId) {
		SalesItem item = store.getSalesItem(itemId);	
		String viewName = "sales/salesItem";
		ModelAndView mav = new ModelAndView(viewName);
		mav.addObject("item", item);
		return mav;
		
	}

}
