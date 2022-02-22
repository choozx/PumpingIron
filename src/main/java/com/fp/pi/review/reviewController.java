package com.fp.pi.review;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class reviewController {
	
	@RequestMapping(value = "/review.go", method = RequestMethod.GET)
	public String reviewGo(HttpServletRequest req) {
		
		req.setAttribute("contentPage", "review/review2.jsp");
		return "index";
	}
	@RequestMapping(value = "/reviewWrite.go", method = RequestMethod.GET)
	public String reviewWriteGo(HttpServletRequest req) {
		
		req.setAttribute("contentPage", "review/reviewWrite.jsp");
		return "index";
	}
	@RequestMapping(value = "/reviewWatch.go", method = RequestMethod.GET)
	public String reviewWratchGo(HttpServletRequest req) {
		
		req.setAttribute("contentPage", "review/reviewWatch.jsp");
		return "index";
	}

}
