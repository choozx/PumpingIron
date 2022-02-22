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
			String choose = request.getParameter("products");
			System.out.println(choose);
			request.setAttribute("products", ss.getMapper(ProductsMapper.class).getProducts(choose));			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void getProductDetail(Product p, HttpServletRequest request) {
		try {
			request.setAttribute("productDetail", ss.getMapper(ProductsMapper.class).getProduct(p));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
