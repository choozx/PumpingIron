package com.fp.pi.tips;

import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Enumeration;
import java.util.List;


import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fp.pi.member.Member;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@Service
public class tipsDAO {

	@Autowired
	private SqlSession ss;

	public void getContent(HttpServletRequest req) {
		List<community_review> reviews = ss.getMapper(TipsMapper.class).reviews();
	
		req.setAttribute("reviews", reviews);
	}

	public void insertCon(HttpServletRequest req, community_review cr) {
		try {
		Member m = (Member) req.getSession().getAttribute("loginMember");
			
		Member mmm = (Member) req.getSession().getAttribute("loginMember");
		
		cr.setCr_nickname(mmm.getM_name());
		cr.setCr_tips("zz");
		cr.setCr_bodyProfile("aaaa");
		cr.setCr_productReview("굿");
		cr.setCr_email("zzz");
		
		
		if (ss.getMapper(TipsMapper.class).writeCon(cr) == 1) {
			req.setAttribute("result", "등록성공");
		}
			
			
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("result", "등록실패");
			
		}
		
	
	}

	public void getDetail(HttpServletRequest req, community_review cr) {
		
	req.setAttribute("tippp", ss.getMapper(TipsMapper.class).getDetail(cr));	
		
	
		
		
	}

	public String getSummorJSON(HttpServletRequest request) {
		  // 이미지 업로드할 경로
		String uploadPath = request.getSession().getServletContext().getRealPath("resources/file");
		System.out.println(uploadPath);
	    int size = 10 * 1024 * 1024;  // 업로드 사이즈 제한 10M 이하
		
		String fileName = ""; // 파일명
		
		try{
	        // 파일업로드 및 업로드 후 파일명 가져옴
			MultipartRequest multi = new MultipartRequest(request, uploadPath, size, "utf-8", new DefaultFileRenamePolicy());
			Enumeration files = multi.getFileNames();
			String file = (String)files.nextElement(); 
			fileName = multi.getFilesystemName(file); 
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	    // 업로드된 경로와 파일명을 통해 이미지의 경로를 생성
		uploadPath = "resources/file/" + fileName;
		
	    // 생성된 경로를 JSON 형식으로 보내주기 위한 설정
		JSONObject jobj = new JSONObject();
		jobj.put("url", uploadPath);
		
		return jobj.toJSONString();
	}
	
	
	
	
	
	
}
