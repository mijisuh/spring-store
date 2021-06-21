package ssd0206.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ssd0206.domain.ACItem;
import ssd0206.domain.GBItem;
import ssd0206.domain.SalesItem;
import ssd0206.service.StoreFacade;

@Controller
public class ViewItemList {
	
	@Autowired
	private StoreFacade store;
	public void setStore(StoreFacade store) {
		this.store = store;
	}
	
	@RequestMapping("/shop/{dealName}/item.do")
	private ModelAndView list(HttpServletRequest request, 
									@PathVariable String dealName,
									@RequestParam("itemId") int itemId) {
		//List<Category> categoryList = store.getCategoryListByDealName(dealName);
		
		request.setAttribute("dealName", dealName);
		
		String viewName = dealName + "/item";
		
		ModelAndView mav = new ModelAndView(viewName);
		
		if(dealName.equals("sales")) {
			SalesItem item = store.getSalesItem(itemId);
			mav.addObject("item", item);		
		} else if(dealName.equals("ac")) {
			ACItem item = store.getItem(itemId);
			mav.addObject("item", item);			
		} else {
			GBItem item = store.getGBItem(itemId);
			mav.addObject("item", item);	
		}
		
		return mav;
	}

}
