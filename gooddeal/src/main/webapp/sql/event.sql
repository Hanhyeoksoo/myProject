CREATE TABLE event(
 eve_num number not null,
 mem_num number not null,
 eve_title varchar2(300) not null,
 eve_content clob not null,
 eve_user varchar2(300) not null,
 eve_start varchar2(10) not null,
 eve_end varchar2(10) not null,
 eve_date date not null, 
 constraint event_pk primary key (eve_num)
);

CREATE TABLE event_result(
 eve_num number not null,
 mem_num number not null,
 eve_status number(1) default 1 not null, 
 constraint event_result_pk primary key (eve_num),
 constraint event_result_fk foreign key (mem_num) references event (eve_num)
);

CREATE SEQUENCE event_seq; 