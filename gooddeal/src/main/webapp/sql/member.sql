create table member(
	mem_num number not null,
	mem_id varchar2(15) not null,
	mem_now varchar2(1) default 2 not null,
    constraint member_pk primary key(mem_num)
);


create table member_detail(
	mem_num number not null,
	mem_password varchar2(20) not null,
	mem_name varchar2(15) not null,
	mem_propick blob,
	mem_filename varchar2(300),
	mem_credit number default 5 not null,
	mem_phone varchar2(13) not null,
	mem_email varchar2(50) not null,
	mem_zipcode varchar2(5) not null,
	mem_address1 varchar2(100) not null,
	mem_address2 varchar2(100) not null,
	mem_address3 varchar2(100) not null,
	mem_date date default sysdate,
	constraint member_detail_pk primary key (mem_num),
	constraint member_detail_fk foreign key (mem_num) references member (mem_num)
);

create sequence member_seq;