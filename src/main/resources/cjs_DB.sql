create table price_info(
pi_no number(7) primary key,
pi_name varchar2(50 char) not null,
pi_loc varchar2(50 char) not null,
pi_price varchar2(500 char) not null,
pi_partner varchar2(50 char) not null,
pi_img varchar2(1000 char) not null
);

create sequence price_info_seq;

update price_info 
set pi_name = 'ㅁㅁ', pi_loc = '1234', pi_price = '5678', pi_partner = 'N', pi_img = '9012'
where pi_no = 81 

select * from PRICE_INFO;

select * from PRICE_INFO where pi_name like '%종각%';









------- 대회일정 캘린더 -----------------------------

create table calendar_contest(
cc_no number(7) primary key,
cc_text varchar2(200 char) not null,
cc_startDate date not null,
cc_endDate date not null
);

create sequence calendar_contest_seq;


insert into calendar_contest values(calendar_contest_seq.nextval, '대회1', '2022-03-14', '2022-03-14');

select * from calendar_contest;
select cc_text, cc_startDate, cc_endDate from calendar_contest

-- drop table calendar_contest;
-- drop sequence calendar_contest_seq;




create table calendar_contest_detail(
ccd_no number(7) primary key,
ccd_title varchar2(100 char) not null,
ccd_img varchar2(500 char) not null,
ccd_text varchar2(4000 char) not null
);


-- delete calendar_contest_detail;

select * from calendar_contest_detail;
select * from calendar_contest_detail where ccd_no = 23

drop table calendar_contest_detail;






-- 루틴 캘린더 DB ---------------------------------------

create table calendar_routine(
cr_no number(7) primary key,
cr_id varchar2(50 char) not null,
cr_text varchar2(200 char) not null,
cr_date date not null
);

create sequence calendar_routine_seq;

insert into calendar_routine values(calendar_routine_seq.nextval, 'sgbgin05@gmail.com', '스쿼트 100개', '2022-02-25');
insert into calendar_routine values(calendar_routine_seq.nextval, 
(select m_email from member where m_email = '1234@gmail.com'), '스쿼트 100개', '2022-03-03');

select * from calendar_routine;
select cr_no, cr_id, cr_text, cr_date from calendar_routine, member where m_email = cr_id and cr_date = '2022-03-03';

delete calendar_routine;

drop table calendar_routine;






