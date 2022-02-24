package com.fp.pi.infomap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class InfoMapController {

	@RequestMapping(value = "/infoMap.go", method = RequestMethod.GET)
	public String infoMapGo(HttpServletRequest request) {
		
		request.setAttribute("contentPage", "infoMap/infoMap.jsp");
		
		return "index";
	}
	
	
	
	@RequestMapping(value = "/priceInfo.go", method = RequestMethod.GET)
	public String priceInfoGo(HttpServletRequest request) {
		
		 request.setAttribute("contentPage", "infoMap/priceInfo.jsp");
		
		return "index";
	}
	
	
}
