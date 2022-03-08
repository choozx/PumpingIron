package com.fp.pi.calendar;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fp.pi.member.Member;
import com.fp.pi.member.MemberDAO;

@Controller
public class CalendarController {
	
	@Autowired
	MemberDAO mDAO;
	
	@Autowired
	CalendarDAO cDAO;

	
	
	
	
	
	
	
	
	/////////////////////// 대회 일정 캘린더//////////////////////////
	
	
	@RequestMapping(value = "/schedule.go", method = RequestMethod.GET)
	public String scheduleGo(HttpServletRequest req) {
		
		mDAO.loginCheck(req);
		
		req.setAttribute("contentPage", "calendar/scheduleCalendar.jsp");
		return "index";
	}
	
	
	
	
	
	
	/////////////////////// 루틴 캘린더//////////////////////////
	
	@RequestMapping(value = "/routine.date", method = RequestMethod.GET)
	public String routineDate(RoutineBean r, HttpServletRequest req) {
//		Date d = new Date();
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//		req.setAttribute("cr_date", sdf.format(d));
		mDAO.loginCheck(req);
		req.setAttribute("contentPage", "calendar/routineDate.jsp");
		return "index";
	}
	
	
	
	@RequestMapping(value = "/routine.go", method = RequestMethod.GET)
	public String routineGo(RoutineBean r, HttpServletRequest req) {
	
		if(mDAO.loginCheck(req)) {
			cDAO.getRoutine(r, req);
		}
		req.setAttribute("contentPage", "calendar/routineCalendar.jsp");
		return "index";
	}
	
	
	@RequestMapping(value = "/routine.getData", method = RequestMethod.GET, produces="application/json")
	public @ResponseBody List<RoutineBean> routineData(RoutineBean r, HttpServletRequest req) {
		
		if(mDAO.loginCheck(req)) {
			cDAO.getRoutine(r, req);
		}
		
		return cDAO.getRoutine(r, req);
	}
	
	
	@RequestMapping(value = "/routine.insert", method = RequestMethod.GET)
	public void routineInsert(RoutineBean r, HttpServletRequest req) {
		
			if(mDAO.loginCheck(req)) {
				cDAO.insertRoutine(r, req);
				cDAO.getRoutine(r, req);
			}
		
//		req.setAttribute("contentPage", "calendar/routineCalendar.jsp");
//		return "index";
	}
	
	
	
	@RequestMapping(value = "/routine.delete", method = RequestMethod.GET)
	public void routineDelete(RoutineBean r, HttpServletRequest req) {
		
		if(mDAO.loginCheck(req)) {
		cDAO.deletetRoutine(r, req);
		}
	}
	
	
}
