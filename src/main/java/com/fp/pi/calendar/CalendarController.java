package com.fp.pi.calendar;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fp.pi.member.Member;
import com.fp.pi.member.MemberDAO;

@Controller
public class CalendarController {
	
	@Autowired
	MemberDAO mDAO;
	
	@Autowired
	CalendarDAO cDAO;

	@RequestMapping(value = "/schedule.go", method = RequestMethod.GET)
	public String scheduleGo(HttpServletRequest req) {
		
		mDAO.loginCheck(req);
		
		req.setAttribute("contentPage", "calendar/scheduleCalendar.jsp");
		return "index";
	}
	
	
	
	
	
	
	/////////////////////// 루틴 캘린더//////////////////////////
	
	@RequestMapping(value = "/routine.date", method = RequestMethod.GET)
	public String routineDate(RoutineBean r, HttpServletRequest req) {
		
		mDAO.loginCheck(req);
		
		req.setAttribute("contentPage", "calendar/routineDate.jsp");
		return "index";
	}
	
	
	
	@RequestMapping(value = "/routine.go", method = RequestMethod.GET)
	public String routineGo(RoutineBean r, HttpServletRequest req) {
		
		mDAO.loginCheck(req);
		cDAO.getRoutine(r, req);
		
		req.setAttribute("contentPage", "calendar/routineCalendar.jsp");
		return "index";
	}
	
	
	@RequestMapping(value = "/routine.insert", method = RequestMethod.GET)
	public String routineInsert(RoutineBean r, HttpServletRequest req) {
		
			mDAO.loginCheck(req);
			cDAO.insertRoutine(r, req);
			cDAO.getRoutine(r, req);
		
		req.setAttribute("contentPage", "calendar/routineCalendar.jsp");
		return "index";
	}
	
	
	@RequestMapping(value = "/routine.delete", method = RequestMethod.GET)
	public String routineDelete(RoutineBean r, HttpServletRequest req) {
		
		mDAO.loginCheck(req);
		cDAO.deletetRoutine(r, req);
		
		req.setAttribute("contentPage", "calendar/routineDate.jsp");
		return "index";
	}
	
	
}
