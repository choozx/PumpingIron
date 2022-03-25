package com.fp.pi;

import javax.servlet.http.HttpServletRequest;



import org.springframework.stereotype.Controller;

public class SiteOption3 {

	private int snsCountPerpage; // 한 페이지 개수 
	// 3, 10, 20 
	
	public SiteOption3() {
		// TODO Auto-generated constructor stub
	}
	public SiteOption3(int snsCountPerpage) {
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
}
