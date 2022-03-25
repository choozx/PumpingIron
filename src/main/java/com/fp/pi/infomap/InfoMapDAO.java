package com.fp.pi.infomap;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fp.pi.calendar.CalendarMapper;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@Service
public class InfoMapDAO {
	
	@Autowired
	private SqlSession ss;

	public void insertInfo(InfoMapBean i, HttpServletRequest req) {
		
		System.out.println(i.getPi_name());
		
		String path = req.getSession().getServletContext().getRealPath("resources/img");
		MultipartRequest mr = null;
		String token = null;
		
		System.out.println(path);
		
		try {
		mr = new MultipartRequest(req, path, 1500 * 1024 * 1024, "utf-8", new DefaultFileRenamePolicy());
		token = mr.getParameter("token");
		String successToken = (String) req.getSession().getAttribute("successToken");
		if (successToken != null && token.equals(successToken)) {
			String fileName = mr.getFilesystemName("pi_img");
			new File(path + "/" + fileName).delete();
			return;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}
		
		try {
		String fileName = mr.getFilesystemName("pi_img");
		
		i.setPi_name(mr.getParameter("pi_name"));
		i.setPi_loc(mr.getParameter("pi_loc"));
		i.setPi_price(mr.getParameter("pi_price"));
		i.setPi_partner(mr.getParameter("pi_partner"));
		i.setPi_img(fileName);
		
		
		if (ss.getMapper(InfoMapMapper.class).regInfo(i) == 1) {
			System.out.println("등록 성공");
			req.setAttribute("result", "등록 성공");
		} else {
			System.out.println("등록 실패");
			req.setAttribute("result", "등록 실패");
		}
		
		} catch (Exception e) {
			e.printStackTrace();
			String fileName = mr.getFilesystemName("pi_img");
			new File(path + "/" + fileName).delete();
			req.setAttribute("result", "업로드실패");
			return;
		}
}
	

	public void searchPriceInfo(InfoMapBean i, HttpServletRequest req) {
		
		List<InfoMapBean> priceInfoes = ss.getMapper(InfoMapMapper.class).searchPriceInfos(i);
		
		req.setAttribute("priceInfo", priceInfoes);
		
		
	}

	
	public int deletePriceInfo(InfoMapBean i, HttpServletRequest req) {
		
		if (ss.getMapper(InfoMapMapper.class).deletePriceInfo(i) == 1) {
			System.out.println("삭제 성공");
			req.setAttribute("result", "삭제 성공");
			return 1;
		} else {
			System.out.println("삭제 실패");
			req.setAttribute("result", "삭제 실패");
			return 0;
		}
		
	}
	
	
	
		
	}
