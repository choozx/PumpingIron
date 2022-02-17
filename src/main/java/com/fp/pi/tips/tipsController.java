package com.fp.pi.tips;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class tipsController {
	@RequestMapping(value = "/tips.go", method = RequestMethod.GET)
	public String indexGo(HttpServletRequest req) {
		
		req.setAttribute("contentPage", "tips/tips.jsp");
		return "index";
	}

	
	@RequestMapping(value = "/write.go", method = RequestMethod.GET)
	public String writeGo(HttpServletRequest req) {
		
		req.setAttribute("contentPage", "tips/write.jsp");
		return "index";
	}

	@RequestMapping(value = "/watchContents.go", method = RequestMethod.GET)
	public String watchGo(HttpServletRequest req) {
		
		req.setAttribute("contentPage", "tips/watchContents.jsp");
		return "index";
	}
	

}
