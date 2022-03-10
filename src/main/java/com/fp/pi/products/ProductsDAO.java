package com.fp.pi.products;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

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
		
		System.out.println(ps.getP_sort());
		System.out.println(ps.getP_type());
		
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
		
		product.get(0).getP_name();
		
		Products p = new Products(product);
		return p;
	}

	public void regProduct(Product p, HttpServletRequest request) {
		try {
			String saveDerectory = request.getSession().getServletContext().getRealPath("resources/file");
			MultipartRequest mr = new MultipartRequest(request, saveDerectory, 1024 * 1024 * 30, "UTF-8", new DefaultFileRenamePolicy());
			
			p.setP_name(mr.getParameter("p_name"));
			int p_price = Integer.parseInt(mr.getParameter("p_price"));
			p.setP_price(p_price);
			p.setP_type(mr.getParameter("p_type"));
			p.setP_info(mr.getParameter("p_info"));
			p.setP_img(mr.getFilesystemName("p_img"));
			
			System.out.println(mr.getFilesystemName("p_img"));
			
			if (ss.getMapper(ProductsMapper.class).regProduct(p)==1) {
				System.out.println("등록 성공");
			} else {
				System.out.println("등록 실패");			
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
