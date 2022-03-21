select * from products

select * from products where p_type = 'supplements' ORDER BY p_price DESC

create table products(
	p_no number(7) primary key,
	p_name varchar2(300 char) not null,
	p_type varchar2(40 char) not null,
	p_price number(10) not null,
	p_img varchar2(200 char) not null,
	p_info varchar2(4000 char) not null,
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

DROP SEQUENCE products_seq;
DROP TABLE products CASCADE CONSTRAINTS purge;

select * from (select rownum as rn,p_no,p_name,p_type,p_price,p_img,p_info,p_cnt from products where p_type = 'supplements') where rn >= 1 and rn <= 10;
select * from (select rownum as rn, products.* from (select * from products where p_type = 'supplements' ORDER BY p_price DESC)products) where rn >= 1 and rn <= 10;
--------------------------------------------------------------------
create table cart(
	cart_no number(7) primary key,
	m_email varchar2(100 char) not null,
	p_no number(7) not null,
	constraint cart_for_no
		foreign key(p_no) references products(p_no) on delete cascade,
		foreign key(m_email) references member(m_email) on delete cascade
)
create sequence cart_seq;

insert into cart values(cart_seq.nextval, 'admin', 1)
select * from CART

delete CART;

select * from products where p_no in (select p_no from cart where m_email = 'admin')
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

create table community_review2(
c2_no number(7) primary key,
c2_title varchar2(100 char) not null,
c2_content varchar2(4000 char) not null,
c2_like number(5) not null,
c2_views varchar2(20 char) default 0 not null,
c2_tips varchar2(200 char) not null,
c2_bodyProfile varchar2(200 char) not null,
c2_productReview varchar2(200 char) not null,
c2_email varchar2(100) not null,
c2_nickname varchar2(100) not null,
c2_date date not null
)

create sequence community_review2_seq;

DROP SEQUENCE community_review2_seq;

insert into community_review2 values(community_review2_seq.nextval, '1', '1', 1, '1', '1', '1', '1', '1', 'gw', sysdate);

select * from community_review2;

-----------------------------------------------

create table community_review2_reply(
c2r_no number(7) primary key, --댓글 번호
c2r_c2_no number(7) not null, -- 게시판 번호 
c2r_text varchar2(200 char) not null,
c2r_c2_nickname varchar2(20 char) not null,-- 아이디
c2r_date date not null,

constraint c2r_for_no
		foreign key(c2r_c2_no)
		references community_review2(c2_no)
		on delete cascade

)

create sequence community_review2_reply_seq;

insert into community_review2_reply values(community_review2_reply_seq.nextval, '1', '1', 'gw', sysdate);

select * from community_review2_reply;

DROP SEQUENCE community_review2_reply_seq;
DROP TABLE community_review2_reply CASCADE CONSTRAINTS;
-------------------------------------------------------

create table community_review(
 cr_no number(7) primary key,
cr_title varchar2(100 char) not null,
cr_content varchar2(4000 char) not null,
cr_like number(5) not null,
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


select * from community_review;

DROP SEQUENCE community_review_seq;
DROP TABLE community_review CASCADE CONSTRAINTS purge;

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

----------------------------------------------------------

create table heart_table(
h_no  number(7) primary key,
h_cr_no  number(7) not null, --게시글 넘버
h_m_email varchar2(50 char) not null, -- 회원 이메일 
constraint h_for_no
		foreign key(h_cr_no) references community_review(cr_no) on delete cascade,
		foreign key(h_m_email) references member(m_email) on delete cascade);

create sequence heart_table_seq;
insert into heart_table values(heart_table_seq.nextval, 101, '1234@gmail.com')
select * from heart_table;	

select count(*) from heart_table where h_cr_no = 101

