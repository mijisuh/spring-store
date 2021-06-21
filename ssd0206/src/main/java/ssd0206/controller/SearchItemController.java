package ssd0206.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ssd0206.domain.ACItem;
import ssd0206.domain.GBItem;
import ssd0206.domain.SalesItem;
import ssd0206.service.StoreFacade;

@Controller
public class SearchItemController {
	
	@Autowired
	private StoreFacade store;
	public void setStore(StoreFacade store) {
		this.store = store;
	}
	
	@RequestMapping("/shop/searchItems.do")
	private ModelAndView search (@RequestParam("keyword") String keyword) {
		List<SalesItem> saleItems = store.searchSalesItemByKeyword(keyword);
		List<ACItem> acItems = store.searchACItemByKeyword(keyword);
		List<GBItem> gbItems = store.searchGBItemByKeyword(keyword);
		
		ModelAndView mav = new ModelAndView("etcs/searchResult");
		
		mav.addObject("keyword", keyword);
		mav.addObject("resultSalesItems", saleItems);
		mav.addObject("resultACItems", acItems);
		mav.addObject("resultGBItems", gbItems);
		
		return mav;
	}

}
