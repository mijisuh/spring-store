package ssd0206.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ssd0206.domain.Account;
import ssd0206.service.StoreFacade;

@Controller
@RequestMapping("/shop/admin/accountList.do")
public class AdminController {

	@Autowired
	private StoreFacade store;
	public void setPetStore(StoreFacade store) {
		this.store = store;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView showList() {
		List<Account> accountList = store.getAccountList();
		ModelAndView mav = new ModelAndView("admin/accountList");
		mav.addObject("accounts", accountList);
		return mav;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView deleteAccount(@RequestParam("userId") String userId) {
		if (!userId.equals("0")) {
			store.deleteAccountByUserId(userId);
		}
		
		List<Account> accountList = store.getAccountList();
		ModelAndView mav = new ModelAndView("admin/accountList");
		mav.addObject("accounts", accountList);
		return mav;
	}
	
}
