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
	int getEventCount(Selector sSel);
	List<Event> getEvent(Selector search);

	// 공지사항 게시글 가져오기, 페이징, 검색
	List<Event> getevent2();
	int getEventCount2(Selector search);
	List<Event> getEvent4(Selector search);

	
	// 이벤트 게시글 가져오기, 페이징, 검색
	List<Event> getevent6();
	int getEventCount3(Selector search);
	List<Event> getEvent5(Selector search);

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

	// 고객센터(1:1문의) admin글 가져오기
	List<Inquiry> getAllInquiryAdmin(Member m);

	// 고객센터(1:1문의) 글 상세정보
	Inquiry detailInquiry(Inquiry i);

}