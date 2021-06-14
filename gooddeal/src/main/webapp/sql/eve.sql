/*상품 등록*/
create table eve(
	eve_num number not null,
	mem_num number not null,
	eve_title varchar2(60) not null,
	eve_tag varchar2(60) not null,
	eve_price number(10) not null,
	eve_content clob not null,
	eve_status number(1) not null, /*상품상태(1:새제품, 2:중고)*/
	eve_date date default sysdate not null,
	eve_buy number(1) not null, /*판매상태(1:판매중, 2:판매완료, 3:판매중지)*/
	eve_uploadfile1 blob,
	eve_filename1 varchar(300),
	eve_uploadfile2 blob,
	eve_filename2 varchar(300),
	eve_uploadfile3 blob,
	eve_filename3 varchar(300),
	constraint eve_pk primary key (eve_num),
	constraint eve_fk foreign key (mem_num) references member (mem_num)
);

create sequence eve_seq;