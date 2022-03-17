package com.fp.pi.products;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

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

}
