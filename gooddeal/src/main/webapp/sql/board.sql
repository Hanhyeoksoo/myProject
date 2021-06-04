/*게시판*/
create table sprboard(
  board_num	number not null,
  title varchar2(100) not null,
  content clob not null,
  hit number(5) default 0 not null,
  reg_date date default sysdate not null,
  modify_date date default sysdate not null,
  uploadfile blob,
  filename varchar2(100),
  ip varchar2(40) not null,
  mem_num number not null,
  constraint sprboard_pk primary key (board_num),
  constraint sprboard_fk foreign key (mem_num) 
                  references member (mem_num)
);

create sequence sprboard_seq;






