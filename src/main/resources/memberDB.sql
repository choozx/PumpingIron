create table member(
m_email varchar2(50 char), -- 회원 이메일
m_pw varchar2(30 char) not null, -- 비밀번호
m_phone varchar2(11 char), -- 폰 번호
m_addr varchar2(100 char) not null, -- 회원 주소
m_name varchar2(20 char), -- 회원 이름
m_photo varchar2(200 char) not null, -- 회원 프로필 사진
m_pay number(20) not null, -- 회원 결제 금액
m_point number(20) not null, -- 회원 포인트
m_regdate date not null, -- 회원 가입 날짜
m_key varchar2(100 char) not null, -- 회원 이메일 인증 여부
CONSTRAINT member_pk PRIMARY KEY (m_email, m_name, m_phone) -- 이메일, 이름, 폰 번호 pk : 1명의 1계정으로
);

insert into member values
('1234@gmail.com', '1234', 01067019501, '몰라', '김두', 'test.jpg', 0, 0, sysdate, 'Y');

delete MEMBER where m_email = '1234@gmail.com';

select * from member;

delete member where m_email = '@naver.com'

drop table member cascade constraint purge;