package ssd0206.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ssd0206.domain.ACItem;
import ssd0206.domain.DealType;
import ssd0206.domain.GBItem;
import ssd0206.domain.SalesItem;
import ssd0206.service.StoreFacade;

@Controller
public class ViewMainController {
	
	@Value("home")
	private String mainViewName;
	
	@Autowired
	private StoreFacade store;
	public void setStore(StoreFacade store) {
		this.store = store;
	}
	
	@RequestMapping({"/shop/home.do"})
	private ModelAndView getDealType(HttpServletRequest request) {
		List<DealType> dealTypeList = store.getDealTypeList();
		HttpSession session = request.getSession();
		
		session.setAttribute("dealTypes", dealTypeList);
		
		List<SalesItem> salesItems = store.getSalesItemList();
		List<ACItem> acItems = store.getACItemList();
		List<GBItem> gbItems = store.getGBItemList();
		
		session.setAttribute("salesItems", salesItems);
		session.setAttribute("acItems", acItems);
		session.setAttribute("gbItems", gbItems);
		
		return new ModelAndView(mainViewName);
	}

}
