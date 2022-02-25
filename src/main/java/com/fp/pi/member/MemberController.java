package com.fp.pi.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
	
	@Autowired
	private UserMailSendService mailsender;

//	@Autowired
//	private LoginService lg;
	
	
	// 로그인 폼
	@RequestMapping(value = "/member.login.go", method = RequestMethod.GET)
	public String login(HttpServletRequest req) {
		
		
		req.setAttribute("contentPage", "member/login.jsp");
		return "index";
	}
	
	// 로그인하기
	@RequestMapping(value = "/member.login.do", method = RequestMethod.POST)
	@ResponseBody
	public int login(Member m, HttpServletRequest req, HttpServletResponse response, HttpSession httpSession, String user_check) {
			
		user_check = req.getParameter("remember_userId");
	
		int result = mDAO.userLogin(m, httpSession, response, req, user_check);
//		int result = lg.userLogin(m, httpSession, response, req);
		mDAO.loginCheck(req);
		
		
		return result;
	}
	
	// 로그아웃
	@RequestMapping(value = "member.logout", method = RequestMethod.GET)
	public String logout(Member m, HttpServletRequest req) {
		
		mDAO.logout(req);
		mDAO.loginCheck(req);
		req.setAttribute("contentPage", "home.jsp");
		return "index";
	}
	

	// 회원가입 페이지로 이동
	@RequestMapping(value = "/member.join.go", method = RequestMethod.GET)
	public String join(HttpServletRequest req) {

		req.setAttribute("contentPage", "member/join.jsp");
		return "index";
	}
	
	// 회원가입 
	@RequestMapping(value = "/member.join.do", method = RequestMethod.POST)
	public String joinGo(Member m, HttpServletRequest req, HttpServletResponse respons) {
		
		mDAO.join(m, req, respons);
		mailsender.mailSendWithUserKey(m.getM_email(), req);
		req.setAttribute("contentPage", "home.jsp");
		return "index";
	}

	
	// 휴대폰 인증
	@RequestMapping(value = "/phoneCheck", method = RequestMethod.GET) 
	@ResponseBody
	public String sendSMS(@RequestParam("m_phone") String userPhoneNumber) { 
		int randomNumber = (int)((Math.random()* (9999 - 1000 + 1)) + 1000);//난수 생성 
		
		mDAO.certifiedPhoneNumber(userPhoneNumber,randomNumber); 
		
		return Integer.toString(randomNumber); 
		}
	
	// email 중복 체크 컨트롤러
	@RequestMapping(value = "/member.emailCheck", method = RequestMethod.GET)
	@ResponseBody
		public int emailCheck(@RequestParam("m_email") String m_email) {

			return mDAO.emailCheck(m_email);
		}
	
	// e-mail 인증 컨트롤러
		@RequestMapping(value = "/user/key_alter", method = RequestMethod.GET)
		public String key_alterConfirm(@RequestParam("m_email") String m_email, @RequestParam("m_key") String key) {

			mailsender.alter_userKey_service(m_email, key); // mailsender의 경우 @Autowired

			
			
			return "member/loginSuccess";
	}

}