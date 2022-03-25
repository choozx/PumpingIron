package com.fp.pi;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fp.pi.customerservice.CustomerServiceDAO;
import com.fp.pi.member.MemberDAO;

@Controller
public class HomeController {
	
	@Autowired
	private MemberDAO mDAO;
	
	@Autowired
	private CustomerServiceDAO csDAO;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(HttpServletRequest request) {
		SiteOption.clearSearch1(request);
		SiteOption.clearSearch2(request);
		SiteOption.clearSearch3(request);
		csDAO.getEvent1(1, request);
		request.setAttribute("contentPage", "home.jsp");
		return "index";
	}
	
	@RequestMapping(value = "/index.go", method = RequestMethod.GET)
	public String indexGo(HttpServletRequest request) {
		
		
		return home(request);  // 로고를 누르면 home(request) 메서드를 불러내겠다
	}
	
}
