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
		request.setAttribute("myCart", p);

	}

	public void delCartAll(Cart cart, HttpServletRequest request) {

		try {
			
			if (ss.getMapper(CartMapper.class).delCartAll(cart) >= 1) {
				System.out.println("삭제 성공");
			} else {
				System.out.println("삭제 실패");			
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void delCart(Cart cart, HttpServletRequest request) {
		
		try {
			
			if (ss.getMapper(CartMapper.class).delCart(cart) == 1) {
				System.out.println("삭제 성공");
			} else {
				System.out.println("삭제 실패");			
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
