package com.fp.pi.tips;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fp.pi.member.MemberDAO;
import com.fp.pi.SiteOption;

@Controller
public class tipsController {
	
	@Autowired
	private MemberDAO mDAO;
	
	@Autowired
	private tipsDAO tDAO;
	
	
	@RequestMapping(value = "/tips.go", method = RequestMethod.GET) 
	public String indexGo(HttpServletRequest req ) {
		
		tDAO.getContent(req);
		tDAO.getMsg(1, req);
		SiteOption.clearSearch(req);
		req.setAttribute("contentPage", "tips/tips.jsp");
		return "index";
	}
	
	@RequestMapping(value = "/page.change", method = RequestMethod.GET)
	public String PageChange(HttpServletRequest req) {
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
			tDAO.insertCon(req, cr);
			//tDAO.getContent(req);
			tDAO.getMsg(1, req);
		req.setAttribute("contentPage", "tips/tips.jsp");
		return "index";
	}

	@RequestMapping(value = "/watchContents.go", method = RequestMethod.GET)
	public String watchGo(HttpServletRequest req, community_review cr, community_review_reply crr) {
		tDAO.getDetail(req, cr);
		tDAO.getReply(req, crr);
		req.setAttribute("contentPage", "tips/watchContents2.jsp");
		return "index";
	}
	
	@RequestMapping(value = "/delete.do", method = RequestMethod.GET)
	public String deletDo(HttpServletRequest req, community_review cr) {
		tDAO.getDetail(req, cr);
		System.out.println(cr.getCr_no());
		tDAO.delete(req, cr);
		tDAO.getMsg(1, req);
		//tDAO.getContent(req);
		req.setAttribute("contentPage", "tips/tips.jsp");
		return "index";
	}
	
	@RequestMapping(value = "/update.go", method = RequestMethod.GET)
	public String updateGo(HttpServletRequest req, community_review cr) {
		tDAO.getDetail(req, cr);
		
		req.setAttribute("contentPage", "tips/update.jsp");
		return "index";
	}
	
	
	@RequestMapping(value = "/update.do", method = RequestMethod.GET)
	public String updateDo(HttpServletRequest req, community_review cr) {
		tDAO.update(req, cr);
		//tDAO.getContent(req);
		tDAO.getMsg(1, req);
		req.setAttribute("contentPage", "tips/tips.jsp");
		return "index";
	}

	
	

	@RequestMapping(value = "/reply.write", method = RequestMethod.GET)
	public String replyWrite(HttpServletRequest req, community_review cr, community_review_reply crr) {
		tDAO.writeReply(req, crr); // insert
		tDAO.getReply(req, crr);
		
		req.setAttribute("contentPage", "tips/watchContents2.jsp");
		return "index";
	}
	
	
	
	
	
	
	
	
	
	
	
	@RequestMapping(value = "/summorFileUpload", method = RequestMethod.POST, produces="application/json")
	public @ResponseBody String summerUpload(HttpServletRequest req) {
		return tDAO.getSummorJSON(req);
		
		
	}
	

	
	

}
