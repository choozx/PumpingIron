package com.fp.pi;

import javax.servlet.http.HttpServletRequest;



import org.springframework.stereotype.Controller;

public class SiteOption {

	private int snsCountPerpage; // 한 페이지 개수 
	// 3, 10, 20 
	
	public SiteOption() {
		// TODO Auto-generated constructor stub
	}
	public SiteOption(int snsCountPerpage) {
		super();
		this.snsCountPerpage = snsCountPerpage;
	}
	public int getSnsCountPerpage() {
		return snsCountPerpage;
	}
	public void setSnsCountPerpage(int snsCountPerpage) {
		this.snsCountPerpage = snsCountPerpage;
	}
	public static void clearSearch(HttpServletRequest req) {
		req.getSession().setAttribute("search", null);
		
	}
	public static void clearSearch1(HttpServletRequest req) {
		req.getSession().setAttribute("searchEvent", null);
		
	}
	
	public static void clearSearch2(HttpServletRequest req) {
		req.getSession().setAttribute("searchCustomerService", null);
		
	}
	
	public static void clearSearch3(HttpServletRequest req) {
		req.getSession().setAttribute("searchRequest", null);
		
	}
	
}
