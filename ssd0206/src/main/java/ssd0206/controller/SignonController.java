package ssd0206.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ssd0206.domain.Account;
import ssd0206.service.StoreFacade;

import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

@Controller
@SessionAttributes("userSession")
public class SignonController { 

	private StoreFacade store;
	@Autowired
	public void setStore(StoreFacade store) {
		this.store = store;
	}

	@RequestMapping("/shop/signon.do")
	public ModelAndView handleRequest(HttpServletRequest request,
			@RequestParam("accountName") String accountName,
			@RequestParam("password") String password,
			@RequestParam(value="forwardAction", required=false) String forwardAction,
			Model model) throws Exception {
		Account account = store.getAccount(accountName, password);
	
		if (account == null) {
			return new ModelAndView("account/signonForm", "message", "가입되지 않은 아이디거나, 잘못된 비밀번호입니다.");
		} else {
			UserSession userSession = new UserSession(account);
//			PagedListHolder<Product> myList = new PagedListHolder<Product>(this.store.getProductListByCategory(account.getFavouriteCategoryId()));
//			myList.setPageSize(4);
//			userSession.setMyList(myList);
			model.addAttribute("userSession", userSession);
			
			if (accountName.equals("admin")) {
				return new ModelAndView("admin/home");
			} else if (forwardAction != null) 
				return new ModelAndView("redirect:" + forwardAction);
			else 
				return new ModelAndView("home");
		}
	}
	
	@RequestMapping("/shop/admin/home.do")
	public String viewAdminHome() {
		return "admin/home";
	}
	
}
