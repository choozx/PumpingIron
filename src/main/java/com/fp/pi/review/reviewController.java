package com.fp.pi.review;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fp.pi.SiteOption2;
import com.fp.pi.TokenMaker;
import com.fp.pi.member.MemberDAO;

@Controller
public class reviewController {
	
	@Autowired
	private MemberDAO mDAO;
	
	@Autowired
	private reviewDAO rDAO;
	

	
	@RequestMapping(value = "/review.go", method = RequestMethod.GET) 
	public String indexGo(HttpServletRequest req ) {
		TokenMaker.make(req);
		TokenMaker.make2(req);
		rDAO.getContent(req);
		rDAO.getMsg(1, req);
		SiteOption2.clearSearch(req);
		req.setAttribute("contentPage", "review/review2.jsp");
		return "index";
	}
	
	@RequestMapping(value = "/page2.change", method = RequestMethod.GET)
	public String PageChange(HttpServletRequest req) {
		TokenMaker.make(req);
		TokenMaker.make2(req);
		mDAO.loginCheck(req);
		
		int p = Integer.parseInt(req.getParameter("p"));
		rDAO.getMsg(p, req);
		req.setAttribute("contentPage", "review/review2.jsp");
		return "index";
	}

	
	@RequestMapping(value = "/reviewWrite.go", method = RequestMethod.GET)
	public String writeGo(HttpServletRequest req) {
		TokenMaker.make(req);
	//	tDAO.insertCon(req);
	//	tDAO.getContent(req);
		
		req.setAttribute("contentPage", "review/reviewWrite.jsp");
		return "index";
	}

	@RequestMapping(value = "/reviewWrite.do", method = RequestMethod.POST)
	public String writeDo(HttpServletRequest req, community_review2 cr) {
		TokenMaker.make(req);
		if (mDAO.loginCheck(req)) {
			rDAO.insertCon(req, cr);
		}
		rDAO.getMsg(1, req);
		req.setAttribute("contentPage", "review/review2.jsp");
		return "index";
	}

	@RequestMapping(value = "/reviewWatch.go", method = RequestMethod.GET)
	public String watchGo(HttpServletRequest req, community_review2 cr, community_review2_reply crr) {
		
		rDAO.viewCount(req, cr);
		rDAO.getDetail(req, cr);
		rDAO.getReply(req, crr);
		req.setAttribute("contentPage", "review/reviewWatch.jsp");
		return "index";
	}
	
	@RequestMapping(value = "/delete2.do", method = RequestMethod.GET)
	public String deletDo(HttpServletRequest req, community_review2 cr) {
		TokenMaker.make(req);
		rDAO.getDetail(req, cr);
		System.out.println(cr.getC2_no());
		if (mDAO.loginCheck(req)) {
			rDAO.delete(req, cr);
		}
		rDAO.getMsg(1, req);
		req.setAttribute("contentPage", "review/review2.jsp");
		return "index";
	}
	
	@RequestMapping(value = "/update2.go", method = RequestMethod.GET)
	public String updateGo(HttpServletRequest req, community_review2 cr) {
		TokenMaker.make(req);
		rDAO.getDetail(req, cr);
		
		req.setAttribute("contentPage", "review/update.jsp");
		return "index";
	}
	
	
	@RequestMapping(value = "/update2.do", method = RequestMethod.GET)
	public String updateDo(HttpServletRequest req, community_review2 cr) {
		TokenMaker.make(req);
		if (mDAO.loginCheck(req)) {
			rDAO.update(req, cr);
		}
		rDAO.getMsg(1, req);
		req.setAttribute("contentPage", "review/review2.jsp");
		return "index";
	}

	
	

	@RequestMapping(value = "/reply2.write", method = RequestMethod.GET)
	public String replyWrite(HttpServletRequest req, community_review2 cr, community_review2_reply crr) {
		TokenMaker.make(req);
		if (mDAO.loginCheck(req)) {
			rDAO.writeReply(req, crr,cr); // insert
		}
		rDAO.getReply(req, crr);
		rDAO.getDetail(req, cr);
		req.setAttribute("contentPage", "review/reviewWatch.jsp");
		return "index";
	}
	
	@RequestMapping(value = "/delReply2.do", method = RequestMethod.GET)
	public String replyDel(HttpServletRequest req, community_review2 cr, community_review2_reply crr) {
		TokenMaker.make(req);
		if (mDAO.loginCheck(req)) {
			rDAO.delReply(req, crr);
		}
		rDAO.getDetail(req, cr);
		rDAO.getReply(req, crr);
		req.setAttribute("contentPage", "review/reviewWatch.jsp");
		return "index";
	}
	
	
	@RequestMapping(value = "/upReply2.Do", method = RequestMethod.GET)
	public String upReplyDo(HttpServletRequest req, community_review2 cr, community_review2_reply crr) {
		TokenMaker.make(req);
		if (mDAO.loginCheck(req)) {
			rDAO.updateReply(req, crr);
		}
		rDAO.getDetail(req, cr);
		rDAO.getReply(req, crr);
		req.setAttribute("contentPage", "review/reviewWatch.jsp");
		return "index";
	}

	
	
	@RequestMapping(value = "/tipsLikes2.cnt", method = RequestMethod.GET)
	public @ResponseBody int likeCnt(HttpServletRequest req, community_review2 cr) {
		return rDAO.likeCnt(req, cr);
	}
	@RequestMapping(value = "/tipsLikes2", method = RequestMethod.GET)
	public @ResponseBody int likeControl(HttpServletRequest req) {
		return rDAO.likeOfTips(req);
	}
	@RequestMapping(value = "/tipsLikes2.update", method = RequestMethod.GET)
	public @ResponseBody int likeUpdate(HttpServletRequest req) {
		return rDAO.likeOfTipsUpdate(req);
	}
	
	
	
	@RequestMapping(value = "/summorFileUpload2", method = RequestMethod.POST, produces="application/json")
	public @ResponseBody String summerUpload(HttpServletRequest req) {
		return rDAO.getSummorJSON(req);
		
		
	}

	
	
	
	
}
