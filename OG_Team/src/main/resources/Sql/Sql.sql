create table fit_gamelist(
gamename varchar2(20) primary key,
gamelevel number,
pclevel number,
imagelink varchar2(100) not null,
gamecpu varchar2(50),
gameram varchar2(50),
gamegpu varchar2(50),
gameaddop varchar2(100),
memo varchar2(100));

create table fit_cpu (
num number primary key,
cpuname varchar2(100) not null,
cpucode varchar2(100) not null,
cores varchar2(100) not null,
clock varchar2(100) not null,
socket varchar2(100) not null,
process varchar2(100) not null,
l3cache varchar2(100) not null,
tdp varchar2(100) not null,
released varchar2(100) not null,
point number default null);

create table fit_case(
num number primary key,
casename varchar2(100),
rowprice varchar2(20),
power varchar2(50),
mainboardsize varchar2(100),
casesize varchar2(100),
addop varchar2(600));

create table fit_gpu (
num number primary key,
manufacturer varchar2(10) not null,
product_name varchar2(50) not null,
chip varchar2(20) not null,
realeased_date varchar2(20) not null,
bus varchar2(20) not null,
m_size varchar2(20) not null,
m_ddr varchar2(20) not null,
m_bit varchar2(20) not null,
g_clock varchar2(20) not null,
m_clock varchar2(20) not null,
tdp varchar2(20) not null,
rank number not null
); 

create table fit_ram (
num number primary key,
name varchar2(100) not null,
spec varchar2(300) not null,
src_link varchar2(300) not null
);

create table fit_mainboard
(
    num number primary key,
    name varchar2(100) not null,
    sockets varchar2(100) not null,
    formFactor varchar2(100) not null,
    chipSet varchar2(100) not null,
    RAM varchar2(50) not null,
    releaseDate varchar2(50) not null,
    audioChip varchar2(50) not null,
    usb2 varchar2(20) not null,
    usb3 varchar2(20) not null,
    sata varchar2(20) not null
);

create table fit_power
(
    num number primary key,
    name varchar2(200) not null,
    price varchar2(20),
    power varchar2(20) ,
    output varchar2(20) not null,
    fanSize varchar2(20),
    fanNum varchar2(10),
    atx varchar2(10),
    sata varchar2(10),
    connecter varchar2(200),
    etc varchar2(500),
    releaseDate varchar2(20)
);

create table fit_steam
(
    num number primary key,
    appid varchar2(100) not null,
    name varchar2(200) not null
);


create table fit_member(
    fit_userid varchar2(20) primary key,
    fit_userpwd varchar2(20) not null,
    fit_usernick varchar2(20) not null,
    fit_usermail varchar2(50) not null,
    fit_userkeyvalue varchar2(50) not null,
    fit_userestimatenum varchar2(50)
);
