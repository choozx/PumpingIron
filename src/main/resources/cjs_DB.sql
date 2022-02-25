
--create table info_map{
--im_no(pk) ,
--im_name,
--im_text,
--im_menu,
--im_price,
--im_latitude,
--im_longitude
--};
--
--create sequence info_map_seq;



-- 아직 덜 완성됐어요! 추가하시면 안 됩니다!!!
-- 아직 덜 완성됐어요! 추가하시면 안 됩니다!!!
-- 아직 덜 완성됐어요! 추가하시면 안 됩니다!!!
-- 아직 덜 완성됐어요! 추가하시면 안 됩니다!!!
-- 아직 덜 완성됐어요! 추가하시면 안 됩니다!!!
-- 아직 덜 완성됐어요! 추가하시면 안 됩니다!!!
-- 아직 덜 완성됐어요! 추가하시면 안 됩니다!!!
-- 아직 덜 완성됐어요! 추가하시면 안 됩니다!!!
-- 아직 덜 완성됐어요! 추가하시면 안 됩니다!!!
-- 아직 덜 완성됐어요! 추가하시면 안 됩니다!!!

create table info_price(
ip_no number(7) primary key,
ip_name varchar2(30 char) not null, 
ip_location varchar2(200 char) not null,
ip_price number(7) not null,
ip_partnership varchar2(1 char)
);

create sequence info_price_seq;



create table calendar_contest(
cc_no number(7) primary key,
cc_text varchar2(200 char) not null,
cc_date date not null
);

create sequence calendar_conteste_seq;



create table calendar_routine(
cr_no number(7) primary key,
cr_id varchar2(50 char) not null,
cr_text varchar2(200 char) not null,
cr_date date not null
);

create sequence calendar_routine_seq;








