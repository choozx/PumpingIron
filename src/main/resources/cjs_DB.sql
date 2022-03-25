create table price_info(
pi_no number(7) primary key,
pi_name varchar2(50 char) not null,
pi_loc varchar2(50 char) not null,
pi_price varchar2(500 char) not null,
pi_partner varchar2(50 char) not null,
pi_img varchar2(1000 char) not null
);

create sequence price_info_seq;

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

insert into calendar_contest_detail values(22, '20220319 PCA경북', 'resources/img/calendar/20220319_PCA경북.png',
'상세정보');
insert into calendar_contest_detail values(23, '20220320 NPCA경북', 'resources/img/calendar/20220320_NPCA경북.png',
'상세정보');
insert into calendar_contest_detail values(24, '20220326 PCA서울', 'resources/img/calendar/20220326_PCA서울.png',
'상세정보');
insert into calendar_contest_detail values(25, '20220327 NPCA서울', 'resources/img/calendar/20220327_NPCA서울.png',
'상세정보');
insert into calendar_contest_detail values(124, '20220402 PCA 한국대표 선발전', 'resources/img/calendar/20220402_PCA한국대표선발전.jpg',
'상세정보');
insert into calendar_contest_detail values(125, '20220402 NPCA Championship', 'resources/img/calendar/20220402_NPCA_Championship.jpg',
'상세정보');
insert into calendar_contest_detail values(126, '20220409 PCA 전북', 'resources/img/calendar/20220409_PCA전북.jpg',
'상세정보');
insert into calendar_contest_detail values(127, '20220410 NPCA 전북', 'resources/img/calendar/20220410_NPCA전북.jpg',
'상세정보');
insert into calendar_contest_detail values(128, '20220416 PCA 전남', 'resources/img/calendar/20220416_PCA전남.jpg',
'상세정보');
insert into calendar_contest_detail values(129, '20220417 NPCA 전남', 'resources/img/calendar/20220417_NPCA전남.jpg',
'상세정보');
insert into calendar_contest_detail values(130, '20220423 PCA 경남', 'resources/img/calendar/20220423_PCA경남.jpg',
'상세정보');
insert into calendar_contest_detail values(131, '20220424 NPCA 경남', 'resources/img/calendar/20220424_NPCA경남.jpg',
'상세정보');
insert into calendar_contest_detail values(132, '20220430 PCA 안양', 'resources/img/calendar/20220430_PCA안양.jpg',
'상세정보');
insert into calendar_contest_detail values(133, '20220501 NPCA 안양', 'resources/img/calendar/20220501_NPCA안양.jpg',
'상세정보');
insert into calendar_contest_detail values(134, '20220507 PCA 세종', 'resources/img/calendar/20220507_PCA세종.jpg',
'상세정보');
insert into calendar_contest_detail values(135, '20220508 NPCA 세종', 'resources/img/calendar/20220508_NPCA세종.jpg',
'상세정보');
insert into calendar_contest_detail values(136, '20220521 PCA 대구', 'resources/img/calendar/20220521_PCA대구.jpg',
'상세정보');
insert into calendar_contest_detail values(137, '20220522 NPCA 대구', 'resources/img/calendar/20220522_NPCA대구.jpg',
'상세정보');
insert into calendar_contest_detail values(138, '20220528 PCA 광주', 'resources/img/calendar/20220528_PCA광주.jpg',
'상세정보');
insert into calendar_contest_detail values(139, '20220529 NPCA 광주', 'resources/img/calendar/20220529_NPCA광주.jpg',
'상세정보');
insert into calendar_contest_detail values(140, '20220604 PCA 인천', 'resources/img/calendar/20220604_PCA인천.jpg',
'상세정보');
insert into calendar_contest_detail values(141, '20220605 NPCA 인천', 'resources/img/calendar/20220605_NPCA인천.jpg',
'상세정보');
insert into calendar_contest_detail values(142, '20220611 PCA 파주', 'resources/img/calendar/20220611_PCA파주.jpg',
'상세정보');
insert into calendar_contest_detail values(143, '20220612 NPCA 파주', 'resources/img/calendar/20220612_NPCA파주.jpg',
'상세정보');
insert into calendar_contest_detail values(144, '20220618 PCA 수원', 'resources/img/calendar/20220618_PCA수원.jpg',
'상세정보');
insert into calendar_contest_detail values(145, '20220619 NPCA 수원', 'resources/img/calendar/20220619_NPCA수원.jpg',
'상세정보');
insert into calendar_contest_detail values(146, '20220625 PCA 충청도', 'resources/img/calendar/20220625_PCA충청도.jpg',
'상세정보');
insert into calendar_contest_detail values(147, '20220626 NPCA 충청', 'resources/img/calendar/20220626_NPCA충청.jpg',
'상세정보');
insert into calendar_contest_detail values(148, '20220605 PCA KOREA Pilates', 'resources/img/calendar/20220605_PCA_KOREA_Pilates.jpg',
'상세정보');

update calendar_contest_detail where cc_no = 

delete calendar_contest_detail where ccd_no = 127;

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






