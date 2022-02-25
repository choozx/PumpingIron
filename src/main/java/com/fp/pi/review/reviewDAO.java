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
		MultipartRequest mr = null;
		
		try {
			mr = new MultipartRequest(req, path, 1500 * 1024 * 1024, "urf-8", new DefaultFileRenamePolicy());
			Member m = (Member) req.getSession().getAttribute("loginMember");
			cr.setCr_writer(m.getM_name());
			cr.setCr_title(mr.getParameter("cr_title"));
			cr.setCr_text(mr.getParameter("cr_text"));
			String cr_img = mr.getFilesystemName("cr_img");
			cr_img = URLEncoder.encode(cr_img, "utf-8");
			cr.setCr_img(cr_img);
			
			if (ss.getMapper(ReviewMapper.class).upload(cr) == 1) {
				req.setAttribute("result", "등록성공");
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("result", "등록실패");
		}
		
		
	
	
		
	}
	
	
	

}
