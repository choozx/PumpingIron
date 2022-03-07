package com.fp.pi.member;




import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

<<<<<<< HEAD
	
//	@Autowired
//	private LoginService lg;
	
	
=======
>>>>>>> e4f458a338bf593ec468558ca5ffd26e704ab97f
	// 로그인 폼
	@RequestMapping(value = "/member.login.go", method = RequestMethod.GET)
	public String login(HttpServletRequest req) {
		
		
		req.setAttribute("contentPage", "member/login.jsp");
		return "index";
	}
	
	// 로그인하기
	@RequestMapping(value = "/member.login.do", method = RequestMethod.POST)
	public String login(Member m, HttpServletRequest req, HttpServletResponse respons) {
			
		mDAO.login(m, req);
		mDAO.loginCheck(req);
		req.setAttribute("contentPage", "home.jsp");
		return "index";
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
	
	
	
	
	}

	

<<<<<<< HEAD
			mDAO.loginCheck(req);
			req.setAttribute("contentPage", "member/withdrawlDo.jsp");
			return "index";
		}	
		// 회원탈퇴 수행
		@RequestMapping(value = "/member.withdrawal.do", method = RequestMethod.POST)
		public String withdrawalDo(Member m,HttpServletRequest req, HttpServletResponse response) {

		if(mDAO.loginCheck(req)) {
			mDAO.withdrawal(m, req, response);
		}
			req.setAttribute("contentPage", "home.jsp");
			return "index";
		}	

		// 아이디 / 비밀번호 찾기 페이지로 이동
		@RequestMapping(value = "/member.search.go", method = RequestMethod.GET)
		public String searchGo(Member m,HttpServletRequest req, HttpServletResponse response) {
			
			
			req.setAttribute("contentPage", "member/memberSearch.jsp");
			return "index";
		}
		
		// ajax 요청 아이디 찾기
		@RequestMapping(value = "/member.searchId.do", method = RequestMethod.POST)
		@ResponseBody
		public String SearchId(Member m, HttpServletRequest req, HttpServletResponse response) {
			
			System.out.println(m.getM_name());
			System.out.println(m.getM_phone());
			String result = mDAO.get_searchId(m.getM_name(), m.getM_phone(), req);

			return result;
		}
		
		// 비밀번호 찾기(이메일로 임시 비밀번호 발송)
		@RequestMapping(value = "/member.searchPw.do", method = RequestMethod.GET)
		@ResponseBody
		public int passwordSearch(@RequestParam("m_email")String m_email,
				@RequestParam("m_phone")String m_phone,
				HttpServletRequest req) {

		int result = mailsender.mailSendWithPassword(m_email,m_phone, req);
			
			return result;
		}
		// 회원정보 페이지 이동 전에 비밀번호 입력받기
		@RequestMapping(value = "/member.info", method = RequestMethod.GET)
		public String info(Member m,HttpServletRequest req, HttpServletResponse response) {

			mDAO.loginCheck(req);
			req.setAttribute("contentPage", "member/info.jsp");
			return "index";
		}
		
		
		
		// 회원정보 페이지로 이동
		@RequestMapping(value = "/member.info.go", method = RequestMethod.GET)
		public String infoGo(Member m,HttpServletRequest req, HttpServletResponse response)  {
			
			mDAO.loginCheck(req);
			mDAO.splitAddr(req);
			mDAO.infoPwCheck(m, req, response);
			req.setAttribute("contentPage", "member/infoGo.jsp");
			return "index";
		}
		
		// 회원정보 수정
		@RequestMapping(value = "/member.update", method = RequestMethod.POST)
		public String memberUpdate(Member m,HttpServletRequest req, HttpServletResponse response)  {
			
			if(mDAO.loginCheck(req)) {
				mDAO.update(m, req, response);
				mDAO.loginCheck(req);
				mDAO.splitAddr(req);
				req.setAttribute("contentPage", "member/infoGo.jsp");
			} else {
				req.setAttribute("contentPage", "member/login.jsp");
			}
			
			return "index";
		}
		// 카카오 로그인 페이지
		@RequestMapping(value = "/member.kakaoGO", method = RequestMethod.GET)
		public String kakaoGo(Member m, HttpServletRequest req, HttpServletResponse response, String m_email) {
			
			System.out.println(req.getParameter("name"));
			System.out.println(req.getParameter("email"));
			System.out.println(req.getParameter("profile_image"));
			
			m_email = req.getParameter("email");
			mDAO.loginKakao(m, req, response, m_email);
			if(mDAO.loginCheck(req)) {
				req.setAttribute("contentPage", "home.jsp");
			} else {
				
				if(req.getParameter("email") == "") {
					req.setAttribute("contentPage", "member/kakaoLogin.jsp");					
				} else {
					req.setAttribute("contentPage", "member/kakaoLogin2.jsp");	
				}
			}
			
			return "index";
		}
		
		// 카카오 회원가입
		@RequestMapping(value = "/member.kakaoDo", method = RequestMethod.POST)
		public String kakaoDo(Member m, HttpServletRequest req, HttpServletResponse response, String m_email) {
			
			

			m_email = req.getParameter("email");
			mDAO.joinKakao(m, req, response, m_email);
			mDAO.loginCheck(req);
			req.setAttribute("contentPage", "home.jsp");
			return "index";
		}
		// 카카오 회원정보 수정 페이지
		@RequestMapping(value = "/member.kakaoInfo.go", method = RequestMethod.GET)
		public String kakaoInfoGo(Member m,HttpServletRequest req, HttpServletResponse response)  {
			
		if(mDAO.loginCheck(req)) {
			mDAO.splitAddr(req);
			req.setAttribute("contentPage", "member/kakaoInfoGo.jsp");
			
		}
			return "index";
		}
		
		// 카카오 회원정보 수정 페이지
		@RequestMapping(value = "/member.kakaoUpdate", method = RequestMethod.POST)
		public String kakaoUpdate(Member m,HttpServletRequest req, HttpServletResponse response)  {
			
			if(mDAO.loginCheck(req)) {
				mDAO.updateKakao(m, req, response);
				mDAO.splitAddr(req);
				req.setAttribute("contentPage", "member/kakaoInfoGo.jsp");
			} else {
				req.setAttribute("contentPage", "member/login.jsp");
			}
			
			return "index";
		
		
		}
		
		// 카카오 회원탈퇴 수행
			@RequestMapping(value = "/member.kakaoWithdrawal", method = RequestMethod.GET)
			public String kakaoWithdrawal(Member m,HttpServletRequest req, HttpServletResponse response) {

			if(mDAO.loginCheck(req)) {
			mDAO.kakaoWithdrawal(m, req, response);
			}
				req.setAttribute("contentPage", "home.jsp");
				return "index";
			}	
}
=======
>>>>>>> e4f458a338bf593ec468558ca5ffd26e704ab97f
