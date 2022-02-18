package com.fp.pi.products;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductsDAO {
	
	@Autowired
	private SqlSession ss;
	
	public void getProducts(HttpServletRequest request) {
		try {
			request.setAttribute("products", ss.getMapper(ProductsMapper.class).getProducts());			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void getProductDetail(HttpServletRequest request) {
		
	}
	
}
