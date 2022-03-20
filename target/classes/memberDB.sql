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

insert into member values ('admin@pumping.com', 'admin5959^^', 00000000000, '몰라', '김두', 'test.jpg', 0, 0, sysdate, 'Y', 'normal');

insert into member values
('1234@gmail.com', '1234', '01067019501', '몰라', '김두', 'test.jpg', 0, 500, sysdate, 'Y', 'normal');

insert into member values
('admin', '1234', '01067019501', '몰라', 'admin', 'test,jpg', 0, 300000, sysdate, 'Y', 'normal');

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

---------------------------------------------
--- 고객센터(자주찾는 질문) 테이블 ---
create table question(
q_no number(5) primary key,
q_title varchar2(100 char) not null,
q_content varchar2(1000 char) not null,
q_date date not null,
q_type varchar2(50 char) not null
);

create sequence question_seq;

select * from question;

drop table question cascade constraint purge;

DROP SEQUENCE question_seq;

---------------------------------------------
--- 고객센터(1:1문의) 테이블 ---
create table inquiry(
i_no number(5) primary key,
i_title varchar2(100 char) not null,
i_content varchar2(1000 char) not null,
i_date date not null,
i_type varchar2(50 char) not null,
i_to varchar2(30 char) not null,
i_from varchar2(30 char) not null,
i_answercheck varchar2(10 char) not null,
i_photo varchar2(200 char) not null
);

create sequence inquiry_seq;

insert into inquiry values
(inquiry_seq.nextval, '몰라', 'ㅋㅋㅋ', sysdate, '결제', 'admin',
'iii9501@naver.com', '1' , 'test.jpg')

select * from inquiry;

drop table inquiry cascade constraint purge;

DROP SEQUENCE inquiry_seq;