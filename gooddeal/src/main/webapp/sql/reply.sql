create table product_reply(
	rep_num number not null PRIMARY KEY,
	pro_num number not null,
	mem_num number not null,
	rep_content varchar2(600) not null, 
	rep_date date default sysdate,
   constraint product_reply_fk FOREIGN key (pro_num) REFERENCES product(pro_num)
);

create sequence pro_reply_seq;