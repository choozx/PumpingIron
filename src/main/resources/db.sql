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
cr_no number(7),
cr_title varchar2(30 char) not null,
cr_text varchar2(200 char) not null,
cr_writer varchar2(20 char) not null,
cr_like varchar2(20 char) not null,
cr_views varchar2(20 char) not null,
cr_img varchar2(200 char) not null,
cr_tips varchar2(200 char) not null,
cr_bodyProfile varchar2(200 char) not null,
cr_productReview varchar2(200 char) not null,
cr_date date not null,
CONSTRAINT community_review_pk PRIMARY KEY (cr_no, cr_writer)
)

create sequence community_review_seq;

insert into community_review values(community_review_seq.nextval, '1', '1', 'gw', '1', '1', '1', '1', '1', '1', sysdate);

select * from community_review;

DROP SEQUENCE community_review_seq;
DROP TABLE community_review CASCADE CONSTRAINTS;







------------------------------------------------------

create table community_review_reply(

crr_no number(7) primary key,
crr_text varchar2(200 char) not null,
crr_img varchar2(200 char) not null,
crr_writer varchar2(20 char) not null,
crr_date date not null
)

create sequence community_review_reply_seq;

insert into community_review_reply values(community_review_reply_seq.nextval, '1', '1', 'gw', sysdate);

select * from community_review_reply;