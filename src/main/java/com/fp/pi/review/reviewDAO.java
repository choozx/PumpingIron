package com.fp.pi.review;

import java.net.URLEncoder;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fp.pi.member.Member;
import com.fp.pi.tips.TipsMapper;
import com.fp.pi.tips.community_review;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@Service
public class reviewDAO {
	
	@Autowired
	private SqlSession ss;

	public void getContent(HttpServletRequest req) {
		
		List<community_review> reviews = ss.getMapper(ReviewMapper.class).reviews();
		
		
		
		
	}

	public void upload(HttpServletRequest req, community_review cr) {

		String path = req.getSession().getServletContext().getRealPath("resources/file");
		
		try {
			System.out.println(cr.getCr_title());
			Member m = (Member) req.getSession().getAttribute("loginMember");
			cr.setCr_nickname(m.getM_name());
			cr.setCr_title("cr_title");
		
			
			
			
			
			
			
			if (ss.getMapper(ReviewMapper.class).upload(cr) == 1) {
				req.setAttribute("result", "등록성공");
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("result", "등록실패");
		}
		
		
	
	
		
	}
	
	
	

}
