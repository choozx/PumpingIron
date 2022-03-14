select * from products

select * from products where p_type = 'supplements' ORDER BY p_price DESC

create table products(
	p_no number(7) primary key,
	p_name varchar2(30 char) not null,
	p_type varchar2(40 char) not null,
	p_price number(10) not null,
	p_img varchar2(200 char) not null,
	p_info varchar2(1000 char) not null,
	p_cnt number(7) not null
)

create sequence products_seq;
insert into PRODUCTS values(products_seq.nextval, '보충제1', 'supplements', 10000, 'zxc', 0);
insert into PRODUCTS values(products_seq.nextval, '보충제2', 'supplements', 15000, 'zxc', 0);
insert into PRODUCTS values(products_seq.nextval, '스트렙1', 'gripStrap', 15000, 'strap1', 0);
insert into PRODUCTS values(products_seq.nextval, '팔꿈치보호대1', 'elbowProtecter', 20000, 'elbowProtecter1', 0);
insert into PRODUCTS values(products_seq.nextval, '밸트', 'backWaist', 50000, 'back1', 0);
insert into PRODUCTS values(products_seq.nextval, '무릅보호대1', 'kneeProtecter', 11000, 'kneeProtecter1', 0);
insert into PRODUCTS values(products_seq.nextval, '신발', 'shoes', 11000, 'shoes1', 0);


--------------------------------------------------------------------
create table product_review(

r_no number(7) primary key,
r_title varchar2(30 char) not null,
r_text varchar2(200 char) not null,
r_writer varchar2(20 char) not null,
r_like number(10) not null,
r_img varchar2(200 char)not null

)

create sequence product_review_seq;

insert into PRODUCT_REVIEW values(PRODUCT_REVIEW_seq.nextval, '1', '1', 'gw', '1', '1');

select * from PRODUCT_REVIEW;

--------------------------------------------------------------------

create table community_info(
ci_no number(7) primary key,
ci_title varchar2(30 char) not null,
ci_text varchar2(200 char) not null,
ci_writer varchar2(20 char) not null,
ci_media varchar2(200 char) not null,
ci_img varchar2(200 char) not null,
ci_date date not null
)

create sequence community_info_seq;

DROP SEQUENCE community_info_seq;

insert into community_info values(community_info_seq.nextval, '1', '1', 'gw', '1', '1', sysdate);

select * from community_info;

-----------------------------------------------

create table community_info_reply(
cir_no number(7) primary key,
cir_text varchar2(200 char) not null,
cir_img varchar2(200 char) not null,
cir_writer varchar2(20 char) not null,
cir_date date not null
)

create sequence community_info_reply_seq;

insert into community_info_reply values(community_info_reply_seq.nextval, '1', '1', 'gw', sysdate);

select * from community_info_reply;

-------------------------------------------------------

create table community_review(
 cr_no number(7) primary key,
cr_title varchar2(100 char) not null,
cr_content varchar2(4000 char) not null,
cr_like varchar2(20 char) default 0 not null,
cr_views varchar2(20 char) default 0 not null,
cr_tips varchar2(200 char) not null,
 cr_bodyProfile varchar2(200 char) not null,
 cr_productReview varchar2(200 char) not null,
cr_email varchar2(100) not null,
cr_nickname varchar2(100) not null,
 cr_date date not null
)

delete COMMUNITY_REVIEW;
drop sequence community_review_seq
create sequence community_review_seq;

insert into community_review values(community_review_seq.nextval, '1', '1', 'gw', '1', '1', '1', '1', '1', '1', sysdate);
insert into community_review values(community_review_seq.nextval, '1', '1', '1', '1', '1', '1', '1', '1', 'gw', sysdate);
update community_review set cr_content = 'ㅁ', cr_title = '와'
where cr_no = '163';

select * from community_review;

DROP SEQUENCE community_review_seq;
DROP TABLE community_review CASCADE CONSTRAINTS;

------------------------------------------------------

create table community_review_reply(
crr_no number(7) primary key, --댓글 번호
crr_cr_no number(7) not null, -- 게시판 번호 
crr_text varchar2(200 char) not null,
crr_cr_nickname varchar2(20 char) not null,-- 아이디
crr_date date not null,

constraint crr_for_no
		foreign key(crr_cr_no)
		references community_review(cr_no)
		on delete cascade

)

create sequence community_review_reply_seq;

insert into community_review_reply values(community_review_reply_seq.nextval,'1', '1', 'gw', sysdate);
insert into community_review_reply values(community_review_reply_seq.nextval,'1', '개멋있다 후', 'hooooollly', sysdate);
insert into community_review_reply values(community_review_reply_seq.nextval,'101', '개멋있다 후', 'hooooollly', sysdate);


select crr_no, crr_text, crr_cr_nickname, crr_date
from community_review_reply where crr_cr_no = 101;

select * from community_review_reply;


select community_review,community_review_reply,status 2 from user_constraints;


DROP SEQUENCE community_review_reply_seq;
DROP TABLE community_review_reply CASCADE CONSTRAINTS;