package com.fp.pi.products;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fp.pi.member.Member;

@Controller
public class CartContoller {
	
	@Autowired
	private CartDAO cDAO;
	
	@RequestMapping(value = "/add.cart", method = RequestMethod.GET)
	public @ResponseBody int addCart(HttpSession session, Cart cart) {
		
		Member member = (Member) session.getAttribute("loginMember");
		cart.setM_email(member.getM_email());
		
		System.out.println(cart.getM_email());
		System.out.println(cart.getP_no());
		if (cDAO.cartMemCheck(cart) != 0) {
			System.out.println("cp0");			
			return 2;
		}
		cDAO.cartInsert(cart);
		System.out.println("cp1");
		return 1;
	}
	
	@RequestMapping(value = "/cart.go", method = RequestMethod.GET)
	public String cartGo(Cart cart, HttpSession session, HttpServletRequest request) {
		
		Member member = (Member) session.getAttribute("loginMember");
		cart.setM_email(member.getM_email());
		
		cDAO.getCart(cart, request);
		request.setAttribute("contentPage", "products/cart.jsp");
		return "index";  
	}
	
	@RequestMapping(value = "/cart.del.all", method = RequestMethod.GET)
	public String cartDelAll(Cart cart, HttpSession session, HttpServletRequest request) {
		
		Member member = (Member) session.getAttribute("loginMember");
		cart.setM_email(member.getM_email());
		
		cDAO.delCartAll(cart, request);
		request.setAttribute("contentPage", "products/cart.jsp");
		return "index";  
	}
	
	@RequestMapping(value = "/cart.del", method = RequestMethod.GET)
	public String cartDel(Cart cart, HttpSession session, HttpServletRequest request) {
		
		Member member = (Member) session.getAttribute("loginMember");
		cart.setM_email(member.getM_email());
		
		cDAO.delCart(cart, request);
		request.setAttribute("contentPage", "products/cart.jsp");
		return "index";  
	}
	
	
}
