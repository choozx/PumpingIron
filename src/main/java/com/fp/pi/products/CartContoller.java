package com.fp.pi.products;

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
	
	@RequestMapping(value = "/add.cart", method = RequestMethod.GET, produces = "application/xml; charset=utf-8")
	public @ResponseBody int addCart(HttpSession session, Cart cart) {
		
		Member member = (Member) session.getAttribute("loginMember");
		cart.setM_email(member.getM_email());
		
		if (cDAO.cartMemCheck(cart) != 0) {
			System.out.println("cp0");			
			return 2;
		}
		cDAO.cartInsert(cart);
		System.out.println("cp1");
		return 1;
	}
	
	
}
