package ssd0206.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import ssd0206.domain.Cart;
import ssd0206.domain.SalesItem;
import ssd0206.service.StoreFacade;


@Controller
@SessionAttributes("sessionCart")
public class AddItemToCartController { 

	private StoreFacade store;

	@Autowired
	public void setStore(StoreFacade store) {
		this.store = store;
	}

	@ModelAttribute("sessionCart")
	public Cart createCart() {
		return new Cart();
	}
	
	@RequestMapping("/shop/addItemToCart.do")
	public ModelAndView handleRequest(
			@RequestParam("workingItemId") int workingItemId,
			@ModelAttribute("sessionCart") Cart cart 
			) throws Exception {
		if (cart.containsItemId(workingItemId)) {
			cart.incrementQuantityByItemId(workingItemId);
		}
		else {
			boolean isInStock = this.store.isItemInStock(workingItemId);
			SalesItem item = this.store.getSalesItem(workingItemId);
			cart.addItem(item, isInStock);
		}
		return new ModelAndView("Cart", "cart", cart);
	}
}