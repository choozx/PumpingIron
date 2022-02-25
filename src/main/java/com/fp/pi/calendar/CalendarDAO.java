package com.fp.pi.calendar;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fp.pi.member.Member;

@Service
public class CalendarDAO {
	
	@Autowired
	private SqlSession ss;

	public void getID(Member m, HttpServletRequest req) {
		
		
		
		
	}

	public void insertRoutine(Member m, HttpServletRequest req) {

		if (ss.getMapper(CalendarMapper.class).recordRoutine(m) == 1) {
			System.out.println("등록 성공");
			req.setAttribute("result", "등록 성공");
		} else {
			System.out.println("등록 실패");
			req.setAttribute("result", "등록 실패");
		}
		
		
	}
	
	
	
	
	

}