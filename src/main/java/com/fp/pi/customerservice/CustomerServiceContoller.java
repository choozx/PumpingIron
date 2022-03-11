package com.fp.pi.customerservice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fp.pi.member.Member;
import com.fp.pi.member.MemberDAO;

@Controller
public class CustomerServiceContoller {

	@Autowired
	private CustomerServiceDAO csDAO;
	
	@Autowired
	private MemberDAO mDAO;
	
	// 제휴문의 페이지로 이동
	@RequestMapping(value = "/customerservice.associate.go", method = RequestMethod.GET)
	public String associateGo(Member m, HttpServletRequest req) {
		
		if(mDAO.loginCheck(req)) {
			req.setAttribute("contentPage", "customerservice/associate.jsp");
		}
		return "index";
	}
	
	// 제휴문의
	@RequestMapping(value = "/customerservice.associate.do", method = RequestMethod.POST)
	public String associateDo(Member m, HttpServletRequest req, HttpServletResponse response) {
		
		if(mDAO.loginCheck(req)) {
			csDAO.associate(m, req, response);
			req.setAttribute("contentPage", "home.jsp");
			
		}
		
		
		return "index";
	}
	// 공지사항&이벤트 페이지로 이동
	@RequestMapping(value = "/customerservice.event.go", method = RequestMethod.GET)
	public String eventGo(Member m, HttpServletRequest req) {
		
		req.setAttribute("contentPage", "customerservice/eventGo.jsp");
		csDAO.getEvent(req);
		return "index";
	}
	// 공지사항&이벤트 글 작성 페이지로 이동
	@RequestMapping(value = "/customerservice.event.do", method = RequestMethod.GET)
	public String eventDo(Member m, HttpServletRequest req) {
		
		if(mDAO.loginCheck(req)) {
		req.setAttribute("contentPage", "customerservice/eventDo.jsp");
	}	
		return "index";
	}
	
	// 공지사항&이벤트 글 작성
	@RequestMapping(value = "/customerservice.event", method = RequestMethod.POST)
	public String event(Event e,Member m, HttpServletRequest req) {
		
		if(mDAO.loginCheck(req)) {
		csDAO.writeEvent(e, m, req);
		csDAO.getEvent(req);
		req.setAttribute("contentPage", "customerservice/eventGo.jsp");
	}	
		return "index";
	}
	
	// 공지사항&이벤트 글 삭제
	@RequestMapping(value = "/customerservice.event.delete", method = RequestMethod.GET)
	public String eventDelete(Event e,Member m, HttpServletRequest req, HttpServletResponse response) {
		
		if(mDAO.loginCheck(req)) {
		csDAO.deleteEvent(e, m, req, response);
		csDAO.getEvent(req);
		req.setAttribute("contentPage", "customerservice/eventGo.jsp");
	}	
		return "index";
	}
	
	// 공지사항&이벤트 수정 페이지로 이동
	@RequestMapping(value = "/customerservice.event.updateGo", method = RequestMethod.GET)
	public String eventUpdateGo(Event e,Member m, HttpServletRequest req, HttpServletResponse response) {
		
		if(mDAO.loginCheck(req)) {
			csDAO.getDetail(req, e);
			req.setAttribute("contentPage", "customerservice/eventUpdateGo.jsp");
		}	
		return "index";
	}
	
	// 공지사항&이벤트 수정
	@RequestMapping(value = "/customerservice.event.updateDo", method = RequestMethod.POST)
	public String eventupdateDo(Event e,Member m, HttpServletRequest req, HttpServletResponse response) {
		
		if(mDAO.loginCheck(req)) {
			csDAO.updateEvent(e, req, response);
			csDAO.getEvent(req);
			req.setAttribute("contentPage", "customerservice/eventGo.jsp");
		}	
		return "index";
	}
}
