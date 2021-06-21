package ssd0206.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.WebUtils;

import ssd0206.domain.GBItem;
import ssd0206.domain.ItemCat;
import ssd0206.service.StoreFacade;

@Controller
@SessionAttributes("gbForm")
public class GBItemController {
	
	@Autowired
	private StoreFacade store;
	public StoreFacade getStore() {	return store; }
	public void setStore(StoreFacade store) { this.store = store; }
	
	@ModelAttribute("ItemCat")
	public ItemCat[] referenceItemCat() {
		return ItemCat.values();
	}
	
	@ModelAttribute("gbForm")
	public GBForm form() {
		GBForm gbForm = new GBForm(); 
		 return gbForm;	 
	}
	
	@GetMapping("/shop/gb/gbReg.do")
	public String gbReg() {
		return "gb/gbReg"; 
	}
	
	@PostMapping("/shop/gb/gbRegConfirm.do")
	public String gbRegConfirm(
			@Valid @ModelAttribute("gbForm")GBForm gbForm, BindingResult result, HttpSession session) {
		System.out.println("command °´Ã¼: " + gbForm);
		if (result.hasFieldErrors("minPrice")) {			
			return "gb/gbReg";	
		}		
		return "gb/gbRegConfirm";		
	}
	
	@PostMapping("/shop/gb/gbRegisterd.do")
	public String gbRegisterd(
			@ModelAttribute("gbForm") GBForm gbForm, BindingResult result,
			Model model, SessionStatus sessionStatus) throws ParseException {	
			
		GBItem gbItem;
		
		gbItem = store.gbItem(gbForm);
		store.insertGBItem(gbItem);
		
		model.addAttribute("newGBItem", gbItem);
	
		sessionStatus.setComplete();		
		return "gb/gbRegistered";
	}
	
	@PostMapping("/shop/gb/gbUpdateDone.do")
	public String updateGB(@ModelAttribute("gbUpdateForm")GBForm gbForm) throws ParseException
	{
		GBItem gbItem;
		gbItem = store.gbItem(gbForm);
		
		store.updateGBItem(gbItem);
		
		return "gb/list"; 
	}
	
	@GetMapping("/shop/gb/gbDelete.do")
	public String deleteAC(@RequestParam(value="gbItemId")int gbItemId)
	{
		store.deleteGBItem(gbItemId);
	
		return "gb/list";
	}
}
