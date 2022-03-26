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
c2_no number(7) primary key,-----------------------------------
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
c2r_no number(7) primary key, --댓글 번호-------------------------------
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
 cr_no number(7) primary key,---------------------
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
crr_no number(7) primary key, --댓글 번호-------------------------
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
-------------------------------------------------------------------------------------------

create table heart_table2(
h2_no  number(7) primary key,---------------------------------
h2_c2_no  number(7) not null, --게시글 넘버
h2_m_email varchar2(50 char) not null, -- 회원 이메일 
constraint h1_for_no
		foreign key(h2_c2_no) references community_review2(c2_no) on delete cascade,
		foreign key(h2_m_email) references member(m_email) on delete cascade);

create sequence heart_table2_seq;
insert into heart_table2 values(heart_table2_seq.nextval, 1, '1')
select * from heart_table2;	

select * from community_review2_reply  where c2r_c2_no =61 order by c2r_date desc
select * from community_review2_reply


select count(*) from heart_table2 where h2_c2_no = 161;
select * from COMMUNITY_REVIEW2 where c2_no = 161;




DROP SEQUENCE heart_table2_seq;
DROP TABLE heart_table2 CASCADE CONSTRAINTS;
-----------------------------------------------------------
ALTER TABLE COMMUNITY_REVIEW2 ADD c2_picture varchar(200 char);

-----------------------------------------------------------------


create table body_review(
br_no number(7) primary key,----------------------------
br_title varchar2(100 char) not null,
br_content varchar2(4000 char) not null,
br_like number(5) not null,
br_views varchar2(20 char) default 0 not null,
br_tips varchar2(200 char) not null,
br_bodyProfile varchar2(200 char) not null,
br_productReview varchar2(200 char) not null,
br_email varchar2(100) not null,
br_nickname varchar2(100) not null,
br_date date not null,
br_picture varchar(200 char)
)
create sequence body_review_seq;
select * from body_review;
---------------------------------------------------
create table body_review_reply(
brr_no number(7) primary key, --댓글 번호-----------------------------------
brr_br_no number(7) not null, -- 게시판 번호 
brr_text varchar2(200 char) not null,
brr_br_nickname varchar2(20 char) not null,-- 아이디
brr_date date not null,

constraint brr_for_no
		foreign key(brr_br_no)
		references body_review(br_no)
		on delete cascade

)
create sequence body_review_reply_seq;
select * from body_review_reply

DROP SEQUENCE body_review_reply_seq;
DROP TABLE body_review_reply CASCADE CONSTRAINTS;
----------------------------------------------------
create table heart_table3(
h3_no  number(7) primary key,-----------------------------------
h3_br_no  number(7) not null, --게시글 넘버
h3_m_email varchar2(50 char) not null, -- 회원 이메일 
constraint h3_for_no
		foreign key(h3_br_no) references body_review(br_no) on delete cascade,
		foreign key(h3_m_email) references member(m_email) on delete cascade);
		
		create sequence heart_table3_seq;
insert into heart_table3 values(heart_table3_seq.nextval, 2, 'bb')
select * from heart_table3;	
-----------------------------------------------------------------

--best게시판 테이블 
create table best_table(
b_br_no number(7)primary key,
b_brr_no number(7) not null,
b_c2_no number(7) primary key,
b_c2r_no number(7) not null,
b_h3_no number(7) not null,
b_h2_no number(7) not null,
constraint b_for_no
			foreign key(b_br_no) references BODY_REVIEW(br_no) on delete cascade,
			foreign key(b_brr_no) references BODY_REVIEW_REPLY(brr_no) on delete cascade,
			foreign key(b_c2_no) references COMMUNITY_REVIEW2(c2_no) on delete cascade,
			foreign key(b_c2r_no) references COMMUNITY_REVIEW2_REPLY(c2r_no) on delete cascade,
			foreign key(b_h3_no) references HEART_TABLE3(h3_no) on delete cascade,
			foreign key(b_h2_no) references HEART_TABLE2(h2_no) on delete cascade);

	create sequence best_table_seq;
	
	select * from best_table;	
	
update BODY_REVIEW set br_like = 6 where br_no = 2


select * from BODY_REVIEW where br_like >= 1;
select * from COMMUNITY_REVIEW2 where c2_like >= 1;

------------------------------------------------------------------------------------------------------------------------

create table pointChk(
p_num number(7) primary key,
p_email varchar2(50 char) not null, -- 회원 아이디
p_no number(7) not null, -- 게시판 넘버
p_check number(7) not null, -- 포인트 몇개 쌓였는지 체크
p_type varchar2(40 char) not null, -- 리뷰2테이블, 바디테이블 구분 할려고 

constraint p_for_no
	        foreign key(p_email) references member(m_email) on delete cascade,
	        foreign key(p_no) references COMMUNITY_REVIEW2(c2_no) on delete cascade,
	        foreign key(p_no) references BODY_REVIEW(br_no) on delete cascade);
	        
	        create sequence pointChk_seq
			select * from pointChk;	


DROP SEQUENCE pointChk_seq;
DROP TABLE pointChk CASCADE CONSTRAINTS purge;
select * from HEART_TABLE2;

select * from pointChk;
delete from pointChk;


select * from COMMUNITY_REVIEW2
select * from member;
update member set m_point = 0 where m_email = 'admin';



select * from (
	select rownum as rn, c2_no, c2_title, c2_content, c2_like, c2_views, 
	c2_tips, c2_bodyProfile, c2_productReview, c2_email, c2_nickname, c2_date, c2_picture, m_photo
	from (
	select * from community_review2, member	order by c2_date desc) where c2_email = m_email)
			where rn >= 1 and rn <= 5

update member set m_pw = 1234 where m_email = 'kgw96@naver.com';

select * from (select rownum as rn, br_no, br_title, br_content, br_like, br_views, 
br_tips, br_bodyProfile, br_productReview, br_email, br_nickname, br_date, br_picture,m_photo
from 

			(select * from body_review, member	order by br_date desc) where m_email = br_email	)
			where rn >= 1 and rn <= 5

			
select * from (select rownum as rn, cr_no, cr_title, cr_content, cr_like, cr_views, 
cr_tips, cr_bodyProfile, cr_productReview, cr_email, cr_nickname, cr_date, m_photo
 from 
			(select * from community_review, member	order by cr_date desc) where m_email = cr_email	)
			where rn &gt;= #{start} and rn &lt;= #{end}
