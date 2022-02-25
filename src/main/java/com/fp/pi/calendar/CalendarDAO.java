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
	
	
	
	
	

}
