package com.fp.pi;

import javax.servlet.http.HttpServletRequest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fp.pi.best.BestDAO;
import com.fp.pi.body.bodyDAO;
import com.fp.pi.calendar.CalendarDAO;
import com.fp.pi.calendar.ContestBean;
import com.fp.pi.customerservice.CustomerServiceDAO;
import com.fp.pi.member.MemberDAO;
import com.fp.pi.review.reviewDAO;
import com.fp.pi.tips.tipsDAO;

@Controller
public class HomeController {
	
	@Autowired
	private MemberDAO mDAO;
	
	@Autowired
	private CustomerServiceDAO csDAO;
	
	@Autowired
	private CalendarDAO cDAO;
	
	@Autowired
	private tipsDAO tDAO;
	
	@Autowired
	private bodyDAO bDAO;
	
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(HttpServletRequest request, ContestBean c) {
		SiteOption.clearSearch1(request);
		SiteOption.clearSearch2(request);
		SiteOption.clearSearch3(request);
		csDAO.getEvent1(1, request);
		tDAO.getMsg(1, request);
		bDAO.getMsg(1, request);
		cDAO.selectSchdule1(c, request);
		request.setAttribute("contentPage", "home.jsp");
		return "index";
	}
	
	@RequestMapping(value = "/index.go", method = RequestMethod.GET)
	public String indexGo(HttpServletRequest request, ContestBean c) {
		
		
		return home(request,c );  // 로고를 누르면 home(request) 메서드를 불러내겠다
	}
	
}
