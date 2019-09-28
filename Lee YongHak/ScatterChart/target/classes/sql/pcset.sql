create table pcset
(
pcnum number(10) primary key,
fitc_id varchar2(30) not null ,
cpu varchar2(50) not null,
ram varchar2(50) not null,
vga varchar2(50) not null,
pc_case varchar2(50) not null,
pcdate date default sysdate
)

