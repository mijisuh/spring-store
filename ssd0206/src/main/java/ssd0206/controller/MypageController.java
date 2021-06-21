package ssd0206.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

import ssd0206.domain.ACItem;
import ssd0206.domain.GBItem;
import ssd0206.domain.Interest;
import ssd0206.domain.SalesItem;
import ssd0206.service.StoreFacade;

@Controller
public class MypageController {
	
	@Autowired
	private StoreFacade store;
	public void setStore(StoreFacade store) {
		this.store = store;
	}
	
	@GetMapping("/shop/{deal}/wishList.do")
	private ModelAndView getWishList(HttpSession session, @PathVariable String deal) {
		UserSession user = (UserSession) session.getAttribute("userSession");
		List<Interest> Interests = null;
		
		if(deal.equals("ac")) {
			Interests = store.getInterestACs(user.getAccount().getUserId());
		} else {
			Interests = store.getInterestGBs(user.getAccount().getUserId());
		}
		
		ModelAndView mav = new ModelAndView("mypage/wishList");
		mav.addObject("interests", Interests);
		mav.addObject("deal", deal);
		
		return mav;
	}
	
	@RequestMapping("/shop/listSelling.do")
	private ModelAndView getSellingInfo(@SessionAttribute("userSession") UserSession user) {
		List<SalesItem> salesItems = store.getSalesItemBySuppId(user.getAccount().getUserId());
		List<ACItem> acItems = store.getACItemBySuppId(user.getAccount().getUserId());
		List<GBItem> gbItems = store.getGBItemBySuppId(user.getAccount().getUserId());
		
		ModelAndView mav = new ModelAndView("selling/list");
		mav.addObject("selligSalesItems", salesItems);
		mav.addObject("selligACItems", acItems);
		mav.addObject("selligGBItems", gbItems);
		
		return mav;
		
	}
	
}
