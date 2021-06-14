create table eve_reply(
	rep_num number not null PRIMARY KEY,
	eve_num number not null,
	mem_num number not null,
	rep_content varchar2(600) not null, 
	rep_date date default sysdate,
   constraint eve_reply_fk FOREIGN key (eve_num) REFERENCES eve(eve_num)
);

create sequence eve_reply_seq;