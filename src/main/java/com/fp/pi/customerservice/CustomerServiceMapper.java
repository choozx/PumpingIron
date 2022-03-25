package com.fp.pi.customerservice;

import java.util.List;

import com.fp.pi.member.Member;
import com.fp.pi.tips.Selector;

public interface CustomerServiceMapper {

	// 공지사항 & 이벤트 글 작성
	int writeEvent(Event e);

	// 공지사항 & 이벤트 글 삭제하기
	int deleteEvent(Event e);

	// 공지사항 & 이벤트 상세정보
	Event getDetail(Event e);

	// 공지사항 & 이벤트 글 수정
	int updateEvent(Event e);
	
	// 공지사항 & 이벤트 글 가져오기, 페이징, 검색
	List<Event> getevent();
	int getEventCount(EventSelector sSel);
	List<Event> getEvent(EventSelector search);

	// 공지사항 게시글 가져오기, 페이징, 검색
	List<Event> getevent2();
	int getEventCount2(EventSelector search);
	List<Event> getEvent4(EventSelector search);

	
	// 이벤트 게시글 가져오기, 페이징, 검색
	List<Event> getevent6();
	int getEventCount3(EventSelector search);
	List<Event> getEvent5(EventSelector search);

	// 고객센터(자주찾는질문) 글 작성
	int writeQuestion(Question q);
	
	// 고객센터(자주찾는질문) 글 가져오기
	List<Question> getAllQuestion();
	
	// 고객센터(자주찾는질문) 글 삭제하기
	int deleteQuestion(Question q);

	// 고객센터(자주찾는질문) 글 상세정보
	Question detailQuestion(Question q);

	// 고객센터(자주찾는질문) 글 수정하기
	int updateQuestion(Question q);

	// 고객센터(1:1문의) 글 작성하기
	int writeInquiry(Inquiry i);

	// 고객센터(1:1문의) 글 가져오기
	List<Inquiry> getAllInquiry(Member m);
//	int getInquiryCount(CustomerServiceSelector sSel);
	List<Inquiry> getInquiry(CustomerServiceSelector search);
	// 고객센터(1:1문의) admin글 가져오기
	List<Inquiry> getAllInquiryAdmin(Member m);
	int getInquiryAdminCount(CustomerServiceSelector sSel);
	List<Inquiry> getInquiryAdmin(CustomerServiceSelector search);

	// 고객센터(1:1문의) 글 상세정보
	Inquiry detailInquiry(Inquiry i);

	// 고객센터(1:1문의 답변) 글 작성하기
	int writeAnswer(InquiryAnswer ia);
	
	// 고객센터(1:1 문의) 글 답변대기에서 답변완료로 변경
	int updateChkAnswer(InquiryAnswer ia);
	
	// 고객센터(1:1 문의 답변) 글 가져오기  
	InquiryAnswer getAllAnswer(InquiryAnswer ia);
	
	// 고객센터(1:1 문의 답변) 글  삭제하기
	int deleteAnswer(InquiryAnswer ia);
	
	// 고객센터(1:1문의 답변) 삭제로 인한 답변완료에서 답변대기로 변경 
	int updateChkAnswer2(InquiryAnswer ia);

	// Pumping Iron에 바란다 글 작성하기
	int writeRequest(Request r);
	
	// Pumping Iron에 바란다 글 가져오기
	List<Request> getAllRequest(Member m);
	List<Request> getRequest(CustomerServiceSelector search);
	// Pumping Iron에 바란다 admin글 가져오기
	List<Request> getAllRequestAdmin(Member m);
	int getRequestAdminCount(CustomerServiceSelector sSel);
	List<Inquiry> getRequestAdmin(CustomerServiceSelector search);
	
	// Pumping Iron에 바란다 상세정보
	Request detailRequest(Request r);
	
	// Pumping Iron에 바란다 답변하기
	int writeRequestAnswer(RequestAnswer ra);

	// Pumping Iron에 바란다  답변대기에서 답변완료로 변경
	int updateChkRequestAnswer(RequestAnswer ra);

	// Pumping Iron에 바란다  답변 가져오기
	RequestAnswer getAllRequestAnswer(RequestAnswer ra);
	
	// Pumping Iron에 바란다  답변 삭제하기
	int deleteRequestAnswer(RequestAnswer ra);
	
	// Pumping Iron에 바란다  답변삭제로 인한 답변완료에서 답변대기로 변경 
	int updateChkRequestAnswer2(RequestAnswer ra);










}