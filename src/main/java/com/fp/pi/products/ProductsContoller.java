package com.fp.pi.products;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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
	
	@RequestMapping(value = "/products.sort", method = RequestMethod.GET, produces = "application/xml; charset=utf-8")
	public @ResponseBody Products ProductsMainSort(ProductSort ps) {
		Products products = pDAO.getProductsSort(ps);
		return products;
	}
	
	//상품 디테일 페이지
	@RequestMapping(value = "/product.detail", method = RequestMethod.GET)
	public String ProductDetail(Product p, HttpServletRequest request) {
		pDAO.getProductDetail(p, request);
		request.setAttribute("contentPage", "products/productDetail.jsp");
		
		return "index";  
	}
	
	@RequestMapping(value = "/product.buycount", method = RequestMethod.GET)
	public String ProductBuyCount(Product p, HttpServletRequest request) {
		pDAO.IncreaseBuyCount(p, request);
		pDAO.getProductDetail(p, request);
		request.setAttribute("contentPage", "products/productDetail.jsp");
		
		return "index";  
	}
}
