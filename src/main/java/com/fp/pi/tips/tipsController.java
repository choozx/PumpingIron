package com.fp.pi.tips;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fp.pi.SiteOption;
import com.fp.pi.TokenMaker;
import com.fp.pi.member.MemberDAO;

@Controller
public class tipsController {
	
	@Autowired
	private MemberDAO mDAO;
	
	@Autowired
	private tipsDAO tDAO;
	
	
	@RequestMapping(value = "/tips.go", method = RequestMethod.GET) 
	public String indexGo(HttpServletRequest req ) {
		TokenMaker.make(req);
		TokenMaker.make2(req);
		tDAO.getContent(req);
		tDAO.getMsg(1, req);
		SiteOption.clearSearch(req);
		req.setAttribute("contentPage", "tips/tips.jsp");
		return "index";
	}
	
	@RequestMapping(value = "/page.change", method = RequestMethod.GET)
	public String PageChange(HttpServletRequest req) {
		TokenMaker.make(req);
		mDAO.loginCheck(req);
		
		int p = Integer.parseInt(req.getParameter("p"));
		tDAO.getMsg(p, req);
		req.setAttribute("contentPage", "tips/tips.jsp");
		return "index";
	}

	
	@RequestMapping(value = "/write.go", method = RequestMethod.GET)
	public String writeGo(HttpServletRequest req) {
	//	tDAO.insertCon(req);
	//	tDAO.getContent(req);
		
		req.setAttribute("contentPage", "tips/write.jsp");
		return "index";
	}

	@RequestMapping(value = "/write.do", method = RequestMethod.POST)
	public String writeDo(HttpServletRequest req, community_review cr) {
		TokenMaker.make(req);
		if (mDAO.loginCheck(req)) {
			tDAO.insertCon(req, cr);
		}
			tDAO.getMsg(1, req);
		req.setAttribute("contentPage", "tips/tips.jsp");
		return "index";
	}

	@RequestMapping(value = "/watchContents.go", method = RequestMethod.GET)
	public String watchGo(HttpServletRequest req, community_review cr, community_review_reply crr) {
		
		tDAO.viewCount(req, cr);
		tDAO.getDetail(req, cr);
		tDAO.getReply(req, crr);
		req.setAttribute("contentPage", "tips/watchContents2.jsp");
		return "index";
	}
	
	@RequestMapping(value = "/delete.do", method = RequestMethod.GET)
	public String deletDo(HttpServletRequest req, community_review cr) {
		TokenMaker.make(req);
		tDAO.getDetail(req, cr);
		System.out.println(cr.getCr_no());
		if (mDAO.loginCheck(req)) {
			tDAO.delete(req, cr);
		}
		tDAO.getMsg(1, req);
		req.setAttribute("contentPage", "tips/tips.jsp");
		return "index";
	}
	
	@RequestMapping(value = "/update.go", method = RequestMethod.GET)
	public String updateGo(HttpServletRequest req, community_review cr) {
		TokenMaker.make(req);
		tDAO.getDetail(req, cr);
		
		req.setAttribute("contentPage", "tips/update.jsp");
		return "index";
	}
	
	
	@RequestMapping(value = "/update.do", method = RequestMethod.GET)
	public String updateDo(HttpServletRequest req, community_review cr) {
		TokenMaker.make(req);
		if (mDAO.loginCheck(req)) {
			tDAO.update(req, cr);
		}
		tDAO.getMsg(1, req);
		req.setAttribute("contentPage", "tips/tips.jsp");
		return "index";
	}

	
	

	@RequestMapping(value = "/reply.write", method = RequestMethod.GET)
	public String replyWrite(HttpServletRequest req, community_review cr, community_review_reply crr) {
		TokenMaker.make(req);
		if (mDAO.loginCheck(req)) {
			tDAO.writeReply(req, crr,cr); // insert
		}
		tDAO.getReply(req, crr);
		tDAO.getDetail(req, cr);
		req.setAttribute("contentPage", "tips/watchContents2.jsp");
		return "index";
	}
	
	@RequestMapping(value = "/delReply.do", method = RequestMethod.GET)
	public String replyDel(HttpServletRequest req, community_review cr, community_review_reply crr) {
		TokenMaker.make(req);
		if (mDAO.loginCheck(req)) {
			tDAO.delReply(req, crr);
		}
		tDAO.getDetail(req, cr);
		tDAO.getReply(req, crr);
		req.setAttribute("contentPage", "tips/watchContents2.jsp");
		return "index";
	}
	
	
	@RequestMapping(value = "/upReply.Do", method = RequestMethod.GET)
	public String upReplyDo(HttpServletRequest req, community_review cr, community_review_reply crr) {
		TokenMaker.make(req);
		if (mDAO.loginCheck(req)) {
			tDAO.updateReply(req, crr);
		}
		tDAO.getDetail(req, cr);
		tDAO.getReply(req, crr);
		req.setAttribute("contentPage", "tips/watchContents2.jsp");
		return "index";
	}

	
	
	@RequestMapping(value = "/tipsLikes.cnt", method = RequestMethod.GET)
	public @ResponseBody int likeCnt(HttpServletRequest req) {
		return tDAO.likeCnt(req);
	}
	@RequestMapping(value = "/tipsLikes", method = RequestMethod.GET)
	public @ResponseBody int likeControl(HttpServletRequest req) {
		return tDAO.likeOfTips(req);
	}
	@RequestMapping(value = "/tipsLikes.update", method = RequestMethod.GET)
	public @ResponseBody int likeUpdate(HttpServletRequest req) {
		return tDAO.likeOfTipsUpdate(req);
	}
	
	
	
	
	
	@RequestMapping(value = "/summorFileUpload", method = RequestMethod.POST, produces="application/json")
	public @ResponseBody String summerUpload(HttpServletRequest req) {
		return tDAO.getSummorJSON(req);
		
		
	}

	

	
	
	
	

}
