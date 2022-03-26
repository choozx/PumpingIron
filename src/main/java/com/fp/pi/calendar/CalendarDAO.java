package com.fp.pi.calendar;

import java.io.File;
import java.math.BigDecimal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fp.pi.infomap.InfoMapMapper;
import com.fp.pi.member.Member;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import oracle.net.aso.c;

@Service
public class CalendarDAO {
	
	@Autowired
	private SqlSession ss;

	public int insertRoutine(RoutineBean r, HttpServletRequest req) {

		Member m = (Member) req.getSession().getAttribute("loginMember");
		
		r.setCr_id(m.getM_email());
		
		if (ss.getMapper(CalendarMapper.class).recordRoutine(r) == 1) {
			System.out.println("등록 성공");
			req.setAttribute("result", "등록 성공");
			return 1;
		} else {
			System.out.println("등록 실패");
			req.setAttribute("result", "등록 실패");
			return 0;
		}
		
//		System.out.println(r.getCr_id());
////		System.out.println(r.getCr_no());
//		System.out.println(r.getCr_text());
//		System.out.println(r.getCr_date());
		
	}

	
	public List<RoutineBean> getRoutine(RoutineBean r, HttpServletRequest req) {
		
		List<RoutineBean> routines = ss.getMapper(CalendarMapper.class).showRoutine(r);
		
		req.setAttribute("routine", routines);
		return routines;
	}

	
	public void deletetRoutine(RoutineBean r, HttpServletRequest req) {

		if (ss.getMapper(CalendarMapper.class).delRoutine(r) == 1) {
			System.out.println("삭제 성공");
			req.setAttribute("result", "삭제 성공");
		} else {
			System.out.println("삭제 실패");
			req.setAttribute("result", "삭제 실패");
		}
		
	}

	
	
	
	
	
	

	public int insertSchedule(ContestBean c, HttpServletRequest req) {
		
//		System.out.println(c.getCc_text());
//		System.out.println(c.getCc_startDate());
//		System.out.println(c.getCc_endDate());

		if (ss.getMapper(CalendarMapper.class).regSchedule(c) == 1) {
			System.out.println("등록 성공");
			req.setAttribute("result", "등록 성공");
			return 1;
		} else {
			System.out.println("등록 실패");
			req.setAttribute("result", "등록 실패");
			return 0;
		}
		
	}


	public List<ContestBean> selectSchdule(ContestBean c, HttpServletRequest req) {

		List<ContestBean> contests = ss.getMapper(CalendarMapper.class).contestSchedule();
		
		req.setAttribute("contest", contests);
		
		return contests;
	
	}


	public void deleteScheldule(ContestBean c, HttpServletRequest req) {
		
		if (ss.getMapper(CalendarMapper.class).delSchedule(c) == 1) {
			System.out.println("삭제 성공");
			req.setAttribute("result", "삭제 성공");
		} else {
			System.out.println("삭제 실패");
			req.setAttribute("result", "삭제 실패");
		}
		
	}
	
	
	
	public void selectDetail_all(ContestDetailBean cd, HttpServletRequest req) {
		
		List<ContestDetailBean> details = ss.getMapper(CalendarMapper.class).detailSchedule2();
		
		req.setAttribute("detail", details);
		
	}


	public void selectDetail(ContestDetailBean cd, HttpServletRequest req) {
		
		int num = cd.getCcd_no();
		System.out.println(num);
		
		List<ContestDetailBean> details = ss.getMapper(CalendarMapper.class).detailSchedule(cd);
		
		req.setAttribute("detail", details);
		
	}


	public void insertDetail(ContestDetailBean cd, HttpServletRequest req) {

		String path = req.getSession().getServletContext().getRealPath("resources/img");
		MultipartRequest mr = null;
		String token = null;
		
		System.out.println(path);
		
		try {
		mr = new MultipartRequest(req, path, 1500 * 1024 * 1024, "utf-8", new DefaultFileRenamePolicy());
		token = mr.getParameter("token");
		String successToken = (String) req.getSession().getAttribute("successToken");
		if (successToken != null && token.equals(successToken)) {
			String fileName = mr.getFilesystemName("ccd_img");
			new File(path + "/" + fileName).delete();
			return;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}
		
		try {
		String fileName = mr.getFilesystemName("ccd_img");
		
		cd.setCcd_no(Integer.parseInt(mr.getParameter("ccd_no")));
		cd.setCcd_img(fileName);
		cd.setCcd_title(mr.getParameter("ccd_title"));
		cd.setCcd_text(mr.getParameter("ccd_text"));
		
		System.out.println(cd.getCcd_no());
		System.out.println(cd.getCcd_title());
		
		if (ss.getMapper(CalendarMapper.class).regSchduleDetail(cd) == 1) {
			System.out.println("등록 성공");
			req.setAttribute("result", "등록 성공");
		} else {
			System.out.println("등록 실패");
			req.setAttribute("result", "등록 실패");
		}
		
		} catch (Exception e) {
			e.printStackTrace();
			String fileName = mr.getFilesystemName("ccd_img");
			new File(path + "/" + fileName).delete();
			req.setAttribute("result", "등록 실패");
			return;
		}
		
	}


	public void deleteSchelduleDetail(ContestDetailBean cd, HttpServletRequest req) {
		
		if (ss.getMapper(CalendarMapper.class).delScheduleDetail(cd) == 1) {
			System.out.println("삭제 성공");
			req.setAttribute("result", "삭제 성공");
		} else {
			System.out.println("삭제 실패");
			req.setAttribute("result", "삭제 실패");
		}
		
	}
	
	
	
	
	

}
