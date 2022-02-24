package com.fp.pi.member;

public interface MemberMapper {

	int join(Member m);

	int emailCheck(String m_email);

	Member getMemberByID(Member m);

	int GetKey(String m_email, String m_key);
	
	int alter_userKey(String m_email, String key);

	Member loginUser(String user_id);
}
