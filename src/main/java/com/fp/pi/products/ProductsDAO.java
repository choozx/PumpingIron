package com.fp.pi.products;

import java.util.List;

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
			String type = request.getParameter("products");
			request.setAttribute("products", ss.getMapper(ProductsMapper.class).getProducts(type));
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

	public void IncreaseBuyCount(Product p, HttpServletRequest request) {
		
		try {
			if (ss.getMapper(ProductsMapper.class).increaseBuyCount(p) == 1) {
				request.setAttribute("result", "성공");
			} else {
				request.setAttribute("result", "실패");
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("result", "실패");
		}
	}

	public Products getProductsSort(ProductSort ps) {
		
		if (ps.getP_sort().equals("p_priceToLow")) {
			ps.setP_sort("p_price");
			ps.setOrder("ASC");
		} else if(ps.getP_sort().equals("p_priceTohigh")) {
			ps.setP_sort("p_price");
			ps.setOrder("DESC");
		} else if(ps.getP_sort().equals("p_cnt")) {
			ps.setOrder("DESC");			
		}
		
		
		List<Product> product = ss.getMapper(ProductsMapper.class).getProductSort(ps);
		
		Products p = new Products(product);
		return p;
	}
	
}
