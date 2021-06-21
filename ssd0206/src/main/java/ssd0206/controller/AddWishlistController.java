package ssd0206.controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import ssd0206.service.StoreFacade;

@Controller
public class AddWishlistController {

	@Autowired
	private StoreFacade store;
	public void setStore(StoreFacade store) {
		this.store = store;
	}
	
	@RequestMapping("/shop/ac/addWishlist.do")
	private void insertInterestAC (@RequestParam("itemId") int itemId,
									@SessionAttribute("userSession") UserSession user,
									HttpServletResponse response) throws Exception {
		response.setContentType("text/html; charset=UTF-8");
		 
		PrintWriter out = response.getWriter();
		 
		if (!store.isRegisteredInterestAC(itemId, user.getAccount().getUserId())) {
			store.insertInterestAC(itemId, user.getAccount().getUserId());
			out.println("<script>alert('위시리스트 등록 완료.'); history.go(-1);</script>");
		} else {
			out.println("<script>alert('이미 등록되어 있습니다.'); history.go(-1);</script>");
		}
		out.flush();
	}
	
	@RequestMapping("/shop/gb/addWishlist.do")
	private void insertInterestGB (@RequestParam("itemId") int itemId,
									@SessionAttribute("userSession") UserSession user,
									HttpServletResponse response) throws Exception {
		response.setContentType("text/html; charset=UTF-8");
		 
		PrintWriter out = response.getWriter();
		 
		if (!store.isRegisteredInterestGB(itemId, user.getAccount().getUserId())) {
			store.insertInterestGB(itemId, user.getAccount().getUserId());
			out.println("<script>alert('위시리스트 등록 완료.'); history.go(-1);</script>");
		} else {
			out.println("<script>alert('이미 등록되어 있습니다.'); history.go(-1);</script>");
		}
		out.flush();
	}
}
