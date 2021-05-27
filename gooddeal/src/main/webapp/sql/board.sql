create table board(
	boa_num number not null,
	mem_num number not null,
	boa_title varchar2(150) not null,
	boa_content clob not null,
	boa_uploadfile blob,
	boa_date date not null,
	boa_update date not null,
	boa_view number not null,
	constraint board_pk primary key (boa_num),
    CONSTRAINT board_fk foreign key (mem_num) references member (mem_num)
);

create table board_reply( 
	bor_num number not null,
	boa_num number not null,
	bor_content varchar2(3000) not null,
	bor_date blob not null,
	constraint board_pk primary key (bor_num),
    CONSTRAINT board_fk2 foreign key (boa_num) references board (boa_num)
);
           
create table board_fav(
	bof_num number not null,
	boa_num number not null,
	mem_num number not null,
	constraint board_pk primary key (bof_num),
    CONSTRAINT board_fk3 foreign key (boa_num) references board (boa_num),
    CONSTRAINT board_fk4 foreign key (mem_num) references member (mem_num)
);

create sequence board_seq;
create sequence board_reply_seq;
create sequence board_fav_seq;

