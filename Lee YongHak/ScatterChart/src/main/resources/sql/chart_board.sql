create table chart_board
(
b_num number(10) primary key,
fitc_id varchar2(30) not null,
title varchar2(50) not null,
b_content varchar2(500) not null,
b_date date default sysdate,
hit number(10) default 0,
pcset_cpu varchar2(300),
pcset_ram varchar2(300),
pcset_vga varchar2(300),
pcset_pc_case varchar2(300),
CONSTRAINT chart_board_fk foreign key(fitc_id)
REFERENCES chart_member(fitc_id) on delete CASCADE
)


create SEQUENCE chart_board_seq;

insert into chart_board
values(chart_board_seq.nextval, 'aaaa', '���� �� ����', '�̷��� ®�µ� �� ��Ź�����', sysdate, 0);

insert into chart_board
values(chart_board_seq.nextval, 'aaaa', '�̰� ���� �?', '��������? ��������?', sysdate, 0);

commit;

SELECT *
		FROM
			chart_board
		ORDER BY
			b_num DESC