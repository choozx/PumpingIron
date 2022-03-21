package com.fp.pi.products;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fp.pi.SiteOption;
import com.fp.pi.TokenMaker;

@Controller
public class ProductsContoller {
	
	@Autowired
	private ProductsDAO pDAO;
	
	@RequestMapping(value = "/products.go", method = RequestMethod.GET)
	public String ProductsMain(HttpServletRequest request) {
		pDAO.getProducts(1, request);
		SiteOption.clearSearch(request);
		request.setAttribute("contentPage", "products/productsMain.jsp");
		
		return "index";
	}
	
	@RequestMapping(value = "/products.sort", method = RequestMethod.GET, produces = "application/xml; charset=utf-8")
	public @ResponseBody Products ProductsMainSort(ProductSort ps, HttpServletRequest request) {
		Products pproducts = pDAO.getProductsSort(ps, request);
		return pproducts;
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
	
	@RequestMapping(value = "/regProduct.go", method = RequestMethod.GET)
	public String regProductGo(HttpServletRequest request) {
		request.setAttribute("contentPage", "products/regProduct.jsp");
		
		return "index";  
	}
	
	@RequestMapping(value = "/regProduct.do", method = RequestMethod.POST)
	public String regProductDo(Product p, HttpServletRequest request) {
		
		pDAO.regProduct(p, request);
		request.setAttribute("contentPage", "home.jsp");
		
		return "index";  
	}
	
	@RequestMapping(value = "/deletePeoduct.do", method = RequestMethod.GET)
	public String deleteProduct(HttpServletRequest request) {
		
		pDAO.delProduct(request);
		request.setAttribute("contentPage", "home.jsp");
		
		return "index";  
	}
	
	@RequestMapping(value = "/updateProduct.go", method = RequestMethod.GET)
	public String updateProduct(Product p, HttpServletRequest request) {
		pDAO.getProductDetail(p, request);
		request.setAttribute("contentPage", "products/updateProduct.jsp");
		return "index";  
	}
	
	@RequestMapping(value = "/updateProduct.do", method = RequestMethod.POST)
	public String updateProductDo(Product p, HttpServletRequest request) {
		
		pDAO.updateProduct(p, request);
		request.setAttribute("contentPage", "home.jsp");
		
		return "index";  
	}
}
