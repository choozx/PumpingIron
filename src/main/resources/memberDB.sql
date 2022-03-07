create table member(
m_email varchar2(50 char) primary key, -- 회원 이메일
m_pw varchar2(30 char) not null, -- 비밀번호
m_phone varchar2(11 char), -- 폰 번호
m_addr varchar2(100 char) not null, -- 회원 주소
m_name varchar2(20 char), -- 회원 이름
m_photo varchar2(200 char) not null, -- 회원 프로필 사진
m_pay number(20) not null, -- 회원 결제 금액
m_point number(20) not null, -- 회원 포인트
m_regdate date not null, -- 회원 가입 날짜
m_key varchar2(100 char) not null, -- 회원 이메일 인증 여부
m_type varchar2(20 char) not null -- 일반회원인지 카카오톡 회원인지 구분
);

insert into member values
<<<<<<< HEAD
('1234@gmail.com', '1234', '01067019501', '몰라', '김두', 'test.jpg', 0, 500, sysdate, 'Y', 'normal');

select * from member;

drop table member cascade constraint purge;

delete member where m_email = '@naver.com'

=======
('1234@gmail.com', '1234', 01067019501, '몰라', '김두', 'test.jpg', 0, 0, sysdate, '0');

select * from member;

delete member where m_email = '@naver.com'

drop table member cascade constraint purge;
>>>>>>> e4f458a338bf593ec468558ca5ffd26e704ab97f
