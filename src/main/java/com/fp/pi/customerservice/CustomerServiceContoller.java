package com.fp.pi.customerservice;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.fp.pi.SiteOption;
import com.fp.pi.TokenMaker;
import com.fp.pi.member.Member;
import com.fp.pi.member.MemberDAO;
import com.fp.pi.tips.Selector;

@Controller
public class CustomerServiceContoller {

	@Autowired
	private CustomerServiceDAO csDAO;
	
	@Autowired
	private MemberDAO mDAO;
	
	// 제휴문의 페이지로 이동
	@RequestMapping(value = "/customerservice.associate.go", method = RequestMethod.GET)
	public String associateGo(Member m, HttpServletRequest req) {
		TokenMaker.make(req);
		if(mDAO.loginCheck(req)) {
			req.setAttribute("contentPage", "customerservice/associate.jsp");
		}
		return "index";
	}
	
	// 제휴문의
	@RequestMapping(value = "/customerservice.associate.do", method = RequestMethod.POST)
	public String associateDo(Member m, HttpServletRequest req, HttpServletResponse response) {
		TokenMaker.make(req);
		if(mDAO.loginCheck(req)) {
			csDAO.associate(m, req, response);
			req.setAttribute("contentPage", "home.jsp");
			
		}
		
		
		return "index";
	}
	// 공지사항&이벤트 전체페이지로 이동
	@RequestMapping(value = "/customerservice.event.go", method = RequestMethod.GET)
	public String eventGo(Member m, HttpServletRequest req) {
		TokenMaker.make(req);
		SiteOption.clearSearch1(req);
	//	csDAO.getEvent(req);
		csDAO.getEvent1(1, req);
		req.setAttribute("contentPage", "customerservice/eventGo.jsp");
		return "index";
	}
	// 공지사항 페이지로 이동
	@RequestMapping(value = "/customerservice.event.go2", method = RequestMethod.GET)
	public String eventGo2(Member m, HttpServletRequest req) {
		TokenMaker.make(req);
		SiteOption.clearSearch1(req);
	//	csDAO.getEvent2(req);
		csDAO.getEvent3(1, req);
		req.setAttribute("contentPage", "customerservice/eventGo2.jsp");
		return "index";
	}
	
	//  이벤트 페이지로 이동
		@RequestMapping(value = "/customerservice.event.go3", method = RequestMethod.GET)
		public String eventGo3(Member m, HttpServletRequest req) {
			TokenMaker.make(req);
			SiteOption.clearSearch1(req);
		//	csDAO.getEvent4(req);
			csDAO.getEvent5(1, req);
			req.setAttribute("contentPage", "customerservice/eventGo3.jsp");
			return "index";
		}
	// 공지사항&이벤트 글 작성 페이지로 이동
	@RequestMapping(value = "/customerservice.event.do", method = RequestMethod.GET)
	public String eventDo(Member m, HttpServletRequest req) {
		TokenMaker.make(req);
		if(mDAO.loginCheck(req)) {
		req.setAttribute("contentPage", "customerservice/eventDo.jsp");
	}	
		return "index";
	}
	
	// 공지사항&이벤트 글 작성
	@RequestMapping(value = "/customerservice.event", method = RequestMethod.POST)
	public String event(Event e,Member m, HttpServletRequest req) {
		TokenMaker.make(req);
		if(mDAO.loginCheck(req)) {
		csDAO.writeEvent(e, m, req);
		csDAO.getEvent1(1, req);
		req.setAttribute("contentPage", "customerservice/eventGo.jsp");
	}	
		return "index";
	}
	
	// 공지사항&이벤트 글 삭제
	@RequestMapping(value = "/customerservice.event.delete", method = RequestMethod.GET)
	public String eventDelete(Event e,Member m, HttpServletRequest req, HttpServletResponse response) {
		TokenMaker.make(req);
		if(mDAO.loginCheck(req)) {
		csDAO.deleteEvent(e, m, req, response);
		csDAO.getEvent1(1, req);
		req.setAttribute("contentPage", "customerservice/eventGo.jsp");
	}	
		return "index";
	}
	
	// 공지사항&이벤트 수정 페이지로 이동
	@RequestMapping(value = "/customerservice.event.updateGo", method = RequestMethod.GET)
	public String eventUpdateGo(Event e,Member m, HttpServletRequest req, HttpServletResponse response) {
		TokenMaker.make(req);
		if(mDAO.loginCheck(req)) {
			csDAO.getDetail(req, e);
			req.setAttribute("contentPage", "customerservice/eventUpdateGo.jsp");
		}	
		return "index";
	}
	
	// 공지사항&이벤트 수정
	@RequestMapping(value = "/customerservice.event.updateDo", method = RequestMethod.POST)
	public String eventupdateDo(Event e,Member m, HttpServletRequest req, HttpServletResponse response) {
		TokenMaker.make(req);
		if(mDAO.loginCheck(req)) {
			csDAO.updateEvent(e, req, response);
			csDAO.getEvent1(1, req);
			req.setAttribute("contentPage", "customerservice/eventGo.jsp");
		}	
		return "index";
	}
	
	// 공지사항&이벤트 페이징
	@RequestMapping(value = "/event.page.change", method = RequestMethod.GET)
	public String eventPageChange(HttpServletRequest req) {
		TokenMaker.make(req);
		mDAO.loginCheck(req);
		
		int p = Integer.parseInt(req.getParameter("p"));
		csDAO.getEvent1(p, req);
		req.setAttribute("contentPage", "customerservice/eventGo.jsp");
		return "index";
	}
	// 공지사항 페이징
	@RequestMapping(value = "/event.page.change2", method = RequestMethod.GET)
	public String eventPageChange2(HttpServletRequest req) {
		TokenMaker.make(req);
		mDAO.loginCheck(req);
		
		int p = Integer.parseInt(req.getParameter("p"));
		csDAO.getEvent3(p, req);
		req.setAttribute("contentPage", "customerservice/eventGo2.jsp");
		return "index";
	}
	
	// 이벤트 페이징
	@RequestMapping(value = "/event.page.change3", method = RequestMethod.GET)
	public String eventPageChange3(HttpServletRequest req) {
		TokenMaker.make(req);
		mDAO.loginCheck(req);
		
		int p = Integer.parseInt(req.getParameter("p"));
		csDAO.getEvent5(p, req);
		req.setAttribute("contentPage", "customerservice/eventGo3.jsp");
		return "index";
	}
	
	// 공지사항&이벤트 검색
	@RequestMapping(value = "event.search", method = RequestMethod.GET)
	public String evnetSearch(EventSelector sSel, HttpServletRequest req) {
		TokenMaker.make(req);
		mDAO.loginCheck(req);
		csDAO.searchEvent(sSel, req);
		csDAO.getEvent1(1, req);
		req.setAttribute("contentPage", "customerservice/eventGo.jsp");
		return "index";
	}
	
	// 공지사항 검색
		@RequestMapping(value = "event.search2", method = RequestMethod.GET)
		public String evnetSearch2(EventSelector sSel, HttpServletRequest req) {
			TokenMaker.make(req);
			mDAO.loginCheck(req);
			csDAO.searchEvent(sSel, req);
			csDAO.getEvent3(1, req);
			req.setAttribute("contentPage", "customerservice/eventGo2.jsp");
			return "index";
		}
		
	// 이벤트 검색
		@RequestMapping(value = "event.search3", method = RequestMethod.GET)
		public String evnetSearch3(EventSelector sSel, HttpServletRequest req) {
			TokenMaker.make(req);
			mDAO.loginCheck(req);
			csDAO.searchEvent(sSel, req);
			csDAO.getEvent5(1, req);
			req.setAttribute("contentPage", "customerservice/eventGo3.jsp");
			return "index";
		}
		
	// 고객센터로 이동
		@RequestMapping(value = "/customerservice.go", method = RequestMethod.GET)
		public String customerserviceGo(Member m, HttpServletRequest req, Inquiry i, InquiryAnswer ia,HttpServletResponse response) {
			
			TokenMaker.make(req);
			if(mDAO.loginCheck(req)) {
				SiteOption.clearSearch2(req);
				csDAO.getInquiry(1, req, m, i);
				csDAO.getAllQuestion(req);
				csDAO.getAllAnswer(m,i,ia,req,response);
				req.setAttribute("contentPage", "customerservice/customerservice.jsp");
			}
			return "index";
		}
	
	// 고객센터(자주찾는질문) 글쓰기 페이지로 이동
		@RequestMapping(value = "/customerservice.write.go", method = RequestMethod.GET)
		public String customerserviceWriteGo(Member m, HttpServletRequest req) {
			TokenMaker.make(req);
			if(mDAO.loginCheck(req)) {
				req.setAttribute("contentPage", "customerservice/customerserviceWrite.jsp");
			}
			return "index";
		}
		
	// 고객센터(자주찾는질문) 글쓰기
		@RequestMapping(value = "/customerservice.write.do", method = RequestMethod.POST)
		public String customerserviceWriteDo(Member m, Question q,HttpServletRequest req,Inquiry i, InquiryAnswer ia,HttpServletResponse response) {
			
			TokenMaker.make(req);
			if(mDAO.loginCheck(req)) {
				csDAO.getInquiry(1, req, m, i);
				csDAO.writeQuestion(m, q, req);
				csDAO.getAllQuestion(req);
				csDAO.getAllAnswer(m,i,ia,req,response);
				req.setAttribute("contentPage", "customerservice/customerservice.jsp");
			}
			return "index";
		}
	
		
	// 고객센터(자주찾는질문) 삭제
		@RequestMapping(value = "/customerservice.delete", method = RequestMethod.GET)
		public String customerserviceDelete(Member m,Question q, HttpServletRequest req, HttpServletResponse response,Inquiry i, InquiryAnswer ia) {
			
			TokenMaker.make(req);
			if(mDAO.loginCheck(req)) {
				csDAO.getInquiry(1, req, m, i);
				csDAO.deleteQuestion(q, req, response);
				csDAO.getAllQuestion(req);
				csDAO.getAllAnswer(m,i,ia,req,response);
				req.setAttribute("contentPage", "customerservice/customerservice.jsp");
			}
			return "index";
		}
	// 고객센터(자주찾는질문) 수정 페이지로 이동
		@RequestMapping(value = "/customerservice.update.go", method = RequestMethod.GET)
		public String customerserviceUpdateGo(Member m,Question q, HttpServletRequest req, HttpServletResponse response) {
			TokenMaker.make(req);
			if(mDAO.loginCheck(req)) {
				csDAO.detailQuestion(q, req);
				req.setAttribute("contentPage", "customerservice/customerserviceUpdate.jsp");
			}
			return "index";
		}
		
	// 고객센터(자주찾는질문) 수정 페이지로 이동
		@RequestMapping(value = "/customerservice.update.do", method = RequestMethod.POST)
		public String customerserviceUpdateDo(Member m,Question q, HttpServletRequest req, HttpServletResponse response, Inquiry i, InquiryAnswer ia) {
			
			TokenMaker.make(req);
			if(mDAO.loginCheck(req)) {
				csDAO.getInquiry(1, req, m, i);
				csDAO.updateQuestion(q, req, response);
				csDAO.getAllQuestion(req);
				csDAO.getAllAnswer(m,i,ia,req,response);
				req.setAttribute("contentPage", "customerservice/customerservice.jsp");
			}
			return "index";
		}
	// 고객센터(1:1문의) 글쓰기 페이지로 이동
		@RequestMapping(value = "/customerservice.inquiry.go", method = RequestMethod.GET)
		public String InquiryWriteGo(Member m,Inquiry i, HttpServletRequest req, HttpServletResponse response) {
			TokenMaker.make(req);
			if(mDAO.loginCheck(req)) {
				req.setAttribute("contentPage", "customerservice/inquiryWrite.jsp");
			}
			return "index";
		}
		
	// 고객센터(1:1문의) 글쓰기
		@RequestMapping(value = "/customerservice.inquiry.do", method = RequestMethod.POST)
		public String InquiryWriteDo(Member m,Inquiry i, HttpServletRequest req, HttpServletResponse response, InquiryAnswer ia) {
			
			TokenMaker.make(req);
			if(mDAO.loginCheck(req)) {
				csDAO.writeInquiry(m, i, req, response);
				csDAO.getInquiry(1, req, m, i);
				csDAO.getAllQuestion(req);
				csDAO.getAllAnswer(m,i,ia,req,response);
				req.setAttribute("contentPage", "customerservice/customerservice.jsp");
			}
			return "index";
		}
		
		// 고객센터(1:1문의) 상세정보
		@RequestMapping(value = "/customerservice.inquiry.detail", method = RequestMethod.GET)
		public String InquiryDetail(Member m,Inquiry i, HttpServletRequest req, HttpServletResponse response, InquiryAnswer ia) {
			TokenMaker.make(req);
			if(mDAO.loginCheck(req)) {
				csDAO.getAllAnswer(m,i,ia,req,response);
				csDAO.detailInquiry(i, req);
				csDAO.splitInquiryImg(req, i);
				csDAO.splitAnswerImg(req, i, ia);
				req.setAttribute("contentPage", "customerservice/inquiryDetail.jsp");
			}
			return "index";
		}
		
		// 고객센터(1:1문의) 답변하기 페이지로 이동하기
		@RequestMapping(value = "/customerservice.inquiry.answerGo", method = RequestMethod.GET)
		public String InquiryAnswerGo(Member m,Inquiry i, HttpServletRequest req, HttpServletResponse response) {
			TokenMaker.make(req);
			if(mDAO.loginCheck(req)) {
				csDAO.detailInquiry(i, req);
				req.setAttribute("contentPage", "customerservice/inquiryAnswerGo.jsp");
			}
			return "index";
		}
		
		// 고객센터(1:1문의) 답변하기 글 작성
		@RequestMapping(value = "/customerservice.inquiry.answerDo", method = RequestMethod.POST)
		public String InquiryAnswerDo(Member m,Inquiry i, InquiryAnswer ia ,HttpServletRequest req, HttpServletResponse response) {
			
			TokenMaker.make(req);
			if(mDAO.loginCheck(req)) {
				csDAO.writeAnswer(m, i, ia, req, response);
				csDAO.getInquiry(1, req, m, i);
				csDAO.getAllQuestion(req);
				csDAO.getAllAnswer(m,i,ia,req,response);
				req.setAttribute("contentPage", "customerservice/customerservice.jsp");
			}
			return "index";
		}
		//  고객센터(1:1문의) 답변하기 글 삭제
		@RequestMapping(value = "/customerservice.inquiry.answerDelete", method = RequestMethod.GET)
		public String InquiryAnswerDelete(Member m,Inquiry i, InquiryAnswer ia ,HttpServletRequest req, HttpServletResponse response) {
			
			TokenMaker.make(req);
			if(mDAO.loginCheck(req)) {
				csDAO.deleteAnswer(m, i, ia, req, response);
				csDAO.getInquiry(1, req, m, i);
				csDAO.getAllQuestion(req);
				csDAO.getAllAnswer(m,i,ia,req,response);
				req.setAttribute("contentPage", "customerservice/customerservice.jsp");
			}
			return "index";
		}
	
		//  고객센터(1:1문의)페이징
		@RequestMapping(value = "/customerservice.inquiry.page", method = RequestMethod.GET)
		public String inquiryPageChange(HttpServletRequest req, Member m,Inquiry i,InquiryAnswer ia, HttpServletResponse response) {
			TokenMaker.make(req);
			mDAO.loginCheck(req);
			
			int p = Integer.parseInt(req.getParameter("p"));
			csDAO.getInquiry(p, req, m, i);
			csDAO.getAllQuestion(req);
			csDAO.getAllAnswer(m,i,ia,req,response);
			req.setAttribute("contentPage", "customerservice/customerservice.jsp");
			return "index";
		}	
	//  고객센터(1:1문의) 검색 => admin한정
		@RequestMapping(value = "/customerservice.inquiry.search", method = RequestMethod.GET)
		public String inquirySearch(HttpServletRequest req, Member m,Inquiry i,InquiryAnswer ia, HttpServletResponse response, CustomerServiceSelector sSel) {
			TokenMaker.make(req);
			mDAO.loginCheck(req);
			
			csDAO.searchInquiry(sSel, req, m, i, ia, response);
			csDAO.getInquiry(1, req, m, i);
			csDAO.getAllQuestion(req);
			csDAO.getAllAnswer(m,i,ia,req,response);
			req.setAttribute("contentPage", "customerservice/customerservice.jsp");
			return "index";
		}	
		
	// Pumping Iron에 바란다 페이지로 이동
		@RequestMapping(value = "/customerservice.request.go", method = RequestMethod.GET)
		public String requestGo(Member m, HttpServletRequest req, HttpServletResponse response, Request r, RequestAnswer ra) {
			TokenMaker.make(req);
			if(mDAO.loginCheck(req)) {
				SiteOption.clearSearch3(req);
				csDAO.getRequest(1, req, m, r);
				csDAO.getAllRequestAnswer(m, r, ra, req, response);
				req.setAttribute("contentPage", "customerservice/request.jsp");
			}
			return "index";
		}
	// Pumping Iron에 바란다 글쓰기 페이지로 이동	
		@RequestMapping(value = "/customerservice.request.writeGo", method = RequestMethod.GET)
		public String requestWriteGo(Member m, HttpServletRequest req, HttpServletResponse response) {
			TokenMaker.make(req);
			if(mDAO.loginCheck(req)) {
				req.setAttribute("contentPage", "customerservice/requestWrite.jsp");
			}
			return "index";
		}
	// Pumping Iron에 바란다 글쓰기
		@RequestMapping(value = "/customerservice.request.writeDo", method = RequestMethod.POST)
		public String requestWriteDo(Member m, HttpServletRequest req, HttpServletResponse response, Request r, RequestAnswer ra) {
			TokenMaker.make(req);
			if(mDAO.loginCheck(req)) {
				csDAO.writeRequest(m, req, response, r);
				csDAO.getRequest(1, req, m, r);
				csDAO.getAllRequestAnswer(m, r, ra, req, response);
				req.setAttribute("contentPage", "customerservice/request.jsp");
			}
			return "index";
		}
		// Pumping Iron에 바란다 상세정보
		@RequestMapping(value = "/customerservice.request.detail", method = RequestMethod.GET)
		public String RequestDetail(Member m, Request r, RequestAnswer ra,HttpServletRequest req, HttpServletResponse response) {
			TokenMaker.make(req);
			if(mDAO.loginCheck(req)) {
				csDAO.getAllRequestAnswer(m, r, ra, req, response);
				csDAO.detailRequest(r, req);
				csDAO.splitRequestImg(req, r);
				csDAO.splitRequestAnswerImg(req, r, ra);
				req.setAttribute("contentPage", "customerservice/requestDetail.jsp");
			}
			return "index";
		}
		
		// Pumping Iron에 바란다 답변하기 페이지로
		@RequestMapping(value = "/customerservice.request.answerGo", method = RequestMethod.GET)
		public String RequestAnswerGo(Member m, Request r, HttpServletRequest req, HttpServletResponse response) {
			TokenMaker.make(req);
			if(mDAO.loginCheck(req)) {
				csDAO.detailRequest(r, req);
				req.setAttribute("contentPage", "customerservice/requestAnswerGo.jsp");
			}
			return "index";
		}
		
		// Pumping Iron에 바란다 답변하기 
		@RequestMapping(value = "/customerservice.request.answerDo", method = RequestMethod.POST)
		public String RequestAnswerDo(Member m, Request r, RequestAnswer ra, HttpServletRequest req, HttpServletResponse response) {
			TokenMaker.make(req);
			if(mDAO.loginCheck(req)) {
				csDAO.writeRequestAnswer(m, r, ra, req, response);
				csDAO.getRequest(1, req, m, r);
				csDAO.getAllRequestAnswer(m, r, ra, req, response);
				req.setAttribute("contentPage", "customerservice/request.jsp");
			}
			return "index";
		}
		
		// Pumping Iron에 바란다 답변 삭제하기
		@RequestMapping(value = "/customerservice.request.answerDelete", method = RequestMethod.GET)
		public String requestAnswerDelete(Member m, HttpServletRequest req, HttpServletResponse response, Request r, RequestAnswer ra) {
			TokenMaker.make(req);
			if(mDAO.loginCheck(req)) {
				csDAO.deleteRequestAnswer(m, req, response, r, ra);
				csDAO.getRequest(1, req, m, r);
				csDAO.getAllRequestAnswer(m, r, ra, req, response);
				req.setAttribute("contentPage", "customerservice/request.jsp");
			}
			return "index";
		}	
		// Pumping Iron에 바란다 페이징
		@RequestMapping(value = "/customerservice.request.page", method = RequestMethod.GET)
		public String requestPageChange(Member m, HttpServletRequest req, HttpServletResponse response, Request r, RequestAnswer ra) {
			TokenMaker.make(req);
			if(mDAO.loginCheck(req)) {
				int p = Integer.parseInt(req.getParameter("p"));
				csDAO.getRequest(p, req, m, r);
				csDAO.getAllRequestAnswer(m, r, ra, req, response);
				req.setAttribute("contentPage", "customerservice/request.jsp");
			}
			return "index";
		}
		//  Pumping Iron에 바란다  검색 => admin한정
		@RequestMapping(value = "/customerservice.request.search", method = RequestMethod.GET)
		public String requestSearch(HttpServletRequest req, Member m, Request r, RequestAnswer ra, HttpServletResponse response, CustomerServiceSelector sSel) {
			TokenMaker.make(req);
			mDAO.loginCheck(req);
				
			csDAO.searchRequest(req, m, r, response, sSel);
			csDAO.getRequest(1, req, m, r);
			csDAO.getAllRequestAnswer(m, r, ra, req, response);
			req.setAttribute("contentPage", "customerservice/request.jsp");
			return "index";
		}			
}
