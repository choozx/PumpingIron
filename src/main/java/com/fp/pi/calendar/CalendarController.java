package com.fp.pi.calendar;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fp.pi.TokenMaker;
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
	public String scheduleGo(ContestBean c, ContestDetailBean cd, HttpServletRequest req) {
		
		if (mDAO.loginCheck(req)) {
		}
		cDAO.selectSchdule(c, req);
		
		req.setAttribute("contentPage", "calendar/scheduleCalendar.jsp");
		return "index";
	}
	
	@RequestMapping(value = "/schedule.reg", method = RequestMethod.GET, produces="application/json")
	public @ResponseBody int scheduleReg(ContestBean c, HttpServletRequest req) {
		
		int a = 0;	
		if (mDAO.loginCheck(req)) {
			a = cDAO.insertSchedule(c, req);
		}
		cDAO.selectSchdule(c, req);
		
		System.out.println(a);
		return a;
	}
	
	
	
	@RequestMapping(value = "/schedule.getData", method = RequestMethod.GET, produces="application/json")
	public @ResponseBody List<ContestBean> scheduleData(ContestDetailBean cd,ContestBean c, HttpServletRequest req) {
		
		if(mDAO.loginCheck(req)) {
		}
		cDAO.selectSchdule(c, req);
		
		return cDAO.selectSchdule(c, req);
	}
	
	
	
	@RequestMapping(value = "/schedule.del", method = RequestMethod.GET)
	public String scheduleDel(ContestBean c, HttpServletRequest req) {
		
		if(mDAO.loginCheck(req)) {
			cDAO.deleteScheldule(c, req);
		}
		req.setAttribute("contentPage", "calendar/scheduleCalendar.jsp");
		return "index";
	}
	
	
	@RequestMapping(value = "/schedule.getDetail", method = RequestMethod.GET, produces="application/json")
	public String scheduleDetail(ContestDetailBean cd, HttpServletRequest req) {
		
		if(mDAO.loginCheck(req)) {
		}
		cDAO.selectDetail(cd, req);
		
		req.setAttribute("contentPage", "calendar/scheduleDetail.jsp");
		return "index";
	}
	
	
	
	@RequestMapping(value = "/schedule.reg.page", method = RequestMethod.GET)
	public String scheduleRegGo(ContestDetailBean cd, HttpServletRequest req) {
		
		if (mDAO.loginCheck(req)) {
		}
		
		req.setAttribute("contentPage", "calendar/scheduleRegPage.jsp");
		return "index";
	}
	
	
	
	@RequestMapping(value = "/schedule.reg.detail", method = RequestMethod.POST)
	public String scheduleRegDo(ContestDetailBean cd, HttpServletRequest req) {
		
		if (mDAO.loginCheck(req)) {
			cDAO.insertDetail(cd, req);
		}
		TokenMaker.make(req);
		
		req.setAttribute("contentPage", "calendar/scheduleCalendar.jsp");
		return "index";
	}

	
	
	@RequestMapping(value = "/schedule.del.detail", method = RequestMethod.GET)
	public String scheduleDelDetail(ContestDetailBean cd, HttpServletRequest req) {
		
		if(mDAO.loginCheck(req)) {
			cDAO.deleteSchelduleDetail(cd, req);
		}
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
	
	
	@RequestMapping(value = "/routine.reg.do", method = RequestMethod.GET, produces="application/json")
	public @ResponseBody int routineInsert(RoutineBean r, HttpServletRequest req) {
		int a = 0;	
		if(mDAO.loginCheck(req)) {
				a =  cDAO.insertRoutine(r, req);
			}
		System.out.println(a);
			return a;
		
	}
	
	
	
	@RequestMapping(value = "/routine.delete", method = RequestMethod.GET)
	public @ResponseBody int routineDelete(RoutineBean r, HttpServletRequest req) {
		
		if(mDAO.loginCheck(req)) {
		cDAO.deletetRoutine(r, req);
		return 1;
		}
		return 0;
	}
	
	
}
