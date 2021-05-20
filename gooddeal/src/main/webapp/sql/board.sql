create table board(
	boa_num number not null primary key,
	mem_num number foreign key,
	boa_title varchar2(150) not null,
	boa_content clob not null,
	boa_uploadfile blob,
	boa_date date not null,
	boa_update date not null,
	boa_view number not null	
);

create table board_reply( 
	bor_num number not null primary key,
	boa_num number not null foreign key,
	bor_content varchar2(3000) not null,
	bor_date blob not null	
);

create table board_fav(
	bof_num number not null primary key,
	boa_num number not null foreign key,
	mem_num number not null foreign key
);
