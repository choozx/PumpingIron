package com.fp.pi.member;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.PrintWriter;
<<<<<<< HEAD
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLDecoder;
=======
>>>>>>> e4f458a338bf593ec468558ca5ffd26e704ab97f
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.UUID;

<<<<<<< HEAD
import javax.imageio.ImageIO;
import javax.servlet.http.Cookie;
=======
>>>>>>> e4f458a338bf593ec468558ca5ffd26e704ab97f
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
		// 인증 안 했을 경우 인증하란 메세지 발생
		/*String y = "Y";
		if (!(dbMember.getM_key().equals(y))) {
			result = -2;
			return result;
		}*/

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


	
<<<<<<< HEAD
	// 정보 조회할 때 주소 
	public void splitAddr(HttpServletRequest req) { // 내 정보조회 할 때 db에 !로 주소를 구분한거를 안나오게 하기 위함
		Member m = (Member) req.getSession().getAttribute("loginMember");
		String addr = m.getM_addr();
		String[] addr2 = addr.split("!");
		req.setAttribute("addr", addr2);
=======
	
>>>>>>> e4f458a338bf593ec468558ca5ffd26e704ab97f




	// 회원정보 수정
	public void update(Member m, HttpServletRequest req, HttpServletResponse response) {

		String path = req.getSession().getServletContext().getRealPath("resources/files");
		MultipartRequest mr = null;
		Member loginMember = (Member) req.getSession().getAttribute("loginMember");
		String oldFile = loginMember.getM_photo();
		String newFile = null;
		String oldPw = loginMember.getM_pw();
		String newPw = "";
		String oldPhone = loginMember.getM_phone();
		String newPhone = "";
		try {
			mr = new MultipartRequest(req, path, 10 * 1024 * 1024, "utf-8", new DefaultFileRenamePolicy());
			newFile = mr.getFilesystemName("m_photo");
			String m_pw2 = mr.getParameter("m_pw2");
			String m_phone = mr.getParameter("m_phone");
			if (newFile == null) {
				newFile = oldFile;
			} else {
				newFile = URLEncoder.encode(newFile, "utf-8");
				newFile = newFile.replace("+", " ");
			}
			if(m_pw2.length() == 0) {
				newPw = oldPw;
			} else {
				newPw = m_pw2;
			}
			if(m_phone.length() == 0) {
				newPhone = oldPhone;
			} else {
				newPhone = m_phone;
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("result", "수정실패");
			return;
		}
		
		try {
			String m_pw = mr.getParameter("m_pw"); // 기존 비밀번호
			String m_addr1 = mr.getParameter("m_addr1");
			String m_addr2 = mr.getParameter("m_addr2");
			String m_addr3 = mr.getParameter("m_addr3");
			String m_addr = m_addr1 + "!" + m_addr2 + "!" + m_addr3;
			String m_photo = newFile;

			
			System.out.println(m_pw);
			System.out.println(newPw); // 신규 비밀번호
			System.out.println(newPhone); // 신규 핸드폰번호
			System.out.println(m_addr);
			System.out.println(m_photo);
			m.setM_email(loginMember.getM_email());
			m.setM_name(loginMember.getM_name());
			m.setM_pw(newPw);
			m.setM_phone(newPhone);
			m.setM_addr(m_addr);
			m.setM_photo(m_photo);
			m.setM_point(loginMember.getM_point());
			m.setM_pay(loginMember.getM_pay());
			m.setM_type("normal");
			if(m_pw.equals(oldPw)) { // 비밀번호가 일치할 때 수정 실행
			 if(ss.getMapper(MemberMapper.class).update(m)== 1) {
				System.out.println("회원정보 수정 성공");
				response.setContentType("text/html; charset=euc-kr");
				PrintWriter script = response.getWriter();
				script.println("<script>");
				script.println("alert('회원정보를 수정하였습니다.');");
				script.println("location.href ='index.go'");
				script.println("</script>");
				script.close();
				req.getSession().setAttribute("loginMember", m);
				
				if (!oldFile.equals(newFile)) {
					oldFile = URLDecoder.decode(oldFile, "utf-8");
					new File(path + "/" + oldFile).delete();
				}
			 }
				
			} else {
				System.out.println("비밀번호 불일치로 인한 회원정보 수정 실패");
				response.setContentType("text/html; charset=euc-kr");
				PrintWriter script = response.getWriter();
				script.println("<script>");
				script.println("alert('비밀번호가 일치하지 않습니다.');");
				script.println("history.go(-1);");
				script.println("</script>");
				script.close();
				if (!oldFile.equals(newFile)) {
					newFile = URLDecoder.decode(newFile, "utf-8");
					new File(path + "/" + newFile).delete();
				}
			}
			
		
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("result", "수정실패");
			if (!oldFile.equals(newFile)) {
				try {
					newFile = URLDecoder.decode(newFile, "utf-8");
				} catch (UnsupportedEncodingException e1) {
				}
				new File(path + "/" + newFile).delete();
			}
		}
		
	}


	// 카카오 회원가입
	public void joinKakao(Member m, HttpServletRequest req, HttpServletResponse response, String m_email) {
		
		
		
		//이미지 주소 
				String imageUrl = req.getParameter("profile_image");
				System.out.println("imagePath : " + imageUrl);
				
				//버퍼이미지 변수 정의
				BufferedImage image = null;
		
		try {
			
			//버퍼이미지 경로에 이미지를 읽어서 넣음
			image = ImageIO.read(new URL(imageUrl));
			//이미지주소의 맨끝부분에 파일이름을 자름
			String fileNm = imageUrl.substring(imageUrl.lastIndexOf("/") + 1);
			System.out.println(fileNm);
			UUID uuid = UUID.randomUUID();
			String newFileName = uuid.toString() + fileNm;
			System.out.println(newFileName);
			//저장할 디렉터리와파일명 생성
			String path = req.getSession().getServletContext().getRealPath("resources/files/");
			File pathf = new File(path + newFileName);
			System.out.println(pathf);
			//해당경로로 jpg형식의 이미지파일을 저장
			ImageIO.write(image, "jpg", pathf);
			
			
			m_email = req.getParameter("email");
			String m_pw = req.getParameter("id");
			String m_phone = req.getParameter("m_phone");
			String m_name = req.getParameter("name");
			String m_addr1 = req.getParameter("m_addr1");
			String m_addr2 = req.getParameter("m_addr2");
			String m_addr3 = req.getParameter("m_addr3");
			String m_addr = m_addr1 + "!" + m_addr2 + "!" + m_addr3; // !는 구분자
			
			System.out.println(m_email);
			System.out.println(m_pw);
			System.out.println(m_phone);
			System.out.println(m_addr);
			System.out.println(m_name);
			
			m.setM_email(m_email);
			m.setM_pw(m_pw);
			m.setM_phone(m_phone);
			m.setM_addr(m_addr);
			m.setM_name(m_name);
			m.setM_photo(newFileName);
			
			
			if (ss.getMapper(MemberMapper.class).joinKakao(m) == 1) {
				Member dbMember = ss.getMapper(MemberMapper.class).loginUserKakao(m_email);
				req.getSession().setAttribute("loginMember", dbMember);
				req.getSession().setMaxInactiveInterval(60 * 30);
				response.setContentType("text/html; charset=euc-kr");
				PrintWriter script = response.getWriter();
				script.println("<script>");
				script.println("alert('회원가입이 완료되었습니다.');");
				script.println("location.href ='index.go'");
				script.println("</script>");
				script.close();
				System.out.println("카카오 가입 성공");
			} else {
				req.setAttribute("result", "가입 실패");
				System.out.println("카카오 가입 실패");
			}
		} catch (Exception e) {
			e.printStackTrace();
			
			req.setAttribute("result", "가입 실패");
		}
		
		
		
		
		
		
	}


	// 카카오로 가입되어있는지 체크
	public void loginKakao(Member m, HttpServletRequest req, HttpServletResponse response, String m_email) {
		
		Member dbMember = ss.getMapper(MemberMapper.class).loginUserKakao(m_email);
		
		if(!(dbMember == null)) {
			req.getSession().setAttribute("loginMember", dbMember);
			req.getSession().setMaxInactiveInterval(60 * 30);
			System.out.println("카카오 로그인 성공");
		} 
	}


	// 카카오 회원 정보 수정
	public void updateKakao(Member m, HttpServletRequest req, HttpServletResponse response) {

		String path = req.getSession().getServletContext().getRealPath("resources/files");
		MultipartRequest mr = null;
		Member loginMember = (Member) req.getSession().getAttribute("loginMember");
		String oldFile = loginMember.getM_photo();
		String newFile = null;
		String oldName = loginMember.getM_name();
		String newName = "";
		String oldPhone = loginMember.getM_phone();
		String newPhone = "";
		try {
			mr = new MultipartRequest(req, path, 10 * 1024 * 1024, "utf-8", new DefaultFileRenamePolicy());
			newFile = mr.getFilesystemName("m_photo");
			String m_name = mr.getParameter("m_name");
			String m_phone = mr.getParameter("m_phone");
			if (newFile == null) {
				newFile = oldFile;
			} else {
				newFile = URLEncoder.encode(newFile, "utf-8");
				newFile = newFile.replace("+", " ");
			}
			if(m_name.length() == 0) {
				newName = oldName;
			} else {
				newName = m_name;
			}
			if(m_phone.length() == 0) {
				newPhone = oldPhone;
			} else {
				newPhone = m_phone;
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("result", "수정실패");
			return;
		}
		
		try {
			String m_addr1 = mr.getParameter("m_addr1");
			String m_addr2 = mr.getParameter("m_addr2");
			String m_addr3 = mr.getParameter("m_addr3");
			String m_addr = m_addr1 + "!" + m_addr2 + "!" + m_addr3;
			String m_photo = newFile;

			System.out.println(newName); // 신규 이름
			System.out.println(newPhone); // 신규 핸드폰번호
			System.out.println(m_addr);
			System.out.println(m_photo);
			m.setM_email(loginMember.getM_email());
			m.setM_name(newName);
			m.setM_phone(newPhone);
			m.setM_addr(m_addr);
			m.setM_photo(m_photo);
			m.setM_point(loginMember.getM_point());
			m.setM_pay(loginMember.getM_pay());
			m.setM_type("kakao");
			 if(ss.getMapper(MemberMapper.class).updateKakao(m)== 1) {
				System.out.println("카카오 회원정보 수정 성공");
				response.setContentType("text/html; charset=euc-kr");
				PrintWriter script = response.getWriter();
				script.println("<script>");
				script.println("alert('회원정보를 수정하였습니다.');");
				script.println("location.href ='index.go'");
				script.println("</script>");
				script.close();
				req.getSession().setAttribute("loginMember", m);
				
				if (!oldFile.equals(newFile)) {
					oldFile = URLDecoder.decode(oldFile, "utf-8");
					new File(path + "/" + oldFile).delete();
				}
			 } else {
				System.out.println("카카오 회원정보 수정 실패");
				if (!oldFile.equals(newFile)) {
					newFile = URLDecoder.decode(newFile, "utf-8");
					new File(path + "/" + newFile).delete();
				}
			}
			
		
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("result", "수정실패");
			if (!oldFile.equals(newFile)) {
				try {
					newFile = URLDecoder.decode(newFile, "utf-8");
				} catch (UnsupportedEncodingException e1) {
				}
				new File(path + "/" + newFile).delete();
			}
		}
		
		
	}

	// 카카오 회원탈퇴
		public void kakaoWithdrawal(Member m, HttpServletRequest req, HttpServletResponse response) {
			
			try {
				
				// 회원정보 세션 받아오기
				Member m2 = (Member) req.getSession().getAttribute("loginMember");
				
				
					if(ss.getMapper(MemberMapper.class).kakaoWithdrawal(m2) == 1) {
						System.out.println("카카오 회원탈퇴 성공");
						String path = req.getSession().getServletContext().getRealPath("resources/files");
						String jm_photo = m2.getM_photo();
						jm_photo = URLDecoder.decode(jm_photo, "utf-8");
						new File(path + "/" + jm_photo).delete();  // 폴더에 저장되있는 사진 삭제

						logout(req);  // 로그아웃 시켜주면 값들 null로 바뀜
						
						response.setContentType("text/html; charset=euc-kr");
						PrintWriter script = response.getWriter();
						script.println("<script>");
						script.println("alert('회원탈퇴가 완료되었습니다.');");
						script.println("location.href = 'index.go';");
						script.println("</script>");
						script.close();
					} else {
						System.out.println("카카오 회원탈퇴 실패");
				} 
				
			
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("DB서버 문제..");
			}
			
		}
	
}

	

