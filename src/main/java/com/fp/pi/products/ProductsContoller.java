package com.fp.pi.products;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ProductsContoller {
	
	@Autowired
	private ProductsDAO pDAO;
	
	@RequestMapping(value = "/products.go", method = RequestMethod.GET)
	public String ProductsMain(HttpServletRequest request) {
		pDAO.getProducts(request);
		request.setAttribute("contentPage", "products/productsMain.jsp");
		
		return "index";  
	}
	
	@RequestMapping(value = "/product.detail", method = RequestMethod.GET)
	public String ProductDetail(HttpServletRequest request) {
		pDAO.getProductDetail(request);
		request.setAttribute("contentPage", "products/productsMain.jsp");
		
		return "index";  
	}
}
