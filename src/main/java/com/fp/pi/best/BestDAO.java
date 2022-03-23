package com.fp.pi.best;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fp.pi.SiteOption4;
import com.fp.pi.body.BodyMapper;
import com.fp.pi.body.HeartDTO3;
import com.fp.pi.best.Selector4;
import com.fp.pi.body.body_review;
import com.fp.pi.review.Review2Mapper;
import com.fp.pi.review.community_review2;


@Service
public class BestDAO {
		
	
	
	@Autowired
	private SqlSession ss;

	@Autowired
	private SiteOption4 so4;
	
	public void getBest(HttpServletRequest req, BestBean cr) {
		
	// bean에다 실시간으로 세팅
	ArrayList<BestBean> bests = new ArrayList<BestBean>();
		// 바디 베스트
	List<body_review> bodies = ss.getMapper(BestMapper.class).bestFromBody();

	for (body_review b : bodies) {
		BestBean bb = new BestBean();
	 bb.setB_no(b.getBr_no());
	 bb.setB_title(b.getBr_title());
	 bb.setB_content(b.getBr_content());
	 bb.setB_nickname(b.getBr_nickname());
	 bb.setB_like(b.getBr_like());
	 bb.setB_views(b.getBr_views());
	 bb.setB_email(b.getBr_email());
	 bb.setB_tips(b.getBr_tips());
	 bb.setB_bodyProfile(b.getBr_bodyProfile());
	 bb.setB_productReview(b.getBr_productReview());
	 bb.setB_date(b.getBr_date());
	 bb.setB_picture(b.getBr_picture());
	 bb.setB_type("body");
	 bests.add(bb);
	 System.out.println(bb.getB_title());
	 System.out.println(bb.getB_no());
	}
	
		// 리뷰2 베스트
	List<community_review2> reviews = ss.getMapper(BestMapper.class).bestFromReview2();
	
	for (community_review2 c : reviews) {
		BestBean bb = new BestBean();
		 bb.setB_no(c.getC2_no());
		 bb.setB_title(c.getC2_title());
		 bb.setB_content(c.getC2_content());
		 bb.setB_nickname(c.getC2_nickname());
		 bb.setB_like(c.getC2_like());
		 bb.setB_views(c.getC2_views());
		 bb.setB_email(c.getC2_email());
		 bb.setB_tips(c.getC2_tips());
		 bb.setB_bodyProfile(c.getC2_bodyProfile());
		 bb.setB_productReview(c.getC2_productReview());
		 bb.setB_date(c.getC2_date());
		 bb.setB_picture(c.getC2_picture());
		 bb.setB_type("review2");
		 System.out.println(bb.getB_title() + "-----aa");
		 bests.add(bb);
		
		
	}
	
	// 저걸 좋아요 순으로 담기
	
	
	Collections.sort(bests, new Comparator<BestBean>() {

		@Override
		public int compare(BestBean o1, BestBean o2) {
				
			Integer a = o1.getB_like();
			Integer b = o2.getB_like();
			
			return b.compareTo(a);
		}
		
	});
	
	req.setAttribute("bests", bests);
	}
	
	private int allMsgCount;
	
	public int getAllMsgCount() {
		allMsgCount = ss.getMapper(BestMapper.class).getmsgcount();
		return allMsgCount;
	}
	public void setAllMsgCount(int allMsgCount) {
		this.allMsgCount = allMsgCount;
	}

	
	
		public void getMsg(int pageNo, HttpServletRequest req) {
		allMsgCount = ss.getMapper(BestMapper.class).getmsgcount();	
		int count = so4.getSnsCountPerpage();
		int start = (pageNo - 1) * count + 1;  // 0
		int end = start + (count - 1);   		//	1

		Selector4 search = (Selector4) req.getSession().getAttribute("search");
		int msgCount = 0;

		if (search == null) {
			search = new Selector4("", new BigDecimal(start), new BigDecimal(end));
			msgCount = getContent(req); // 전체 개시글 수     
		} else {
			search.setStart(new BigDecimal(start));
			search.setEnd(new BigDecimal(end));
		}
		
		List<BestBean> bests = ss.getMapper(BestMapper.class).getMsgCount(search);
		for (BestBean b : bests) {
			System.out.println(b.getB_no()+"----");
			b.setB_like(likeCnt(req, b));
			b.setB_bodyProfile(getReply2(req,b) + "");
			System.out.println(b.getB_like() +"~~~~~~~");
			
		}
		}
		
		public int getContent(HttpServletRequest req) {
			List<BestBean> reviews = ss.getMapper(BestMapper.class).reviews();
			allMsgCount = reviews.size();
			System.out.println(allMsgCount);
			return reviews.size();
		}
		
		public void viewCount(HttpServletRequest req, BestBean cr) {
			String token = req.getParameter("token4");
			System.out.println(req.getParameter("token4") + ":D"); 
			String successToken = (String) req.getSession().getAttribute("successToken4");
		    System.out.println("토큰 값111" + token);
		    System.out.println("--------------111" + successToken);
			if (successToken != null) {
				if (token.equals(successToken)) {
					
					return;
				}	
			}
		    
		    req.getSession().setAttribute("successToken4", token);
		    System.out.println("토큰 값222" + token);
		    System.out.println("--------------222" + successToken);
			ss.getMapper(BestMapper.class).views(cr);
			
			
			}
		public int likeCnt(HttpServletRequest req, BestBean cr) {
			return ss.getMapper(BestMapper.class).allLike(cr);
		}
		
		public int likeOfTips(HttpServletRequest req) {
			Map<String, String> vals = new HashMap<String, String>();
			String aa = req.getParameter("ajaxId");
			String bb = req.getParameter("ajaxEmail");
			
			vals.put("idd", aa);
			vals.put("emaill", bb);
			
			HeartDTO3 heart = ss.getMapper(BestMapper.class).likeOfTips(vals);
			System.out.println(heart);
		
			if(heart == null) {
				return 0;
			}else {
				return 1;
			}
			
		}
		public int likeOfTipsUpdate(HttpServletRequest req) {
			
			int aa = Integer.parseInt(req.getParameter("ajaxId"));
			String bb = req.getParameter("ajaxEmail");
			HeartDTO3 h = new HeartDTO3(0, aa, bb);
			System.out.println(aa);
			System.out.println(bb);
			System.out.println(h.getH3_br_no());
			System.out.println(h.getH3_m_email());
			
			int val = Integer.parseInt(req.getParameter("val"));
			if(val == 0) {
				ss.getMapper(BestMapper.class).likeOfTipsInsert(h);
			}else {
				ss.getMapper(BestMapper.class).likeOfTipsDelete(h);
			}
			return likeOfTips(req);
		}
		public int getReply2(HttpServletRequest req, BestBean cr) {
			return ss.getMapper(BestMapper.class).replys2(cr);
		}
		public void getDetail(HttpServletRequest req, BestBean cr, body_review br, community_review2 c2) {
			if(cr.getB_type().equals("body")) {
				br.setBr_no(cr.getB_no());
				br.setBr_content(cr.getB_content());
				br.setBr_date(cr.getB_date());
				br.setBr_picture(cr.getB_picture());
				br.setBr_title(cr.getB_title());
				br.setBr_nickname(cr.getB_nickname());
				br.setBr_views(cr.getB_views());
				req.setAttribute("dd", ss.getMapper(BodyMapper.class).getDetail(br));
				System.out.println(br.getBr_no() + "^^");
				
			}else if (cr.getB_type().equals("review2")) {
				c2.setC2_no(cr.getB_no());
				c2.setC2_content(cr.getB_content());
				c2.setC2_date(c2.getC2_date());
				c2.setC2_picture(c2.getC2_picture());
				c2.setC2_title(c2.getC2_title());
				c2.setC2_nickname(c2.getC2_nickname());
				c2.setC2_views(c2.getC2_views());
				req.setAttribute("dd", ss.getMapper(Review2Mapper.class).getDetail2(c2));
				System.out.println(c2.getC2_no() + "^^");
			}
	
			
		}

}
