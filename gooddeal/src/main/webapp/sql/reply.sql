create table product_reply(
	rep_num number not null PRIMARY KEY,
	pro_num number not null,
	mem_num number not null,
	reply_content varchar2(600) not null, 
	reply_date date default sysdate
   --fk pronum(product테이블), memnum(member테이블)
)

alter table product_reply
add FOREIGN key (pro_num) REFERENCES product(pro_num);