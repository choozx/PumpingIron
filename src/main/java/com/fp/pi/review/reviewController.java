package com.fp.pi.review;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fp.pi.member.MemberDAO;
import com.fp.pi.tips.community_review;

@Controller
public class reviewController {
	
	@Autowired
	private MemberDAO mDAO;
	
	@Autowired
	private reviewDAO rDAO;
	
	@RequestMapping(value = "/review.go", method = RequestMethod.GET)
	public String reviewGo(HttpServletRequest req) {
		
		rDAO.getContent(req);
		
		
		req.setAttribute("contentPage", "review/review2.jsp");
		return "index";
	}
	@RequestMapping(value = "/reviewWrite.go", method = RequestMethod.GET)
	public String reviewWriteGo(HttpServletRequest req) {
		
		req.setAttribute("contentPage", "review/reviewWrite.jsp");
		return "index";
	}
	@RequestMapping(value = "/reviewWrite.do", method = RequestMethod.GET)
	public String reviewWriteDo(HttpServletRequest req, community_review cr) {
		
		if (mDAO.loginCheck(req)) {
			rDAO.upload(req,cr);
		}
		
		rDAO.getContent(req);
		req.setAttribute("contentPage", "review/reviewWrite.jsp");
		return "index";
	}
	@RequestMapping(value = "/reviewWatch.go", method = RequestMethod.GET)
	public String reviewWratchGo(HttpServletRequest req) {
		
		req.setAttribute("contentPage", "review/reviewWatch.jsp");
		return "index";
	}

}
