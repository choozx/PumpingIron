package com.fp.pi.customerservice;

import java.util.List;

public interface CustomerServiceMapper {

	// 공지사항 & 이벤트 글 작성
	int writeEvent(Event e);

	// 공지사항 & 이벤트 글 가져오기
	List<Event> getEvent();

	// 공지사항 & 이벤트 글 삭제하기
	int deleteEvent(Event e);

	// 공지사항 & 이벤트 상세정보
	Event getDetail(Event e);

	// 공지사항 & 이벤트 글 수정
	int updateEvent(Event e);

}
