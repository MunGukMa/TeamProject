create table tpj_cpu(
cpunum number primary key,
cpuname varchar2(100) not null,
cpuprocess varchar2(100) not null,
cpucore varchar2(100) not null,
cputhread varchar2(100) not null,
L2memory varchar2(100),
L3memory varchar2(100),
cpubit varchar2(100) not null,
cpupower varchar2(100) not null,
cpuddrtype varchar2(100) not null,
cpuingraphic varchar2(100),
cpucorespeed varchar2(100),
moreinfo varchar2(500));

create sequence cpu_seq;


create table tpj_techcpu (
cpunum number primary key,
cpuname varchar2(100) not null,
cpucode varchar2(100) not null,
cores varchar2(100) not null,
clock varchar2(100) not null,
socket varchar2(100) not null,
process varchar2(100) not null,
l3cache varchar2(100) not null,
tdp varchar2(100) not null,
released varchar2(100) not null,
point number not null)

create sequence techcpu_seq 


create table tpj_pmcpu(
    cpunum number primary key,
    cpunmae varchar2(100),
    price varchar2(100),
    cpumark varchar2(100),
    cpuval varchar2(100),
    threadmark varchar2(100),
    threadval varchar2(100),
    tdp varchar2(100),
    powerf varchar2(100),
    testdate varchar2(100),
    socket varchar2(100),
    category varchar2(100),
    rank varchar2(100)
);

create sequence pmcpu_seq