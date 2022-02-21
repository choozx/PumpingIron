package com.fp.pi.member;

public interface MemberMapper {

	int join(Member m);

	int emailCheck(String m_email);

}
