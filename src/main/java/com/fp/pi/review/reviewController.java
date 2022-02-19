package com.fp.pi.review;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class reviewController {
	
	@RequestMapping(value = "/review.go", method = RequestMethod.GET)
	public String reviewGo(HttpServletRequest req) {
		
		req.setAttribute("contentPage", "review/review.jsp");
		return "index";
	}

}
