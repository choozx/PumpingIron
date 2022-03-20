package com.fp.pi.customerservice;

import java.io.File;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
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
import com.fp.pi.tips.Selector;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@Service
public class CustomerServiceDAO {

	@Autowired
	private MailSender sender;
	
	@Autowired
	private SqlSession ss;
	
	@Autowired
	private com.fp.pi.SiteOption so;
	
	private MemberMapper mDAO;
	
	private int allEventCount;
	

	public int getAllEventCount() {
		return allEventCount;
	}

	public void setAllEventCount(int allEventCount) {
		this.allEventCount = allEventCount;
	}

	public void calcAllEventCount() { // allMsgCount를 구한 이 기능을 먼저 불러줘야함
		Selector sSel = new Selector("", null, null); // 검색어가 없는 상황에서 전부 가져옴
		allEventCount = ss.getMapper(CustomerServiceMapper.class).getEventCount(sSel);
	}

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
	public int getEvent(HttpServletRequest req) {
		
	 List<Event> events  = ss.getMapper(CustomerServiceMapper.class).getevent();
	 allEventCount = events.size();
	 return events.size();
	}
	// 공지사항 글 가져오기
	public int getEvent2(HttpServletRequest req) {
		
		 List<Event> events  = ss.getMapper(CustomerServiceMapper.class).getevent2();
		 allEventCount = events.size();
		 return events.size();
		}
	// 이벤트 글 가져오기
	public int getEvent4(HttpServletRequest req) {
		
		 List<Event> events  = ss.getMapper(CustomerServiceMapper.class).getevent6();
		 allEventCount = events.size();
		 return events.size();
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
				response.setContentType("text/html; charset=euc-kr");
				PrintWriter script = response.getWriter();
				script.println("<script>");
				script.println("alert('해당 글을 수정하였습니다.');");
				script.println("location.href = 'customerservice.event.go';");
				script.println("</script>");
				script.close();
				
			} else {
				System.out.println("공지사항&이벤트 글 수정 실패");
			}
		} catch (Exception e2) {
			e2.printStackTrace();
			System.out.println("DB서버 문제..");
		}
	}

	public void getEvent1(int pageNo, HttpServletRequest req) {
		int count = so.getSnsCountPerpage(); // 한페이지당 몇개씩 보여줄거냐
		int start = (pageNo - 1) * count + 1;
		int end = start + (count - 1);

		Selector search = (Selector) req.getSession().getAttribute("search");
		int eventCount = 0;

		if (search == null) {
			search = new Selector("", new BigDecimal(start), new BigDecimal(end));
			eventCount = getEvent(req); // 전체 게시글 수 
		} else {
			search.setStart(new BigDecimal(start));
			search.setEnd(new BigDecimal(end));
			eventCount = ss.getMapper(CustomerServiceMapper.class).getEventCount(search);
		}
		
		
		
		List<Event> events = ss.getMapper(CustomerServiceMapper.class).getEvent(search);
		
		
		int pageCount = (int) Math.ceil(eventCount / (double) count);
		req.setAttribute("pageCount", pageCount);
		System.out.println(eventCount); // 0
		System.out.println(count); // 5
		System.out.println(pageCount); // 0
		req.setAttribute("events", events);
		req.setAttribute("curPage", pageNo);

	}
	
	public void getEvent3(int pageNo, HttpServletRequest req) {
		int count = so.getSnsCountPerpage(); // 한페이지당 몇개씩 보여줄거냐
		int start = (pageNo - 1) * count + 1;
		int end = start + (count - 1);

		Selector search = (Selector) req.getSession().getAttribute("search");
		int eventCount = 0;

		if (search == null) {
			search = new Selector("", new BigDecimal(start), new BigDecimal(end));
			eventCount = getEvent2(req); // 전체 게시글 수 
		} else {
			search.setStart(new BigDecimal(start));
			search.setEnd(new BigDecimal(end));
			eventCount = ss.getMapper(CustomerServiceMapper.class).getEventCount2(search);
		}
		
		
		
		List<Event> events = ss.getMapper(CustomerServiceMapper.class).getEvent4(search);
		
		
		int pageCount = (int) Math.ceil(eventCount / (double) count);
		req.setAttribute("pageCount", pageCount);
		System.out.println(eventCount); // 0
		System.out.println(count); // 5
		System.out.println(pageCount); // 0
		req.setAttribute("events", events);
		req.setAttribute("curPage", pageNo);

	}
	
	
	public void searchEvent(Selector sSel, HttpServletRequest req) {
		req.getSession().setAttribute("search", sSel);
		
	}

	public void getEvent5(int pageNo, HttpServletRequest req) {
		int count = so.getSnsCountPerpage(); // 한페이지당 몇개씩 보여줄거냐
		int start = (pageNo - 1) * count + 1;
		int end = start + (count - 1);

		Selector search = (Selector) req.getSession().getAttribute("search");
		int eventCount = 0;

		if (search == null) {
			search = new Selector("", new BigDecimal(start), new BigDecimal(end));
			eventCount = getEvent4(req); // 전체 게시글 수 
		} else {
			search.setStart(new BigDecimal(start));
			search.setEnd(new BigDecimal(end));
			eventCount = ss.getMapper(CustomerServiceMapper.class).getEventCount3(search);
		}
		
		
		
		List<Event> events = ss.getMapper(CustomerServiceMapper.class).getEvent5(search);
		
		
		int pageCount = (int) Math.ceil(eventCount / (double) count);
		req.setAttribute("pageCount", pageCount);
		System.out.println(eventCount); // 0
		System.out.println(count); // 5
		System.out.println(pageCount); // 0
		req.setAttribute("events", events);
		req.setAttribute("curPage", pageNo);
		
	}

	// 고객센터(자주찾는질문) 글 작성
	public void writeQuestion(Member m, Question q, HttpServletRequest req) {
		
		System.out.println(q.getQ_type());
		System.out.println(q.getQ_title());
		System.out.println(q.getQ_content());
		
		if(ss.getMapper(CustomerServiceMapper.class).writeQuestion(q) == 1) {
			System.out.println("자주찾는질문 글 작성 성공");
		} else {
			System.out.println("자주찾는질문 글 작성 실패");
		}
		
	}
	// 고객센터(자주찾는질문) 글 가져오기
	public void getAllQuestion(HttpServletRequest req) {
		req.setAttribute("questions", ss.getMapper(CustomerServiceMapper.class).getAllQuestion());
	}

	// 고객센터(자주찾는질문) 글 삭제하기
	public void deleteQuestion(Question q, HttpServletRequest req, HttpServletResponse response) {
		System.out.println("삭제할 번호 : " + q.getQ_no());
		
			
		try {
			
			if(ss.getMapper(CustomerServiceMapper.class).deleteQuestion(q) == 1) {
				System.out.println("자주찾는질문 글 삭제 성공");
				response.setContentType("text/html; charset=euc-kr");
				PrintWriter script = response.getWriter();
				script.println("<script>");
				script.println("alert('해당 글을 삭제하였습니다.');");
				script.println("location.href = 'customerservice.go';");
				script.println("</script>");
				script.close();
			} else {
				System.out.println("자주찾는질문 글 삭제 실패");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("DB서버 문제..");
	}
}
	// 고객센터(자주찾는질문) 글 상세정보
	public void detailQuestion(Question q, HttpServletRequest req) {
		System.out.println("해당 글 번호 : " + q.getQ_no());
//		Question qq = ss.getMapper(CustomerServiceMapper.class).detailQuestion(q);
//		System.out.println(qq.getQ_content());
//		String content = qq.getQ_content();
//		content.replaceAll("<br>", "\r\n");
//		System.out.println(content);
		
		req.setAttribute("qdetail", ss.getMapper(CustomerServiceMapper.class).detailQuestion(q));
	}
	
	// 고객센터(자주찾는질문) 글 수정하기
	public void updateQuestion(Question q, HttpServletRequest req, HttpServletResponse response) {
		
		System.out.println("수정할 번호 : " + q.getQ_no());
		System.out.println(q.getQ_type());
		System.out.println(q.getQ_title());
		System.out.println(q.getQ_content());
		
		q.setQ_no(q.getQ_no());
		q.setQ_title(q.getQ_title());
		q.setQ_content(q.getQ_content());
		q.setQ_type(q.getQ_type());
	
	try {
		
		if(ss.getMapper(CustomerServiceMapper.class).updateQuestion(q) == 1) {
			System.out.println("자주찾는질문 글 수정 성공");
			response.setContentType("text/html; charset=euc-kr");
			PrintWriter script = response.getWriter();
			script.println("<script>");
			script.println("alert('해당 글을 수정하였습니다.');");
			script.println("location.href = 'customerservice.go';");
			script.println("</script>");
			script.close();
		} else {
			System.out.println("자주찾는질문 글 수정 실패");
		}
		
	} catch (Exception e) {
		e.printStackTrace();
		System.out.println("DB서버 오류..");
	}
		
	}
	// 고객센터(1:1문의하기) 글 작성하기
	public void writeInquiry(Member m, Inquiry i, HttpServletRequest req, HttpServletResponse response) {
		
		
		String path = req.getSession().getServletContext().getRealPath("resources/files");
		MultipartRequest mr = null;
		try {
			mr = new MultipartRequest(req, path, 10 * 1024 * 1024, "utf-8", new DefaultFileRenamePolicy());
		} catch (Exception e) {
			e.printStackTrace();
			
		}

		try {
			Member loginMember = (Member) req.getSession().getAttribute("loginMember");
			String i_type = mr.getParameter("i_type");
			String i_title = mr.getParameter("i_title");
			String i_content = mr.getParameter("i_content");
			String i_to = mr.getParameter("i_to");
			String i_photo1 = mr.getFilesystemName("i_photo1");
			System.out.println(i_photo1);
			String i_photo2 = mr.getFilesystemName("i_photo2");
			System.out.println(i_photo2);
			String i_photo3 = mr.getFilesystemName("i_photo3");
			System.out.println(i_photo3);
			String i_photo4 = mr.getFilesystemName("i_photo4");
			System.out.println(i_photo4);
			
                
          
			
			
			
			if(i_photo1 == null && i_photo2 == null && i_photo3 == null && i_photo4 == null) {
				i_photo1 = " ";
				i_photo2 = " ";
				i_photo3 = " ";
				i_photo4 = " ";
				String i_photo = i_photo1 + i_photo2 + i_photo3 + i_photo4;
				System.out.println("i_photo null일 때 : " + i_photo);
				i_photo = URLEncoder.encode(i_photo, "utf-8");
				i_photo = i_photo.replace("+", " ");
				i.setI_photo(i_photo);
			} else {				
				if(i_photo1 != null) {
					i_photo1 = URLEncoder.encode(i_photo1, "utf-8");				
				} if (i_photo2 != null){
					i_photo2 = URLEncoder.encode(i_photo2, "utf-8");
				} if (i_photo3 != null) {
					i_photo3 = URLEncoder.encode(i_photo3, "utf-8");
				} if (i_photo4 != null) {
					i_photo4 = URLEncoder.encode(i_photo4, "utf-8");
				}
				
				String i_photo = i_photo1 + "!" + i_photo2 + "!" + i_photo3 + "!" + i_photo4; // !는 구분자
				System.out.println("i_photo null이 아닐 때 : " + i_photo);
				i_photo = URLEncoder.encode(i_photo, "utf-8");
				System.out.println("i_photo null이 아닐 때 : " + i_photo);
				i_photo = i_photo.replace("+", " ");
				System.out.println("i_photo null이 아닐 때 : " + i_photo);
				i.setI_photo(i_photo);
			}
			
			System.out.println(i_type);
			System.out.println(i_title);
			System.out.println(i_content);
			System.out.println(i_to);
			System.out.println(loginMember.getM_email());
			
			i.setI_type(i_type);
			i.setI_title(i_title);
			i.setI_content(i_content);
			i.setI_to(i_to);
			i.setI_from(loginMember.getM_email());
			
			
			

			if (ss.getMapper(CustomerServiceMapper.class).writeInquiry(i) == 1) {
				System.out.println("1:1문의  작성 성공");
			} else {
				System.out.println("1:1문의 작성 실패");
			}
		
		} catch (Exception e) {
			e.printStackTrace();
			String fileName1 = mr.getFilesystemName("i_photo1");
			String fileName2 = mr.getFilesystemName("i_photo2");
			String fileName3 = mr.getFilesystemName("i_photo3");
			String fileName4 = mr.getFilesystemName("i_photo4");
			new File(path + "/" + fileName1).delete();
			new File(path + "/" + fileName2).delete();
			new File(path + "/" + fileName3).delete();
			new File(path + "/" + fileName4).delete();
			System.out.println("DB서버 오류..");
		}
	}
	
	// 고객센터(1:1문의하기) 글 가져오기
	public void getAllInquiry(HttpServletRequest req) {
		try {
			Member m = (Member) req.getSession().getAttribute("loginMember");
			// 사용자
			req.setAttribute("inquirys", ss.getMapper(CustomerServiceMapper.class).getAllInquiry(m));
			
			// admin
			req.setAttribute("inquiryAdmins", ss.getMapper(CustomerServiceMapper.class).getAllInquiryAdmin(m));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public void detailInquiry(Inquiry i, HttpServletRequest req) {
		System.out.println("해당 글 번호 : " + i.getI_no());
		req.setAttribute("idetail", ss.getMapper(CustomerServiceMapper.class).detailInquiry(i));
	}
	
	public void splitInquiryImg(HttpServletRequest req, Inquiry i ) { // 내 정보조회 할 때 db에 !로 주소를 구분한거를 안나오게 하기 위함
		Inquiry ii = ss.getMapper(CustomerServiceMapper.class).detailInquiry(i);
		String i_photo = ii.getI_photo();
		System.out.println("split하기 전 이미지 : " + i_photo);
		if(i_photo != "    ") {
			String[] i_photo2 = i_photo.split("%21");
			System.out.println("split한 후 이미지 : " + i_photo2);
			req.setAttribute("i_photo", i_photo2);
		}
		
	}
	
 
}
	


