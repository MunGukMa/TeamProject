create table comments
(
c_num number(10) primary key,
b_num number(10) not null CONSTRAINT comments_b_num_fk references chart_board(b_num) on delete cascade,
fitc_id varchar2(30) not null CONSTRAINT comments_fitc_id_fk references chart_member(fitc_id) on delete cascade,
comments varchar2 (100) not null,
c_date date default sysdate 
)

create SEQUENCE comments_seq;


