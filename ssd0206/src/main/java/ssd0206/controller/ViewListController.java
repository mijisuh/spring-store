package ssd0206.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ssd0206.domain.ACItem;
import ssd0206.domain.Category;
import ssd0206.domain.GBItem;
import ssd0206.domain.SalesItem;
import ssd0206.service.StoreFacade;

@Controller
public class ViewListController {
	
	@Autowired
	private StoreFacade store;
	public void setStore(StoreFacade store) {
		this.store = store;
	}
	
	@RequestMapping("/shop/{dealName}/list.do")
	private ModelAndView list(HttpServletRequest request, 
									@PathVariable String dealName,
									@RequestParam("dealId") int dealId,
									@RequestParam("catId") int catId) {
		//List<Category> categoryList = store.getCategoryListByDealName(dealName);
		
		request.setAttribute("dealName", dealName);
		
		List<Category> categoryList = store.getCategoryList(dealId);
		String viewName = dealName + "/list";
		
		ModelAndView mav = new ModelAndView(viewName);
		mav .addObject("categories", categoryList);
		
		
		if(dealName.equals("sales")) {
			List<SalesItem> itemList = null;


			// 전체 상품 조회
			if (catId == -1) {
				itemList = store.getSalesItemList();
			} else {
				itemList = store.getSalesItemListByCatId(catId);
			}
			mav.addObject("itemList", itemList);
		} else if(dealName.equals("ac")) {
			List<ACItem> itemList = null;
			if (catId == -1) {
				itemList = store.getACItemList();
			} else {
				itemList = store.getACItemListByCatId(catId);		
			}
			mav.addObject("itemList", itemList);	
		} else {
			List<GBItem> itemList = null;
			if (catId == -1) {
				itemList = store.getGBItemList();
				mav.addObject("itemList", itemList);
			} else {
				itemList = store.getGBItemListByCatId(catId);		
				mav.addObject("itemList", itemList);	
			}
		}
		
		return mav;
	}
}

