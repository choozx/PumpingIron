package com.fp.pi.calendar;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fp.pi.member.Member;

@Service
public class CalendarDAO {
	
	@Autowired
	private SqlSession ss;

	public void insertRoutine(RoutineBean r, HttpServletRequest req) {

		Member m = (Member) req.getSession().getAttribute("loginMember");
		
//		System.out.println(m.getM_email());
		
		r.setCr_id(m.getM_email());
		
		System.out.println(r.getCr_id());
		System.out.println(r.getCr_text());
		System.out.println(r.getCr_date());
		
		if (ss.getMapper(CalendarMapper.class).recordRoutine(r) == 1) {
			System.out.println("등록 성공");
			req.setAttribute("result", "등록 성공");
		} else {
			System.out.println("등록 실패");
			req.setAttribute("result", "등록 실패");
		}
		
		
	}

	public void getRoutine(RoutineBean r, HttpServletRequest req) {
		
		List<RoutineBean> routines = ss.getMapper(CalendarMapper.class).showRoutine();
		
		//System.out.println(r.getCr_text());
		
		req.setAttribute("routine", routines);
		
	}
	
	
	
	
	

}
