package com.fp.pi.tips;

import javax.servlet.http.HttpServletRequest;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fp.pi.member.MemberDAO;

@Controller
public class tipsController {
	
	@Autowired
	private MemberDAO mDAO;
	
	@Autowired
	private tipsDAO tDAO;
	
	
	
	@RequestMapping(value = "/tips.go", method = RequestMethod.GET)
	public String indexGo(HttpServletRequest req) {
		
		tDAO.getContent(req);
		
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
			System.out.println("컨트롤러");
			tDAO.insertCon(req, cr);
			tDAO.getContent(req);
		
		req.setAttribute("contentPage", "tips/tips.jsp");
		return "index";
	}

	@RequestMapping(value = "/watchContents.go", method = RequestMethod.GET)
	public String watchGo(HttpServletRequest req, community_review cr) {
		tDAO.getDetail(req, cr);
		
		req.setAttribute("contentPage", "tips/watchContents2.jsp");
		return "index";
	}
	
	@RequestMapping(value = "/delete.do", method = RequestMethod.GET)
	public String deletDo(HttpServletRequest req, community_review cr) {
		tDAO.getDetail(req, cr);
		System.out.println(cr.getCr_no());
		tDAO.delete(req, cr);
		tDAO.getContent(req);
		req.setAttribute("contentPage", "tips/tips.jsp");
		return "index";
	}
	
	@RequestMapping(value = "/update.go", method = RequestMethod.GET)
	public String updateGo(HttpServletRequest req, community_review cr) {
		
		req.setAttribute("contentPage", "tips/update.jsp");
		return "index";
	}
	
	
	@RequestMapping(value = "/update.Do", method = RequestMethod.GET)
	public String updateDo(HttpServletRequest req, community_review cr) {
		tDAO.update(req, cr);
		tDAO.getContent(req);
		req.setAttribute("contentPage", "tips/tips.jsp");
		return "index";
	}
	
	
	@RequestMapping(value = "/summorFileUpload", method = RequestMethod.POST, produces="application/json")
	public @ResponseBody String summerUpload(HttpServletRequest req) {
		return tDAO.getSummorJSON(req);
		
		
	}
	

	
	

}
