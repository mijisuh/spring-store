package ssd0206.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import ssd0206.domain.ACItem;
import ssd0206.domain.Bid;
import ssd0206.domain.ItemCat;
import ssd0206.service.StoreFacade;
import ssd0206.service.StoreImpl;

@Controller
@SessionAttributes("acForm")
public class ACItemController {
	
	private static final String ACREG_VIEW = "ac/acReg";
	private static final String ACREGCONFIRM_VIEW = "ac/acRegConfirm";	
	private static final String ACREGISTERD_VIEW = "ac/acRegistered";
	
	@Autowired
	private StoreFacade storeimpl;
	public void setstoreimpl(StoreFacade storeimpl) {
		this.storeimpl = storeimpl;
	}
	
	@ModelAttribute("ItemCat")
	public ItemCat[] referenceItemCat() {
		return ItemCat.values();
	}
		
	
//-------------경매 아이템 등록-------------------------------------------------------	
	
	@ModelAttribute("acForm")
	public ACForm form(HttpSession session) {
		UserSession user = (UserSession) session.getAttribute("userSession");
		ACForm acForm = new ACForm(storeimpl.getAccount(user.getAccount().getUserId()).getUsername()); 
		return acForm;	 
	}
	
	@GetMapping("/shop/ac/acReg.do")
	public String acReg() {
		return   ACREG_VIEW; 
	}
	
	
	@PostMapping("/shop/ac/acRegConfirm.do")
	public String acRegConfirm(
			@Valid @ModelAttribute("acForm")ACForm acForm, BindingResult result, HttpSession session) {
		System.out.println("command 객체: " + acForm);
		if (result.hasFieldErrors("name")||
			result.hasFieldErrors("acTime")||
			result.hasFieldErrors("minPrice")) {			
			return  ACREG_VIEW;	
		}		
		return ACREGCONFIRM_VIEW;		
	}
	
	@PostMapping("/shop/ac/acRegisterd.do")
	public String acRegisterd(
			@ModelAttribute("acForm") ACForm acForm, BindingResult result,
			Model model, SessionStatus sessionStatus) throws ParseException {	
			
		ACItem acItem;
		DateFormat fm = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		acItem = storeimpl.acItem(acForm);
		storeimpl.insertAcItem(acItem);
		
		
		storeimpl.ACScheduler(fm.parse(acForm.getAcTime()), acItem.getAcItemId());
		
		model.addAttribute("newACItem", acItem);
	
		sessionStatus.setComplete();		
		return ACREGISTERD_VIEW;
	}
	
	@GetMapping("/shop/ac/acGoview.do")
	public String acGoView() {
		return "redirect:/shop/ac/list.do?dealId=1&catId=-1"; 
	}
	
	
//-------------경매 아이템 수정-------------------------------------------------------	

	
	@GetMapping("/shop/ac/acUpdate.do")
	public ModelAndView updateAC(@RequestParam(value="acItemId")int acItemId)
	{
		ACItem acItem = storeimpl.getItem(acItemId);
		ACForm acUpdateForm = new ACForm(acItem);
		
		return new ModelAndView("ac/acUpdate", "acUpdateForm", acUpdateForm);
	}
	
	@PostMapping("/shop/ac/acUpdateDone.do")
	public String updateAC(@ModelAttribute("acUpdateForm")ACForm acForm) throws ParseException
	{
		ACItem acItem = storeimpl.acItem(acForm);
		
		storeimpl.updateAcItem(acItem);
		
		return "redirect:/shop/ac/list.do?dealId=1&catId=-1"; 
		
	}
	
//-------------경매 아이템 삭제-------------------------------------------------------	


	@GetMapping("/shop/ac/acDelete.do")
	public String deleteAC(@RequestParam(value="acItemId")int acItemId)
	{
		storeimpl.deleteAcItem(acItemId);
	
		return "redirect:/shop/ac/list.do?dealId=1&catId=-1"; 
		
	}
	
}





