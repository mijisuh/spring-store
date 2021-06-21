package ssd0206.controller;

import java.text.ParseException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
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

import ssd0206.domain.ACItem;
import ssd0206.domain.ItemCat;
import ssd0206.domain.SalesItem;
import ssd0206.service.StoreFacade;

@Controller
@SessionAttributes("salesForm")
public class SalesItemController {
	
	@Value("sales/salesItemForm")
	private String formViewName;
	@Value("sales/registerSalesItem")
	private String successViewName;

	@Autowired
	private StoreFacade store;

	public void setStore(StoreFacade store) {
		this.store = store;
	}

	@ModelAttribute("ItemCat")
	public ItemCat[] referenceItemCat() {
		return ItemCat.values();
	}
	
	
	@ModelAttribute("salesForm")
	public SalesForm newSalesForm() {
		SalesForm salesForm = new SalesForm();
		return salesForm;
	}
	
	@GetMapping("/shop/sales/insert.do")
	public String salesItemRegister() {
		return formViewName; 
	}
	
	@PostMapping("/shop/sales/salesRegConfirm.do")
	public String salesRegConfirm(
			@ModelAttribute("salesForm")SalesForm salesForm, BindingResult result) {
		System.out.println("command 객체: " + salesForm);
				
		return "sales/salesRegConfirm";		
	}
	
	@PostMapping("/shop/sales/salesRegistered.do")
	public String salesRegisterd(
			@ModelAttribute("salesForm") SalesForm salesForm, BindingResult result,
			Model model, SessionStatus sessionStatus) throws ParseException {	
			
		SalesItem salesItem;
		
		salesItem = store.salesItem(salesForm);
		
		model.addAttribute("newSalesItem", salesItem);
	
		sessionStatus.setComplete();		
		return "sales/salesRegistered";
	}
	
	
	/*
	
	@RequestMapping("/sales/update.do")
	public String update() {
		return "sales/updateSalesItem";
	}

	
	@RequestMapping("/sales/updateSalesItem.do")
	public String updateSalesItem(SalesItem item) throws Exception {
		store.updateSalesItem(item);
		return "redirect:/sales/salesList.do";
	}

	
	@RequestMapping("/sales/deleteSalesItem.do")
	public String deleteSalesItem(@RequestParam int itemId) throws Exception {
		store.deleteSalesItem(itemId);
		return "redirect:/sales/salesList.do";
	}
	 */
}
