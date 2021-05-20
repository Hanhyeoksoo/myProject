create table product_reply(
	rep_num number not null PRIMARY KEY,
	pro_num number not null,
	mem_num number not null,
	reply_content varchar2(600) not null, 
	reply_date date default sysdate
   
)

alter table product_reply
add FOREIGN key (mem_num) REFERENCES product(mem_num)