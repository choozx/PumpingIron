package com.fp.pi.member;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MemberController {

	@Autowired
	private MemberDAO mDAO;

	// 로그인
	@RequestMapping(value = "/member.login.go", method = RequestMethod.GET)
	public String login(HttpServletRequest req) {

		req.setAttribute("contentPage", "member/login.jsp");
		return "index";
	}

	// 회원가입
	@RequestMapping(value = "/member.join.go", method = RequestMethod.GET)
	public String join(HttpServletRequest req) {

		req.setAttribute("contentPage", "member/join.jsp");
		return "index";
	}

	
	// 휴대폰 인증
	@RequestMapping(value = "/phoneCheck", method = RequestMethod.GET) 
	@ResponseBody
	public String sendSMS(@RequestParam("phone") String userPhoneNumber) { 
		int randomNumber = (int)((Math.random()* (9999 - 1000 + 1)) + 1000);//난수 생성 
		
		mDAO.certifiedPhoneNumber(userPhoneNumber,randomNumber); 
		
		return Integer.toString(randomNumber); 
		}
	}

	

