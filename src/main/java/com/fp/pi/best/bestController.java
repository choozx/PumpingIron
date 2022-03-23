package com.fp.pi.best;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fp.pi.TokenMaker;
import com.fp.pi.body.body_review;
import com.fp.pi.member.MemberDAO;
import com.fp.pi.review.community_review2;

@Controller
public class bestController {
	
	@Autowired
	private MemberDAO mDAO;
	
	@Autowired
	private BestDAO bDAO;
	
	
	@RequestMapping(value = "/best.go", method = RequestMethod.GET) 
	public String indexGo(HttpServletRequest req, BestBean cr ) {
		bDAO.getBest(req, cr);
		mDAO.loginCheck(req);
		req.setAttribute("contentPage", "best/best.jsp");
		return "index";
	}
	@RequestMapping(value = "/bestWatch.go", method = RequestMethod.GET) 
	public String bestWatchGo(HttpServletRequest req, BestBean cr, body_review br, community_review2 c2) {
		bDAO.getDetail(req, cr, br, c2);
		mDAO.loginCheck(req);
		req.setAttribute("contentPage", "best/bestWatch.jsp");
		return "index";
	}

	@RequestMapping(value = "/page4.change", method = RequestMethod.GET)
	public String PageChange(HttpServletRequest req) {
		TokenMaker.make(req);
		TokenMaker.make2(req);
		mDAO.loginCheck(req);
		
		int p = Integer.parseInt(req.getParameter("p"));
		bDAO.getMsg(p, req);
		req.setAttribute("contentPage", "best/best.jsp");
		return "index";
	}
	
	
}
