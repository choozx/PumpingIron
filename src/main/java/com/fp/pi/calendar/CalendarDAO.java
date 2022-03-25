package com.fp.pi.calendar;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fp.pi.member.Member;

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
	public List<ContestBean> selectSchdule1(ContestBean c, HttpServletRequest req) {
		
		List<ContestBean> contests = ss.getMapper(CalendarMapper.class).contestSchedule();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy.MM.dd");
		
		
		
		
		for (ContestBean cc : contests) {
			System.out.println(cc.getCc_startDate());
			try {
				System.out.println(sdf2.format(sdf.parse(cc.getCc_startDate())));
				
				cc.setCc_startDate(sdf2.format(sdf.parse(cc.getCc_startDate())));	
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		req.setAttribute("contest", contests);
		
		return contests;
		
	}


	public int deleteScheldule(ContestBean c, HttpServletRequest req) {
		
		if (ss.getMapper(CalendarMapper.class).delSchedule(c) == 1) {
			System.out.println("삭제 성공");
			req.setAttribute("result", "삭제 성공");
			return 1;
		} else {
			System.out.println("삭제 실패");
			req.setAttribute("result", "삭제 실패");
			return 0;
		}
		
	}
	
	
	
	public void selectDetail_all(ContestDetailBean cd, HttpServletRequest req) {
		
		List<ContestDetailBean> details = ss.getMapper(CalendarMapper.class).detailSchedule2();
		
		req.setAttribute("detail", details);
		
	}


	public void selectDetail(ContestDetailBean cd, HttpServletRequest req) {
		
		BigDecimal num = cd.getCcd_no();
		System.out.println(num);
		
		List<ContestDetailBean> details = ss.getMapper(CalendarMapper.class).detailSchedule(cd);
		
		req.setAttribute("detail", details);
		
	}
	
	
	/*	
	public List<ContestDetailBean> selectDetail(ContestDetailBean cd, HttpServletRequest req) {
		
		BigDecimal num = cd.getCcd_no();
		System.out.println(num);
		
//		cd.setCcd_no(num);
		
		List<ContestDetailBean> details = ss.getMapper(CalendarMapper.class).detailSchedule(cd);
		
		req.setAttribute("detail", details);
		
		return details;
	}
*/
	
	
	
	
	

}
