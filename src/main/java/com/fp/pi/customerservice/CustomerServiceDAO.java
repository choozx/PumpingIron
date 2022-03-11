package com.fp.pi.customerservice;

import java.io.File;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

import com.fp.pi.member.Member;
import com.fp.pi.member.MemberMapper;
import com.fp.pi.tips.TipsMapper;

@Service
public class CustomerServiceDAO {

	@Autowired
	private MailSender sender;
	
	@Autowired
	private SqlSession ss;
	
	private MemberMapper mDAO;

  // 제휴 문의(이메일)
	public void associate(Member m, HttpServletRequest req, HttpServletResponse response) {
		
		mDAO = ss.getMapper(MemberMapper.class);
		
		String name = req.getParameter("m_name"); // 보내는 사람 이름
		String phone = req.getParameter("m_phone"); // 보내는 사람 연락처
		String setfrom = req.getParameter("m_email"); // 보내는 사람 이메일
		String tomail = req.getParameter("m_pw"); // 받는 사람 이메일(hidden으로 숨김)
		String content = req.getParameter("m_photo"); // 내용

		System.out.println(name);
		System.out.println(setfrom); // 보낸사람
		System.out.println(tomail);
		System.out.println(content);
		
		try {
			SimpleMailMessage message = new SimpleMailMessage();
			message.setTo(tomail);
			message.setFrom(setfrom);
			message.setSubject("[제휴문의] Pumping Iron 제휴문의 메일입니다.");
			message.setText(content + "\n" + name + "\n" + phone + "\n" + setfrom);
			
			
//			MimeMessageHelper messageHelper = new MimeMessageHelper(message,true, "UTF-8");
//			messageHelper.setFrom(new InternetAddress(setfrom));// 보내는사람 생략하거나 하면 정상작동을 안함
//			messageHelper.setTo(InternetAddress.parse(tomail)); // 받는사람 이메일
//			messageHelper.setSubject("[제휴문의] Pumping Iron 제휴문의 메일입니다."); // 메일제목은 생략이 가능하다
//			messageHelper.setText(content + "\n" + name + "\n" + phone); // 메일 내용
//			messageHelper.setReplyTo(new InternetAddress(setfrom,"replyTo", "UTF-8")); // 답장받을 주소
//			
			// 메일 보내기
			
			sender.send(message);
			response.setContentType("text/html; charset=euc-kr");
			PrintWriter script = response.getWriter();
			script.println("<script>");
			script.println("alert('제휴문의 메일을 발송하였습니다.');");
			script.println("location.href ='index.go'");
			script.println("</script>");
			script.close();
			System.out.println("제휴문의 메일 발송 성공");
			
			
		} catch (Exception e) {
			System.out.println(e);
			System.out.println("제휴문의 메일 발송 실패");
		}
		
	}

	// 공지사항 & 이벤트 글 작성하기
	public void writeEvent(Event e, Member m, HttpServletRequest req) {
		
		System.out.println(e.getE_title());
		System.out.println(e.getE_content());
		System.out.println(e.getE_type());
	if(ss.getMapper(CustomerServiceMapper.class).writeEvent(e) == 1) {
		System.out.println("공지사항&이벤트 글 작성 성공");
	} else {
		System.out.println("공지사항&이벤트 글 작성 실패");
	}
		
	}


	// 공지사항 & 이벤트 글 가져오기
	public void getEvent(HttpServletRequest req) {
		
	 List<Event> events  = ss.getMapper(CustomerServiceMapper.class).getEvent();
	 
	 req.setAttribute("events", events);
	}

	// 공지사항 & 이벤트 글 삭제하기
	public void deleteEvent(Event e, Member m, HttpServletRequest req, HttpServletResponse response) {

		System.out.println("삭제할 번호 : " + e.getE_no());
		String img = req.getParameter("img");
		System.out.println("가져온 이미지 : " + img);
		img = img.replace("resources/file/", "");
		System.out.println("replace한 결과 : " + img);
		
		try {
			
			if(ss.getMapper(CustomerServiceMapper.class).deleteEvent(e) == 1) {
				System.out.println("공지사항&이벤트 글 삭제 성공");
				String path = req.getSession().getServletContext().getRealPath("resources/file");
				new File(path + "/" + img).delete();
				System.out.println("이미지 삭제 성공");
				response.setContentType("text/html; charset=euc-kr");
				PrintWriter script = response.getWriter();
				script.println("<script>");
				script.println("alert('해당 글을 삭제하였습니다.');");
				script.println("location.href = 'customerservice.event.go';");
				script.println("</script>");
				script.close();
			} else {
				System.out.println("공지사항&이벤트 글 삭제 실패");
			}
			
		} catch (Exception e2) {
			e2.printStackTrace();
			System.out.println("DB서버 문제..");
		}
		
	}

	// 공지사항&이벤트 상세 정보
	public void getDetail(HttpServletRequest req, Event e) {

		req.setAttribute("edetail", ss.getMapper(CustomerServiceMapper.class).getDetail(e));
	}

	
	
	// 공지사항&이벤트 수정
	public void updateEvent(Event e, HttpServletRequest req, HttpServletResponse response) {

		
//		String img = req.getParameter("img");
//		System.out.println("가져온 이미지 : " + img);
//		img = img.replace("resources/file/", "");
//		System.out.println("replace한 결과 : " + img);
//		
//		Event eee = ss.getMapper(CustomerServiceMapper.class).getDetail(e);
//		System.out.println(eee.getE_content());
//		String path = req.getSession().getServletContext().getRealPath("resources/files");
//		String oldFile = eee.getE_content();
//		try {
//			oldFile = URLDecoder.decode(oldFile, "utf-8");
//			System.out.println(oldFile);
//			new File(path + "/" + oldFile);
//		} catch (Exception e1) {
//			e1.printStackTrace();
//		}
		
		System.out.println("수정할 번호 : " + e.getE_no());
		System.out.println(e.getE_type());
		System.out.println(e.getE_title());
		System.out.println(e.getE_content());
		
		
		
		e.setE_no(e.getE_no());
		e.setE_type(e.getE_type());
		e.setE_title(e.getE_title());
		e.setE_content(e.getE_content());
		
		
		try {
			if (ss.getMapper(CustomerServiceMapper.class).updateEvent(e) == 1) {
				
				
				System.out.println("공지사항&이벤트 글 수정 성공");
				
				
			} else {
				System.out.println("공지사항&이벤트 글 수정 실패");
			}
		} catch (Exception e2) {
			e2.printStackTrace();
			System.out.println("DB서버 문제..");
		}
	}
		
	
	
}
