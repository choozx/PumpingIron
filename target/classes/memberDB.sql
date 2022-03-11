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
('1234@gmail.com', '1234', 01067019501, '몰라', '김두', 'test.jpg', 0, 0, sysdate, 'Y');

delete MEMBER where m_email = '1234@gmail.com';
=======
('1234@gmail.com', '1234', '01067019501', '몰라', '김두', 'test.jpg', 0, 500, sysdate, 'Y', 'normal');
<<<<<<< HEAD
>>>>>>> 3ddeb2b901b64d2811855a23204c99e4fcc3de9e
=======
insert into member values
('admin', '1234', '01067019501', '몰라', 'admin', 'test,jpg', 0, 300000, sysdate, 'Y', 'normal');
>>>>>>> 04b2b844ad29341a9c748ebe79f245cdf3f8e188

select * from member;

drop table member cascade constraint purge;

delete member where m_email = 'admin'

---------------------------------------------
--- 공지사항&이벤트 테이블 ---
create table event(
e_no number(5) primary key,
e_title varchar2(100 char) not null,
e_content varchar2(4000 char) not null,
e_date date not null,
e_type varchar2(50 char) not null
);

create sequence event_seq;

insert into event values(event_seq.nextval, '공지1', '공지사항1입니다.', sysdate, 'announcement');
insert into event values(event_seq.nextval, '이벤트1', '이벤트1입니다.', sysdate, 'event');

select * from event;

drop table event cascade constraint purge;

DROP SEQUENCE event_seq;