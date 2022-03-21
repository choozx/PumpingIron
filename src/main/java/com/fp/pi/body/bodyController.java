package com.fp.pi.body;

import javax.servlet.http.HttpServletRequest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fp.pi.SiteOption3;
import com.fp.pi.TokenMaker;
import com.fp.pi.member.MemberDAO;

@Controller
public class bodyController {
	
	@Autowired
	private MemberDAO mDAO;
	
	@Autowired
	private bodyDAO bDAO;
	

	
	@RequestMapping(value = "/body.go", method = RequestMethod.GET) 
	public String indexGo(HttpServletRequest req ) {
		TokenMaker.make(req);
		TokenMaker.make2(req);
		bDAO.getContent(req);
		bDAO.getMsg(1, req);
		SiteOption3.clearSearch(req);
		req.setAttribute("contentPage", "body/body.jsp");
		return "index";
	}
	
	@RequestMapping(value = "/page3.change", method = RequestMethod.GET)
	public String PageChange(HttpServletRequest req) {
		TokenMaker.make(req);
		TokenMaker.make2(req);
		mDAO.loginCheck(req);
		
		int p = Integer.parseInt(req.getParameter("p"));
		bDAO.getMsg(p, req);
		req.setAttribute("contentPage", "body/body.jsp");
		return "index";
	}

	
	@RequestMapping(value = "/bodyWrite.go", method = RequestMethod.GET)
	public String writeGo(HttpServletRequest req) {
		TokenMaker.make(req);
		
		req.setAttribute("contentPage", "body/bodyWrite.jsp");
		return "index";
	}

	@RequestMapping(value = "/bodyWrite.do", method = RequestMethod.POST)
	public String writeDo(HttpServletRequest req, body_review cr) {
		TokenMaker.make(req);
		if (mDAO.loginCheck(req)) {
			bDAO.insertCon(req, cr);
		}
		bDAO.getMsg(1, req);
		req.setAttribute("contentPage", "body/body.jsp");
		return "index";
	}

	@RequestMapping(value = "/bodyWatch.go", method = RequestMethod.GET)
	public String watchGo(HttpServletRequest req, body_review cr, body_review_reply crr) {
		
		bDAO.viewCount(req, cr);
		bDAO.getDetail(req, cr);
		bDAO.getReply(req, crr);
		req.setAttribute("contentPage", "body/bodyWatch.jsp");
		return "index";
	}
	
	@RequestMapping(value = "/delete3.do", method = RequestMethod.GET)
	public String deletDo(HttpServletRequest req, body_review cr) {
		TokenMaker.make(req);
		bDAO.getDetail(req, cr);
		System.out.println(cr.getBr_no());
		if (mDAO.loginCheck(req)) {
			bDAO.delete(req, cr);
		}
		bDAO.getMsg(1, req);
		req.setAttribute("contentPage", "body/body.jsp");
		return "index";
	}
	
	@RequestMapping(value = "/update3.go", method = RequestMethod.GET)
	public String updateGo(HttpServletRequest req, body_review cr) {
		TokenMaker.make(req);
		bDAO.getDetail(req, cr);
		
		req.setAttribute("contentPage", "body/update.jsp");
		return "index";
	}
	
	
	@RequestMapping(value = "/update3.do", method = RequestMethod.GET)
	public String updateDo(HttpServletRequest req, body_review cr) {
		TokenMaker.make(req);
		if (mDAO.loginCheck(req)) {
			bDAO.update(req, cr);
		}
		bDAO.getMsg(1, req);
		req.setAttribute("contentPage", "body/body.jsp");
		return "index";
	}

	
	

	@RequestMapping(value = "/reply3.write", method = RequestMethod.GET)
	public String replyWrite(HttpServletRequest req, body_review cr, body_review_reply crr) {
		TokenMaker.make(req);
		if (mDAO.loginCheck(req)) {
			bDAO.writeReply(req, crr,cr); // insert
		}
		bDAO.getReply(req, crr);
		bDAO.getDetail(req, cr);
		req.setAttribute("contentPage", "body/bodyWatch.jsp");
		return "index";
	}
	
	@RequestMapping(value = "/delReply3.do", method = RequestMethod.GET)
	public String replyDel(HttpServletRequest req, body_review cr, body_review_reply crr) {
		TokenMaker.make(req);
		if (mDAO.loginCheck(req)) {
			bDAO.delReply(req, crr);
		}
		bDAO.getDetail(req, cr);
		bDAO.getReply(req, crr);
		req.setAttribute("contentPage", "review/reviewWatch.jsp");
		return "index";
	}
	
	
	@RequestMapping(value = "/upReply3.Do", method = RequestMethod.GET)
	public String upReplyDo(HttpServletRequest req, body_review cr, body_review_reply crr) {
		TokenMaker.make(req);
		if (mDAO.loginCheck(req)) {
			bDAO.updateReply(req, crr);
		}
		bDAO.getDetail(req, cr);
		bDAO.getReply(req, crr);
		req.setAttribute("contentPage", "review/reviewWatch.jsp");
		return "index";
	}

	
	
	@RequestMapping(value = "/tipsLikes3.cnt", method = RequestMethod.GET)
	public @ResponseBody int likeCnt(HttpServletRequest req, body_review cr) {
		return bDAO.likeCnt(req, cr);
	}
	@RequestMapping(value = "/tipsLikes3", method = RequestMethod.GET)
	public @ResponseBody int likeControl(HttpServletRequest req) {
		return bDAO.likeOfTips(req);
	}
	@RequestMapping(value = "/tipsLikes3.update", method = RequestMethod.GET)
	public @ResponseBody int likeUpdate(HttpServletRequest req) {
		return bDAO.likeOfTipsUpdate(req);
	}
	
	
	
	@RequestMapping(value = "/summorFileUpload3", method = RequestMethod.POST, produces="application/json")
	public @ResponseBody String summerUpload(HttpServletRequest req) {
		return bDAO.getSummorJSON(req);
		
		
	}

	
	
	
	
}
