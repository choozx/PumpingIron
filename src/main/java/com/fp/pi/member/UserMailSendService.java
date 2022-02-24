package com.fp.pi.member;

import java.util.Random;

import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;
import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class UserMailSendService {

	@Autowired
	private JavaMailSender mailSender;
	@Autowired
	private SqlSession ss;
	private MemberMapper mDAO;
	
	
	// 이메일 난수 만드는 메서드
		private String init() {
			Random ran = new Random();
			StringBuffer sb = new StringBuffer();
			int num = 0;

			do {
				num = ran.nextInt(75) + 48;
				if ((num >= 48 && num <= 57) || (num >= 65 && num <= 90) || (num >= 97 && num <= 122)) {
					sb.append((char) num);
				} else {
					continue;
				}

			} while (sb.length() < size);
			if (lowerCheck) {
				return sb.toString().toLowerCase();
			}
			return sb.toString();
		}

		// 난수를 이용한 키 생성
		private boolean lowerCheck;
		private int size;

		public String getKey(boolean lowerCheck, int size) {
			this.lowerCheck = lowerCheck;
			this.size = size;
			return init();
		}
	
	
	
	
	public void mailSendWithUserKey(String m_email, HttpServletRequest req) {
		
		String key = getKey(false, 20);
		mDAO = ss.getMapper(MemberMapper.class);
		mDAO.GetKey(m_email, key); 
		MimeMessage mail = mailSender.createMimeMessage();
		String htmlStr = "<h2>안녕하세요. Pumping Iron입니다.</h2><br><br>" 
				+ "<h3>" + m_email + "님</h3>" + "<p>인증하기 버튼을 누르시면 로그인을 하실 수 있습니다." 
				+ "<a href='http://localhost" + req.getContextPath() + "/user/key_alter?m_email="+ m_email +"&m_key="+key+"'>인증하기</a></p>"
				+ "(혹시 잘못 전달된 메일이라면 이 이메일을 무시하셔도 됩니다)";
		try {
			mail.setSubject("[본인인증] Pumping Iron 회원가입 인증메일입니다.", "utf-8");
			mail.setText(htmlStr, "utf-8", "html");
			mail.addRecipient(RecipientType.TO, new InternetAddress(m_email));
			mailSender.send(mail);
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		
	}



	// 이메일 인증하면 m_key를 Y값으로
	public int alter_userKey_service(String m_email, String key) {

		int resultCnt = 0;
		
		mDAO = ss.getMapper(MemberMapper.class);
		
		resultCnt = mDAO.alter_userKey(m_email, key);
		
		return resultCnt;	
	}


	public int mailSendWithPassword(String m_email, String m_phone, HttpServletRequest req) {
		
		// 임시 비밀번호는 6자리로 보내고 데이터베이스 비밀번호를 바꿔준다
				int result = 0;
				System.out.println(m_email);
				System.out.println(m_phone);
				String key = getKey(false, 6);
				mDAO = ss.getMapper(MemberMapper.class);
				
				// 회원 아이디 불러오고 
				Member dbMember = mDAO.loginUser(m_email);
				// 이름 얻기
				if (dbMember == null) {
					result = 0;
					System.out.println("result 값은 : " + result);
					return result;
				}
				System.out.println("해당 이메일이 있음 : " + dbMember.getM_email());
				String name = dbMember.getM_name();
				System.out.println("이름은 : " + name);
				MimeMessage mail = mailSender.createMimeMessage();
				String htmlStr = "<h2>안녕하세요 '"+ name +"' 님</h2><br><br>" 
						+ "<p>비밀번호 찾기를 신청해주셔서 임시 비밀번호를 발급해드렸습니다.</p>"
						+ "<p>임시로 발급 드린 비밀번호는 <h2 style='color : blue'>'" + key +"'</h2>이며 로그인 후 마이페이지에서 비밀번호를 변경해주시면 됩니다.</p><br>"
						+ "<h3><a href='http://localhost" + req.getContextPath() + "/index.go" + "'>Pumping Iron 홈페이지 접속 </a></h3><br><br>"
						+ "(혹시 잘못 전달된 메일이라면 이 이메일을 무시하셔도 됩니다.)";
				try {
					if(dbMember.getM_email().equals(m_email) && dbMember.getM_phone().equals(m_phone)) {
					mail.setSubject("[Pumping Iron] 임시 비밀번호가 발급되었습니다", "utf-8");
					mail.setText(htmlStr, "utf-8", "html");
					mail.addRecipient(RecipientType.TO, new InternetAddress(dbMember.getM_email()));
					mailSender.send(mail);
					System.out.println("이메일 발송 완료");
					System.out.println("result 값은 : " + result);
					result = 1;
					
					if(mDAO.searchPassword(m_email, m_phone, key) == 1) {
						System.out.println("임시 비밀번호 변경 : " + key);
					return result;
					}
					
					} else {
						System.out.println("회원정보를 올바르게 입력해주세요.");
						result = -4;
						System.out.println("result 값은 : " + result);
						return result;
					}
				} catch (Exception e) { 
					e.printStackTrace();
					System.out.println("DB서버 오류..");
				}
		
			
		
		return result;
		
		
		
	}

}
