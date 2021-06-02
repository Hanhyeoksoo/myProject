/*신고 게시판(비공개)*/
create table cheat_board(
    che_num NUMBER not null ,
    mem_num number not null ,
    che_title VARCHAR2(300) not null,
    che_content VARCHAR2(3000)  not null,
    che_pnum number not null,
    che_view INT not null default 0,
    che_admincheck number(1) not null default 1  /* 1:미확인 2:확인 */,
    che_date date not null,
    constraint cheat_board_pk primary key (che_num),
	constraint cheat_board_fk foreign key (mem_num) references member (mem_num)
); 

create sequence cheat_board_seq;