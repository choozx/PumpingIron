package com.fp.pi.tips;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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

	@RequestMapping(value = "/write.do", method = RequestMethod.GET)
	public String writeDo(HttpServletRequest req) {
			tDAO.insertCon(req);
			tDAO.getContent(req);
		
		req.setAttribute("contentPage", "tips/tips.jsp");
		return "index";
	}

	@RequestMapping(value = "/watchContents.go", method = RequestMethod.GET)
	public String watchGo(HttpServletRequest req) {
		
		req.setAttribute("contentPage", "tips/watchContents.jsp");
		return "index";
	}

	
	

}
