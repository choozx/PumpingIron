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
		EventSelector sSel = new EventSelector("", null, null); // 검색어가 없는 상황에서 전부 가져옴
		allEventCount = ss.getMapper(CustomerServiceMapper.class).getEventCount(sSel);
	}
	
	private int allInquiryCount;
	

	public int getAllInquiryCount() {
		return allInquiryCount;
	}

	public void setAllInquiryCount(int allInquiryCount) {
		this.allInquiryCount = allInquiryCount;
	}

	public void calcAllInquiryCount() { // allMsgCount를 구한 이 기능을 먼저 불러줘야함
		CustomerServiceSelector sSel = new CustomerServiceSelector("", "", null, null); // 검색어가 없는 상황에서 전부 가져옴
	//	allInquiryCount = ss.getMapper(CustomerServiceMapper.class).getInquiryCount(sSel);
	}

	private int allInquiryAdminsCount;
		
	public int getAllInquiryAdminsCount() {
		return allInquiryAdminsCount;
	}

	public void setAllInquiryAdminsCount(int allInquiryAdminsCount) {
		this.allInquiryAdminsCount = allInquiryAdminsCount;
	}

	public void calcAllInquiryAdmins() { // allMsgCount를 구한 이 기능을 먼저 불러줘야함
		CustomerServiceSelector sSel = new CustomerServiceSelector("", "", null, null); // 검색어가 없는 상황에서 전부 가져옴
		allInquiryAdminsCount = ss.getMapper(CustomerServiceMapper.class).getInquiryAdminCount(sSel);
	}

	private int allRequestCount;

	
	public int getAllRequestCount() {
		return allRequestCount;
	}

	public void setAllRequestCount(int allRequestCount) {
		this.allRequestCount = allRequestCount;
	}

	public void calcAllRequestCount() { // allMsgCount를 구한 이 기능을 먼저 불러줘야함
		CustomerServiceSelector sSel = new CustomerServiceSelector("", "", null, null); // 검색어가 없는 상황에서 전부 가져옴
	//	allInquiryCount = ss.getMapper(CustomerServiceMapper.class).getInquiryCount(sSel);
	}
	
	private int allRequestAdminsCount;
	
	public int getAllRequestAdminsCount() {
		return allRequestAdminsCount;
	}

	public void setAllRequestAdminsCount(int allRequestAdminsCount) {
		this.allRequestAdminsCount = allRequestAdminsCount;
	}
	
	public void calcAllRequestAdmins() { // allMsgCount를 구한 이 기능을 먼저 불러줘야함
		CustomerServiceSelector sSel = new CustomerServiceSelector("", "", null, null); // 검색어가 없는 상황에서 전부 가져옴
		allRequestAdminsCount = ss.getMapper(CustomerServiceMapper.class).getRequestAdminCount(sSel);
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

		EventSelector search = (EventSelector) req.getSession().getAttribute("searchEvent");
		int eventCount = 0;

		if (search == null) {
			search = new EventSelector("", new BigDecimal(start), new BigDecimal(end));
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

		EventSelector search = (EventSelector) req.getSession().getAttribute("searchEvent");
		int eventCount = 0;

		if (search == null) {
			search = new EventSelector("", new BigDecimal(start), new BigDecimal(end));
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
	
	
	public void searchEvent(EventSelector sSel, HttpServletRequest req) {
		req.getSession().setAttribute("searchEvent", sSel);
		
	}

	public void getEvent5(int pageNo, HttpServletRequest req) {
		int count = so.getSnsCountPerpage(); // 한페이지당 몇개씩 보여줄거냐
		int start = (pageNo - 1) * count + 1;
		int end = start + (count - 1);

		EventSelector search = (EventSelector) req.getSession().getAttribute("searchEvent");
		int eventCount = 0;

		if (search == null) {
			search = new EventSelector("", new BigDecimal(start), new BigDecimal(end));
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
	public int getAllInquiry(HttpServletRequest req) {
		try {
			Member m = (Member) req.getSession().getAttribute("loginMember");
			// 사용자
			req.setAttribute("inquiryAdmins", ss.getMapper(CustomerServiceMapper.class).getAllInquiryAdmin(m));
			List<Inquiry> inquirys  = ss.getMapper(CustomerServiceMapper.class).getAllInquiry(m);
			
			// admin
			if(m.getM_email().equals("admin")) {
				System.out.println("admin");
				List<Inquiry> inquiryAdmins =  ss.getMapper(CustomerServiceMapper.class).getAllInquiryAdmin(m);
				allInquiryAdminsCount = inquiryAdmins.size();
				System.out.println("allInquiryAdminsCount : " + allInquiryAdminsCount);
				return inquiryAdmins.size();
			} else {
			allInquiryCount = inquirys.size();
			System.out.println("allInquiryCount : " + allInquiryCount);
			 return inquirys.size();
			
		}	
		} catch (Exception e) {
			e.printStackTrace();
		}
		return allInquiryCount;
		
	}
	// 고객센터(1:1문의하기) 글 상세정보
	public void detailInquiry(Inquiry i, HttpServletRequest req) {
		System.out.println("해당 글 번호 : " + i.getI_no());
		req.setAttribute("idetail", ss.getMapper(CustomerServiceMapper.class).detailInquiry(i));
	}
	// 고객센터(1:1문의하기) 글 상세정보 사진 나누기
	public void splitInquiryImg(HttpServletRequest req, Inquiry i ) { // 내 정보조회 할 때 db에 !로 주소를 구분한거를 안나오게 하기 위함
		Inquiry ii = ss.getMapper(CustomerServiceMapper.class).detailInquiry(i);
		if(ii.getI_photo() != null) {
			
			String i_photo = ii.getI_photo();
			System.out.println("split하기 전 이미지 : " + i_photo);
			if(i_photo != "    ") {
				String[] i_photo2 = i_photo.split("%21");
				System.out.println("split한 후 이미지 : " + i_photo2);
				req.setAttribute("i_photo", i_photo2);
			}
			
		}
	}
	// 고객센터(1:1문의하기 답변) 작성하기
	public void writeAnswer(Member m, Inquiry i, InquiryAnswer ia, HttpServletRequest req,
			HttpServletResponse response) {
		
		String path = req.getSession().getServletContext().getRealPath("resources/files");
		MultipartRequest mr = null;
		try {
			mr = new MultipartRequest(req, path, 10 * 1024 * 1024, "utf-8", new DefaultFileRenamePolicy());
		} catch (Exception e) {
			e.printStackTrace();
			
		}

		try {
			int ia_no = Integer.parseInt(mr.getParameter("i_no"));
			String ia_type = mr.getParameter("ia_type");
			String ia_title = mr.getParameter("ia_title");
			String ia_content = mr.getParameter("ia_content");
			String ia_to = mr.getParameter("ia_to");	// 고
			String ia_from = mr.getParameter("ia_from"); // admin
			String ia_photo1 = mr.getFilesystemName("ia_photo1");
			System.out.println(ia_photo1);
			String ia_photo2 = mr.getFilesystemName("ia_photo2");
			System.out.println(ia_photo2);
			String ia_photo3 = mr.getFilesystemName("ia_photo3");
			System.out.println(ia_photo3);
			String ia_photo4 = mr.getFilesystemName("ia_photo4");
			System.out.println(ia_photo4);
			
			System.out.println(ia_no);
			System.out.println(ia_type);
			System.out.println(ia_title);
			System.out.println(ia_content);
			System.out.println(ia_to);
			System.out.println(ia_from);
			
			ia.setIa_no(ia_no);
			ia.setIa_type(ia_type);
			ia.setIa_no(ia_no);
			ia.setIa_title(ia_title);
			ia.setIa_content(ia_content);
			ia.setIa_to(ia_to);
			ia.setIa_from(ia_from);
			
			
			if(ia_photo1 == null && ia_photo2 == null && ia_photo3 == null && ia_photo4 == null) {
				ia_photo1 = " ";
				ia_photo2 = " ";
				ia_photo3 = " ";
				ia_photo4 = " ";
				String ia_photo = ia_photo1 + ia_photo2 + ia_photo3 + ia_photo4;
				System.out.println("ia_photo null일 때 : " + ia_photo);
				ia_photo = URLEncoder.encode(ia_photo, "utf-8");
				ia_photo = ia_photo.replace("+", " ");
				ia.setIa_photo(ia_photo);
			} else {				
				if(ia_photo1 != null) {
					ia_photo1 = URLEncoder.encode(ia_photo1, "utf-8");				
				} if (ia_photo2 != null){
					ia_photo2 = URLEncoder.encode(ia_photo2, "utf-8");
				} if (ia_photo3 != null) {
					ia_photo3 = URLEncoder.encode(ia_photo3, "utf-8");
				} if (ia_photo4 != null) {
					ia_photo4 = URLEncoder.encode(ia_photo4, "utf-8");
				}
				
				String ia_photo = ia_photo1 + "!" + ia_photo2 + "!" + ia_photo3 + "!" + ia_photo4; // !는 구분자
				System.out.println("i_photo null이 아닐 때 : " + ia_photo);
				ia_photo = URLEncoder.encode(ia_photo, "utf-8");
				System.out.println("i_photo null이 아닐 때 : " + ia_photo);
				ia_photo = ia_photo.replace("+", " ");
				System.out.println("i_photo null이 아닐 때 : " + ia_photo);
				ia.setIa_photo(ia_photo);
			}
			
			
			
			
			
			

			if (ss.getMapper(CustomerServiceMapper.class).writeAnswer(ia) == 1) {
				System.out.println("1:1문의답변 작성 성공");
				if(ss.getMapper(CustomerServiceMapper.class).updateChkAnswer(ia) == 1) {
					System.out.println("답변대기에서 답변완료로 변경");
				}
			} else {
				System.out.println("1:1문의답변 작성 실패");
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
			String fileName1 = mr.getFilesystemName("ia_photo1");
			String fileName2 = mr.getFilesystemName("ia_photo2");
			String fileName3 = mr.getFilesystemName("ia_photo3");
			String fileName4 = mr.getFilesystemName("ia_photo4");
			new File(path + "/" + fileName1).delete();
			new File(path + "/" + fileName2).delete();
			new File(path + "/" + fileName3).delete();
			new File(path + "/" + fileName4).delete();
			System.out.println("DB서버 오류..");
		}
	}
	// 고객센터(1:1문의하기) 답변 가져오기
	public void getAllAnswer(Member m, Inquiry i, InquiryAnswer ia, HttpServletRequest req,
			HttpServletResponse response) {
		ia.setIa_no(i.getI_no());
		System.out.println(ss.getMapper(CustomerServiceMapper.class).getAllAnswer(ia));
		
		req.setAttribute("answers", ss.getMapper(CustomerServiceMapper.class).getAllAnswer(ia));
		
		
	}
	// 고객센터(1:1문의하기 답변) 사진 나누기
	public void splitAnswerImg(HttpServletRequest req, Inquiry i,InquiryAnswer ia) { // 내 정보조회 할 때 db에 !로 주소를 구분한거를 안나오게 하기 위함
		InquiryAnswer ii = ss.getMapper(CustomerServiceMapper.class).getAllAnswer(ia);
		if(ii != null) {
		String ii_photo = ii.getIa_photo();
		System.out.println("split하기 전 이미지 : " + ii_photo);
		if(ii_photo != "    ") {
			String[] ii_photo2 = ii_photo.split("%21");
			System.out.println("split한 후 이미지 : " + ii_photo2);
			req.setAttribute("ii_photo", ii_photo2);
		}
		}
		
	}
	// 고객센터(1:1 문의 답변) 글  삭제하기-->
	public void deleteAnswer(Member m, Inquiry i, InquiryAnswer ia, HttpServletRequest req,
			HttpServletResponse response) {
	
	try {
		System.out.println("삭제할 번호 : " + ia.getIa_no());
		InquiryAnswer dbAnswer = ss.getMapper(CustomerServiceMapper.class).getAllAnswer(ia);
		System.out.println("삭제할 사진 : " + dbAnswer.getIa_photo());
		String db_photo = dbAnswer.getIa_photo();
		
		if(db_photo != "") {
			try {
				System.out.println("삭제할 사진 : " + dbAnswer.getIa_photo());
				String[] db_photo3 = db_photo.split("%21");
				String path = req.getSession().getServletContext().getRealPath("resources/files");
				new File(path + "/" + db_photo3[0]).delete();
				new File(path + "/" + db_photo3[1]).delete();
				new File(path + "/" + db_photo3[2]).delete();
				new File(path + "/" + db_photo3[3]).delete();
			} catch (Exception e) {
				// TODO: handle exception
			}
		} else {
			System.out.println("삭제할 사진 없음");
		}
		
	  if(ss.getMapper(CustomerServiceMapper.class).deleteAnswer(ia) == 1) {
		  System.out.println("답변 삭제 성공");
		if(ss.getMapper(CustomerServiceMapper.class).updateChkAnswer2(ia) == 1) {
			System.out.println("답변완료에서 답변대기로 변경");
			response.setContentType("text/html; charset=euc-kr");
			PrintWriter script = response.getWriter();
			script.println("<script>");
			script.println("alert('해당 답변을 삭제하였습니다.');");
			script.println("location.href = 'customerservice.go';");
			script.println("</script>");
			script.close();
			}
	  } else {
		  System.out.println("답변 삭제 실패");
	  }
	  
	} catch (Exception e) {
		e.printStackTrace();
		System.out.println("DB서버 오류..");
	}
   }
	// 고객센터(1:1문의) 페이징
	public void getInquiry(int pageNo, HttpServletRequest req, Member m, Inquiry i) {
		int count = so.getSnsCountPerpage(); // 한페이지당 몇개씩 보여줄거냐
		int start = (pageNo - 1) * count + 1;
		int end = start + (count - 1);
		
		Member dbMember = (Member) req.getSession().getAttribute("loginMember");
		m.setM_email(dbMember.getM_email());
		System.out.println(m.getM_email());
		
		CustomerServiceSelector search = (CustomerServiceSelector) req.getSession().getAttribute("searchCustomerService");
		int inquiryCount = 0;
		int inquiryAdminCount = 0;

		if (search == null) {
			if(dbMember.getM_email().equals("admin")) {
			search = new CustomerServiceSelector(m.getM_email(), "", new BigDecimal(start), new BigDecimal(end));
			inquiryAdminCount = getAllInquiry(req); // 전체 게시글 수 
			System.out.println("search x (admin) : " + inquiryAdminCount);
				
			} else {
			search = new CustomerServiceSelector(m.getM_email(), "", new BigDecimal(start), new BigDecimal(end));
			inquiryCount = getAllInquiry(req); // 전체 게시글 수 
			System.out.println("search x (user) : " + inquiryCount);
			}
		} else {
			search.setM_email(m.getM_email());
			search.setStart(new BigDecimal(start));
			search.setEnd(new BigDecimal(end));
	//		inquiryCount = ss.getMapper(CustomerServiceMapper.class).getInquiryCount(search);
			inquiryAdminCount = ss.getMapper(CustomerServiceMapper.class).getInquiryAdminCount(search);
			System.out.println("search o (user) : " + inquiryCount);
			System.out.println("search o (admin) : " + inquiryAdminCount);
		}
		
		
		
		List<Inquiry> inquirys = ss.getMapper(CustomerServiceMapper.class).getInquiry(search);
		List<Inquiry> inquiryAdmins = ss.getMapper(CustomerServiceMapper.class).getInquiryAdmin(search);
		
		if(dbMember.getM_email().equals("admin")) {
			int pageCount = (int) Math.ceil(inquiryAdminCount / (double) count);
			req.setAttribute("pageCount", pageCount);
			System.out.println(inquiryAdminCount); // 0
			req.setAttribute("inquiryAdminCount", inquiryAdminCount);
			System.out.println(count); // 5
			System.out.println(pageCount); // 0
			req.setAttribute("inquiryAdmins", inquiryAdmins);
			req.setAttribute("curPage", pageNo);

		} else {
			int pageCount = (int) Math.ceil(inquiryCount / (double) count);
			req.setAttribute("pageCount", pageCount);
			System.out.println(inquiryCount); // 0
			req.setAttribute("inquiryCount", inquiryCount);
			System.out.println(count); // 5
			System.out.println(pageCount); // 0
			req.setAttribute("inquirys", inquirys);
			req.setAttribute("curPage", pageNo);
			
		}

	}
	// 고객센터(1:1문의) 검색 => admin한정
	public void searchInquiry(CustomerServiceSelector sSel, HttpServletRequest req, Member m, Inquiry i,
			InquiryAnswer ia, HttpServletResponse response) {
		req.getSession().setAttribute("searchCustomerService", sSel);
	}
	
	// Pumping Iron에 바란다 글쓰기
	public void writeRequest(Member m, HttpServletRequest req, HttpServletResponse response, Request r) {
		
		String path = req.getSession().getServletContext().getRealPath("resources/files");
		MultipartRequest mr = null;
		try {
			mr = new MultipartRequest(req, path, 10 * 1024 * 1024, "utf-8", new DefaultFileRenamePolicy());
		} catch (Exception e) {
			e.printStackTrace();
			
		}

		try {
			Member loginMember = (Member) req.getSession().getAttribute("loginMember");
			String r_title = mr.getParameter("r_title");
			String r_content = mr.getParameter("r_content");
			String r_to = mr.getParameter("r_to");
			String r_photo1 = mr.getFilesystemName("r_photo1");
			System.out.println(r_photo1);
			String r_photo2 = mr.getFilesystemName("r_photo2");
			System.out.println(r_photo2);
			String r_photo3 = mr.getFilesystemName("r_photo3");
			System.out.println(r_photo3);
			String r_photo4 = mr.getFilesystemName("r_photo4");
			System.out.println(r_photo4);
			
                
          
			
			
			
			if(r_photo1 == null && r_photo2 == null && r_photo3 == null && r_photo4 == null) {
				r_photo1 = " ";
				r_photo2 = " ";
				r_photo3 = " ";
				r_photo4 = " ";
				String r_photo = r_photo1 + r_photo2 + r_photo3 + r_photo4;
				System.out.println("r_photo null일 때 : " + r_photo);
				r_photo = URLEncoder.encode(r_photo, "utf-8");
				r_photo = r_photo.replace("+", " ");
				r.setR_photo(r_photo);
			} else {				
				if(r_photo1 != null) {
					r_photo1 = URLEncoder.encode(r_photo1, "utf-8");				
				} if (r_photo2 != null){
					r_photo2 = URLEncoder.encode(r_photo2, "utf-8");
				} if (r_photo3 != null) {
					r_photo3 = URLEncoder.encode(r_photo3, "utf-8");
				} if (r_photo4 != null) {
					r_photo4 = URLEncoder.encode(r_photo4, "utf-8");
				}
				
				String r_photo = r_photo1 + "!" + r_photo2 + "!" + r_photo3 + "!" + r_photo4; // !는 구분자
				System.out.println("r_photo null이 아닐 때 : " + r_photo);
				r_photo = URLEncoder.encode(r_photo, "utf-8");
				System.out.println("r_photo null이 아닐 때 : " + r_photo);
				r_photo = r_photo.replace("+", " ");
				System.out.println("r_photo null이 아닐 때 : " + r_photo);
				r.setR_photo(r_photo);
			}
			
			System.out.println(r_title);
			System.out.println(r_content);
			System.out.println(r_to);
			System.out.println(loginMember.getM_email());
			
			r.setR_title(r_title);
			r.setR_content(r_content);
			r.setR_to(r_to);
			r.setR_from(loginMember.getM_email());
			
			
			

			if (ss.getMapper(CustomerServiceMapper.class).writeRequest(r) == 1) {
				System.out.println("1:1문의  작성 성공");
			} else {
				System.out.println("1:1문의 작성 실패");
			}
		
		} catch (Exception e) {
			e.printStackTrace();
			String fileName1 = mr.getFilesystemName("r_photo1");
			String fileName2 = mr.getFilesystemName("r_photo2");
			String fileName3 = mr.getFilesystemName("r_photo3");
			String fileName4 = mr.getFilesystemName("r_photo4");
			new File(path + "/" + fileName1).delete();
			new File(path + "/" + fileName2).delete();
			new File(path + "/" + fileName3).delete();
			new File(path + "/" + fileName4).delete();
			System.out.println("DB서버 오류..");
		}
	}
	
	public int getAllRequest(HttpServletRequest req) {
		try {
			Member m = (Member) req.getSession().getAttribute("loginMember");
			// 사용자
		//	req.setAttribute("inquiryAdmins", ss.getMapper(CustomerServiceMapper.class).getAllInquiryAdmin(m));
			List<Request> requests  = ss.getMapper(CustomerServiceMapper.class).getAllRequest(m);
			
			// admin
			if(m.getM_email().equals("admin")) {
				System.out.println("admin");
				List<Request> requestAdmins =  ss.getMapper(CustomerServiceMapper.class).getAllRequestAdmin(m);
				allRequestAdminsCount = requestAdmins.size();
				System.out.println("allRequestAdminsCount : " + allRequestAdminsCount);
				return requestAdmins.size();
			} else {
			allRequestCount = requests.size();
			System.out.println("allRequestCount : " + allRequestCount);
			 return requests.size();
			
		}	
		} catch (Exception e) {
			e.printStackTrace();
		}
		return allRequestCount;
		
	}
	// Pumping Iron에 바란다 페이징
	public void getRequest(int pageNo, HttpServletRequest req, Member m, Request r) {
		int count = so.getSnsCountPerpage(); // 한페이지당 몇개씩 보여줄거냐
		int start = (pageNo - 1) * count + 1;
		int end = start + (count - 1);
		
		Member dbMember = (Member) req.getSession().getAttribute("loginMember");
		m.setM_email(dbMember.getM_email());
		System.out.println(m.getM_email());
		
		CustomerServiceSelector search = (CustomerServiceSelector) req.getSession().getAttribute("searchRequest");
		int requestCount = 0;
		int requestAdminCount = 0;

		if (search == null) {
			if(dbMember.getM_email().equals("admin")) {
			search = new CustomerServiceSelector(m.getM_email(), "", new BigDecimal(start), new BigDecimal(end));
			requestAdminCount = getAllRequest(req); // 전체 게시글 수 
			System.out.println("search x (admin) : " + requestAdminCount);
				
			} else {
			search = new CustomerServiceSelector(m.getM_email(), "", new BigDecimal(start), new BigDecimal(end));
			requestCount = getAllRequest(req); // 전체 게시글 수 
			System.out.println("search x (user) : " + requestCount);
			}
		} else {
			search.setM_email(m.getM_email());
			search.setStart(new BigDecimal(start));
			search.setEnd(new BigDecimal(end));
	//		inquiryCount = ss.getMapper(CustomerServiceMapper.class).getInquiryCount(search);
			requestAdminCount = ss.getMapper(CustomerServiceMapper.class).getRequestAdminCount(search);
			System.out.println("search o (user) : " + requestCount);
			System.out.println("search o (admin) : " + requestAdminCount);
		}
		
		
		
		List<Request> requests = ss.getMapper(CustomerServiceMapper.class).getRequest(search);
		List<Inquiry> requestAdmins = ss.getMapper(CustomerServiceMapper.class).getRequestAdmin(search);
		
		if(dbMember.getM_email().equals("admin")) {
			int pageCount = (int) Math.ceil(requestAdminCount / (double) count);
			req.setAttribute("pageCount", pageCount);
			System.out.println(requestAdminCount); // 0
			req.setAttribute("requestAdminCount", requestAdminCount);
			System.out.println(count); // 5
			System.out.println(pageCount); // 0
			req.setAttribute("requestAdmins", requestAdmins);
			req.setAttribute("curPage", pageNo);

		} else {
			int pageCount = (int) Math.ceil(requestCount / (double) count);
			req.setAttribute("pageCount", pageCount);
			System.out.println(requestCount); // 0
			req.setAttribute("requestCount", requestCount);
			System.out.println(count); // 5
			System.out.println(pageCount); // 0
			req.setAttribute("requests", requests);
			req.setAttribute("curPage", pageNo);
			
		}

	}
	// Pumping Iron에 바란다 상세정보
	public void detailRequest(Request r, HttpServletRequest req) {
		System.out.println("해당 글 번호 : " + r.getR_no());
		req.setAttribute("rdetail", ss.getMapper(CustomerServiceMapper.class).detailRequest(r));
		
	}
	// Pumping Iron에 바란다 사진 나누기
	public void splitRequestImg(HttpServletRequest req, Request r) {
		Request rr = ss.getMapper(CustomerServiceMapper.class).detailRequest(r);
		if(rr.getR_photo() != null) {
			
			String r_photo = rr.getR_photo();
			System.out.println("split하기 전 이미지 : " + r_photo);
			if(r_photo != "    ") {
				String[] r_photo2 = r_photo.split("%21");
				System.out.println("split한 후 이미지 : " + r_photo2);
				req.setAttribute("r_photo", r_photo2);
			}
			
		}
	}
	// Pumping Iron에 바란다  검색 => admin한정
	public void searchRequest(HttpServletRequest req, Member m, Request r, HttpServletResponse response,
			CustomerServiceSelector sSel) {
		req.getSession().setAttribute("searchRequest", sSel);
	}
	
	// Pumping Iron에 바란다  답변 작성
	public void writeRequestAnswer(Member m, Request r, RequestAnswer ra, HttpServletRequest req,
			HttpServletResponse response) {
		String path = req.getSession().getServletContext().getRealPath("resources/files");
		MultipartRequest mr = null;
		try {
			mr = new MultipartRequest(req, path, 10 * 1024 * 1024, "utf-8", new DefaultFileRenamePolicy());
		} catch (Exception e) {
			e.printStackTrace();
			
		}

		try {
			int ra_no = Integer.parseInt(mr.getParameter("r_no"));
			String ra_title = mr.getParameter("ra_title");
			String ra_content = mr.getParameter("ra_content");
			String ra_to = mr.getParameter("ra_to");	
			String ra_from = mr.getParameter("ra_from"); 
			String ra_photo1 = mr.getFilesystemName("ra_photo1");
			System.out.println(ra_photo1);
			String ra_photo2 = mr.getFilesystemName("ra_photo2");
			System.out.println(ra_photo2);
			String ra_photo3 = mr.getFilesystemName("ra_photo3");
			System.out.println(ra_photo3);
			String ra_photo4 = mr.getFilesystemName("ra_photo4");
			System.out.println(ra_photo4);
			
			System.out.println(ra_no);
			System.out.println(ra_title);
			System.out.println(ra_content);
			System.out.println(ra_to);
			System.out.println(ra_from);
			
			ra.setRa_no(ra_no);
			ra.setRa_no(ra_no);
			ra.setRa_title(ra_title);
			ra.setRa_content(ra_content);
			ra.setRa_to(ra_to);
			ra.setRa_from(ra_from);
			
			
			if(ra_photo1 == null && ra_photo2 == null && ra_photo3 == null && ra_photo4 == null) {
				ra_photo1 = " ";
				ra_photo2 = " ";
				ra_photo3 = " ";
				ra_photo4 = " ";
				String ra_photo = ra_photo1 + ra_photo2 + ra_photo3 + ra_photo4;
				System.out.println("ra_photo null일 때 : " + ra_photo);
				ra_photo = URLEncoder.encode(ra_photo, "utf-8");
				ra_photo = ra_photo.replace("+", " ");
				ra.setRa_photo(ra_photo);
			} else {				
				if(ra_photo1 != null) {
					ra_photo1 = URLEncoder.encode(ra_photo1, "utf-8");				
				} if (ra_photo2 != null){
					ra_photo2 = URLEncoder.encode(ra_photo2, "utf-8");
				} if (ra_photo3 != null) {
					ra_photo3 = URLEncoder.encode(ra_photo3, "utf-8");
				} if (ra_photo4 != null) {
					ra_photo4 = URLEncoder.encode(ra_photo4, "utf-8");
				}
				
				String ra_photo = ra_photo1 + "!" + ra_photo2 + "!" + ra_photo3 + "!" + ra_photo4; // !는 구분자
				System.out.println("ra_photo null이 아닐 때 : " + ra_photo);
				ra_photo = URLEncoder.encode(ra_photo, "utf-8");
				System.out.println("ra_photo null이 아닐 때 : " + ra_photo);
				ra_photo = ra_photo.replace("+", " ");
				System.out.println("ra_photo null이 아닐 때 : " + ra_photo);
				ra.setRa_photo(ra_photo);
			}
			
			
			
			
			
			

			if (ss.getMapper(CustomerServiceMapper.class).writeRequestAnswer(ra) == 1) {
				System.out.println("1:1문의답변 작성 성공");
				if(ss.getMapper(CustomerServiceMapper.class).updateChkRequestAnswer(ra) == 1) {
					System.out.println("답변대기에서 답변완료로 변경");
				}
			} else {
				System.out.println("1:1문의답변 작성 실패");
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
			String fileName1 = mr.getFilesystemName("ra_photo1");
			String fileName2 = mr.getFilesystemName("ra_photo2");
			String fileName3 = mr.getFilesystemName("ra_photo3");
			String fileName4 = mr.getFilesystemName("ra_photo4");
			new File(path + "/" + fileName1).delete();
			new File(path + "/" + fileName2).delete();
			new File(path + "/" + fileName3).delete();
			new File(path + "/" + fileName4).delete();
			System.out.println("DB서버 오류..");
		}
		
	}
	// Pumping Iron에 바란다 답변 가져오기
	public void getAllRequestAnswer(Member m, Request r, RequestAnswer ra, HttpServletRequest req,
			HttpServletResponse response) {
		
		ra.setRa_no(r.getR_no());
		System.out.println(ss.getMapper(CustomerServiceMapper.class).getAllRequestAnswer(ra));
		
		req.setAttribute("ranswers", ss.getMapper(CustomerServiceMapper.class).getAllRequestAnswer(ra));
		
	}

	// Pumping Iron에 바란다 답변 사진 나누기
	public void splitRequestAnswerImg(HttpServletRequest req, Request r, RequestAnswer ra) {
		
		RequestAnswer rr = ss.getMapper(CustomerServiceMapper.class).getAllRequestAnswer(ra);
		if(rr != null) {
		String rr_photo = rr.getRa_photo();
		System.out.println("split하기 전 이미지 : " + rr_photo);
		if(rr_photo != "    ") {
			String[] rr_photo2 = rr_photo.split("%21");
			System.out.println("split한 후 이미지 : " + rr_photo2);
			req.setAttribute("rr_photo", rr_photo2);
		}
		}
	}
	// Pumping Iron에 바란다 답변 삭제하기
	public void deleteRequestAnswer(Member m, HttpServletRequest req, HttpServletResponse response, Request r, RequestAnswer ra) {
		
		try {
			System.out.println("삭제할 번호 : " + ra.getRa_no());
			RequestAnswer dbAnswer = ss.getMapper(CustomerServiceMapper.class).getAllRequestAnswer(ra);
			System.out.println("삭제할 사진 : " + dbAnswer.getRa_photo());
			String db_photo = dbAnswer.getRa_photo();
			if(db_photo != "") {
				// 답변 사진 삭제
				try {
					System.out.println("삭제할 사진 : " + dbAnswer.getRa_photo());
					String[] db_photo3 = db_photo.split("%21");
					String path = req.getSession().getServletContext().getRealPath("resources/files");
					new File(path + "/" + db_photo3[0]).delete();
					new File(path + "/" + db_photo3[1]).delete();
					new File(path + "/" + db_photo3[2]).delete();
					new File(path + "/" + db_photo3[3]).delete();
				} catch (Exception e) {
					// TODO: handle exception
				}
			} else {
				System.out.println("삭제할 사진 없음");
			}
			
			
			if(ss.getMapper(CustomerServiceMapper.class).deleteRequestAnswer(ra) == 1) {
				System.out.println("답변 삭제 성공");
				if(ss.getMapper(CustomerServiceMapper.class).updateChkRequestAnswer2(ra) == 1) {
					System.out.println("답변완료에서 답변대기로 변경");
					response.setContentType("text/html; charset=euc-kr");
					PrintWriter script = response.getWriter();
					script.println("<script>");
					script.println("alert('해당 답변을 삭제하였습니다.');");
					script.println("location.href = 'customerservice.request.go';");
					script.println("</script>");
					script.close();
				}
			} else {
				System.out.println("답변 삭제 실패");
			}
		  
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("DB서버 오류..");
		}
	}
	
}
	


