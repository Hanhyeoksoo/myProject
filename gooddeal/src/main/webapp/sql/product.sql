/*상품 등록*/
create table product(
	pro_num number not null,
	mem_num number not null,
	pro_title varchar2(60) not null,
	pro_tag varchar2(60) not null,
	pro_price number(10) not null,
	pro_content clob not null,
	pro_status number(1) not null, /*상품상태(1:새제품, 2:중고)*/
	pro_date date default sysdate not null,
	pro_buy number(1) not null, /*판매상태(1:판매중, 2:판매완료, 3:판매중지)*/
	pro_uploadfile1 blob,
	pro_filename1 varchar(300),
	pro_uploadfile2 blob,
	pro_filename2 varchar(300),
	pro_uploadfile3 blob,
	pro_filename3 varchar(300),
	constraint product_pk primary key (pro_num),
	constraint product_fk foreign key (mem_num) references member (mem_num)
);

create sequence product_seq;