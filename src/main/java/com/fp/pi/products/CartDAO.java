package com.fp.pi.products;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartDAO {
	
	@Autowired
	private SqlSession ss;

	public int cartMemCheck(Cart cart) {
		
		int check = ss.getMapper(CartMapper.class).cartCheck(cart);
		return check;
	}

	public void cartInsert(Cart cart) {
		
		try {
			
			if (ss.getMapper(CartMapper.class).addCart(cart) == 1) {
				System.out.println("등록 성공");
			} else {
				System.out.println("등록 실패");			
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public void getCart(Cart cart, HttpServletRequest request) {
		List<Product> p = ss.getMapper(CartMapper.class).getcart(cart);
		System.out.println(p.get(0).getP_name());
		System.out.println(p.get(1).getP_name());
		request.setAttribute("myCart", p);
	}

}
