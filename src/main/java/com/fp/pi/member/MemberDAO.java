package com.fp.pi.member;

import java.io.File;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import net.nurigo.java_sdk.api.Message;
import net.nurigo.java_sdk.exceptions.CoolsmsException;

@Service
public class MemberDAO {

	@Autowired
	private SqlSession ss;


	// 휴대폰 인증번호 보내기
	public void certifiedPhoneNumber(String userPhoneNumber, int randomNumber) { 
		String api_key = "NCSSD7DTHFAANFEY"; 
		String api_secret = "3ZBCTLBLJTUCTWUN5JWDFLP0DAHBOFGH"; 
		Message coolsms = new Message(api_key, api_secret); 
		
		// 4 params(to, from, type, text) are mandatory. must be filled
		HashMap<String, String> params = new HashMap<String, String>(); 
		params.put("to", userPhoneNumber); // 수신전화번호
		params.put("from", "01067019501"); // 발신전화번호. 테스트시에는 발신,수신 둘다 본인 번호로 하면 됨
		params.put("type", "SMS"); 
		params.put("text", "[TEST] 인증번호는" + "["+randomNumber+"]" + "입니다."); // 문자 내용 입력
		params.put("app_version", "test app 1.2"); // application name and version
		
		try { 
			JSONObject obj = (JSONObject) coolsms.send(params); 
			System.out.println(obj.toString()); 
		} catch (CoolsmsException e) {
			System.out.println(e.getMessage()); 
			System.out.println(e.getCode()); } }

	
	
	// 회원가입
	public void join(Member m, HttpServletRequest req, HttpServletResponse response) {

		String path = req.getSession().getServletContext().getRealPath("resources/files");
		MultipartRequest mr = null;
		try {
			mr = new MultipartRequest(req, path, 10 * 1024 * 1024, "utf-8", new DefaultFileRenamePolicy());
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("result", "가입실패");
			return;
		}

		try {
			String m_email = mr.getParameter("m_email");
			String m_pw = mr.getParameter("m_pw");
			String m_phone = mr.getParameter("m_phone");
			String m_name = mr.getParameter("m_name");
			String m_addr1 = mr.getParameter("m_addr1");
			String m_addr2 = mr.getParameter("m_addr2");
			String m_addr3 = mr.getParameter("m_addr3");
			String m_addr = m_addr1 + "!" + m_addr2 + "!" + m_addr3; // !는 구분자
			String m_photo = mr.getFilesystemName("m_photo");
			m_photo = URLEncoder.encode(m_photo, "utf-8");
			m_photo = m_photo.replace("+", " ");

			System.out.println(m_email);
			System.out.println(m_pw);
			System.out.println(m_phone);
			System.out.println(m_addr);
			System.out.println(m_name);
			System.out.println(m_photo);
			
			
			
			m.setM_email(m_email);
			m.setM_pw(m_pw);
			m.setM_phone(m_phone);
			m.setM_addr(m_addr);
			m.setM_name(m_name);
			m.setM_photo(m_photo);

			if (ss.getMapper(MemberMapper.class).join(m) == 1) {
				response.setContentType("text/html; charset=euc-kr");
				PrintWriter script = response.getWriter();
				script.println("<script>");
				script.println("alert('회원가입이 완료되었습니다.');");
				script.println("location.href ='index.go'");
				script.println("</script>");
				script.close();
				System.out.println("가입 성공");
			} else {
				req.setAttribute("result", "가입 실패");
				System.out.println("가입 실패");
			}
		} catch (Exception e) {
			e.printStackTrace();
			String fileName = mr.getFilesystemName("m_photo");
			new File(path + "/" + fileName).delete();
			req.setAttribute("result", "가입 실패");
		}
		
		
		
		
	}



	// 이메일 중복 체크
	public int emailCheck(String m_email) {

		MemberMapper MemberDAO = ss.getMapper(MemberMapper.class);

		return MemberDAO.emailCheck(m_email);
		
	}

	
	// 로그인
	public void login(Member m, HttpServletRequest req) {

		Member dbMember = ss.getMapper(MemberMapper.class).getMemberByID(m); // db에 있는 비밀번호 가져오기 위함

		if (dbMember != null) {
			if (m.getM_pw().equals(dbMember.getM_pw())) {
				req.getSession().setAttribute("loginMember", dbMember);
				req.getSession().setMaxInactiveInterval(60 * 30);
				System.out.println("로그인 성공");
			} else {
				req.setAttribute("result", "로그인 실패(PW오류)");
				System.out.println("로그인 실패(PW오류)");
			}
		} else {
			req.setAttribute("result", "로그인 실패(미가입ID)");
			System.out.println("로그인 실패(미가입ID)");
		}
	}
	
	public boolean loginCheck(HttpServletRequest req) {
		Member m = (Member) req.getSession().getAttribute("loginMember");
		if (m != null) {
			return true;
		} else {
			req.setAttribute("loginPage", "member/login.jsp");
			return false;
		}
	}



	public void logout(HttpServletRequest req) {
		req.getSession().setAttribute("loginMember", null);
		System.out.println("로그아웃");
	}


	
	



}

	

