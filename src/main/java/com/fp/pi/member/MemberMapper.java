package com.fp.pi.member;

import org.apache.ibatis.annotations.Param;

public interface MemberMapper {

	int join(Member m);

	int emailCheck(String m_email);

	Member getMemberByID(Member m);

	int GetKey(String m_email, String m_key);
	
	int alter_userKey(String m_email, String key);

	Member loginUser(String user_id);

	int withdrawal(Member m2);


	// ID 찾기
	String searchId(@Param("m_name")String m_name, @Param("m_phone")String m_phone);
	

	// 비밀번호 찾기
	int searchPassword(String m_email, String m_phone, String key);

	

//	Member memberInfo(String m_email);

	// 정보 얻기

	Member memberInfo(String m_email);

	Member infoPwChek(Member m);

	 
}
