package com.fp.pi.tips;

import java.util.List;


import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class tipsDAO {

	@Autowired
	private SqlSession ss;

	public void getContent(HttpServletRequest req) {
		List<community_review> reviews = ss.getMapper(TipsMapper.class).reviews();
	
		req.setAttribute("reviews", reviews);
	}

	public void insertCon(HttpServletRequest req) {

		if (ss.getMapper(TipsMapper.class).writeCon() == 1) {
			req.setAttribute("r", "등록성공");
		}else {
			req.setAttribute("r", "등록실패");
		}
	
	
		
	
	}
	
	
	
	
	
	
}
