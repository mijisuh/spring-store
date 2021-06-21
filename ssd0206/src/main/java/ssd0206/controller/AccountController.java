package ssd0206.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.util.WebUtils;

import ssd0206.domain.Category;
import ssd0206.domain.Product;
import ssd0206.service.AccountFormValidator;
import ssd0206.service.StoreFacade;

@Controller
@RequestMapping({"/shop/newAccount.do","/shop/editAccount.do"})
public class AccountController {
	
	@Value("account/accountForm")
	private String formViewName;
	
	@Autowired
	private StoreFacade store;
	public void setStore(StoreFacade store) {
		this.store = store;
	}

	@Autowired
	private AccountFormValidator validator;
	public void setValidator(AccountFormValidator validator) {
		this.validator = validator;
	}
		
	@ModelAttribute("accountForm")
	public AccountForm formBackingObject(HttpServletRequest request) throws Exception {
		UserSession userSession = (UserSession) WebUtils.getSessionAttribute(request, "userSession");
		if (userSession != null) {	// edit an existing account
			return new AccountForm(
					store.getAccount(userSession.getAccount().getUserId()));
		}
		else {	// create a new account
			return new AccountForm();
		}
	}

//	@ModelAttribute("categories")
//	public List<Category> getCategoryList() {
//		return store.getCategoryList();
//	}
	
	@RequestMapping(method = RequestMethod.GET)
	public String showForm() {
		return formViewName;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String onSubmit(
			HttpServletRequest request, HttpSession session,
			@ModelAttribute("accountForm") AccountForm accountForm,
			BindingResult result) throws Exception {

//		if (request.getParameter("account.listOption") == null) {
//			accountForm.getAccount().setListOption(false);
//		}
//		if (request.getParameter("account.bannerOption") == null) {
//			accountForm.getAccount().setBannerOption(false);
//		}
		
		validator.validate(accountForm, result);
		
		if (result.hasErrors()) return formViewName;
		try {
			if (accountForm.isNewAccount()) {
				store.insertAccount(accountForm.getAccount());
				return "account/successNewAccount";  
			}
			else {
				store.updateAccount(accountForm.getAccount());
				return formViewName;  
			}
		}
		catch (DataIntegrityViolationException ex) {
			result.rejectValue("account.username", "USER_ID_ALREADY_EXISTS",
					"User ID already exists: choose a different ID.");
			return formViewName; 
		}
		
//		UserSession userSession = new UserSession(store.getAccount(accountForm.getAccount().getUserId()));
//		PagedListHolder<Product> myList = new PagedListHolder<Product>(store.getProductListByCategory(accountForm.getAccount().getFavouriteCategoryId()));
//		myList.setPageSize(4);
//		userSession.setMyList(myList);
//		session.setAttribute("userSession", userSession);
		
	}
}
