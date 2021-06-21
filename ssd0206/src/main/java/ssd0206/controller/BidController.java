package ssd0206.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import ssd0206.domain.ACItem;
import ssd0206.domain.Bid;
import ssd0206.service.StoreFacade;
import ssd0206.service.StoreImpl;

@Controller
@SessionAttributes("bidForm")
public class BidController {	
	private static final String BIDFORM_VIEW = "ac/bidForm";
	private static final String BIDFORM_COMPLELTE = "ac/bidDone";
	
	@Autowired
	private StoreFacade storeimpl;
	public void setstoreimpl(StoreFacade storeimpl) {
		this.storeimpl = storeimpl;
	}
	
	
	@ModelAttribute("bidForm")
	public BidForm form(HttpSession session){
		UserSession user = (UserSession) session.getAttribute("userSession");
		BidForm bidForm = new BidForm(user.getAccount().getUserId());
		return bidForm;
	}
	
	@GetMapping("/shop/ac/bidReg.do")
	public String bidReg(@RequestParam(value="acItemId")String acItemId, @ModelAttribute("bidForm") BidForm bidForm) {
		
		bidForm.setACItemId(acItemId);
		return BIDFORM_VIEW;
	}
	

	@PostMapping("/shop/ac/bidComplete.do") 
	public String bidRegisterd(@ModelAttribute("bidForm")BidForm bidForm, SessionStatus sessionStatus, Model model) {
		
		Bid bid;
		bid = storeimpl.bid(bidForm);
		
		model.addAttribute("newBid", bid);
	
		sessionStatus.setComplete();
		return BIDFORM_COMPLELTE;
	}

}
