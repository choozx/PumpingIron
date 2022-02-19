package com.fp.pi.info;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class infoController {
	
	@RequestMapping(value = "/info.go", method = RequestMethod.GET)
	public String infoGo(HttpServletRequest req) {
		
		req.setAttribute("contentPage", "info/info.jsp");
		return "index";
	}
	
	@RequestMapping(value = "/chest.go", method = RequestMethod.GET)
	public String chestGo(HttpServletRequest req) {
		
		req.setAttribute("contentPage", "info/chest.jsp");
		return "index";
	}
	@RequestMapping(value = "/back.go", method = RequestMethod.GET)
	public String backGo(HttpServletRequest req) {
		
		req.setAttribute("contentPage", "info/back.jsp");
		return "index";
	}
	@RequestMapping(value = "/shoulder.go", method = RequestMethod.GET)
	public String shoulderGo(HttpServletRequest req) {
		
		req.setAttribute("contentPage", "info/shoulder.jsp");
		return "index";
	}
	@RequestMapping(value = "/arm.go", method = RequestMethod.GET)
	public String armGo(HttpServletRequest req) {
		
		req.setAttribute("contentPage", "info/arm.jsp");
		return "index";
	}
	@RequestMapping(value = "/leg.go", method = RequestMethod.GET)
	public String legGo(HttpServletRequest req) {
		
		req.setAttribute("contentPage", "info/leg.jsp");
		return "index";
	}
	@RequestMapping(value = "/abs.go", method = RequestMethod.GET)
	public String absGo(HttpServletRequest req) {
		
		req.setAttribute("contentPage", "info/abs.jsp");
		return "index";
	}

}
