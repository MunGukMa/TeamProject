create table gamelist(
gamename varchar2(20) primary key,
gamelevel number,
pclevel number,
imagelink varchar2(100) not null,
gamecpu varchar2(50),
gameram varchar2(50),
gamegpu varchar2(50),
gameaddop varchar2(100),
memo varchar2(100))

create table mainboard(
num number primary key, 
name varchar2(100), 
sockets varchar2(100), 
formFactor varchar2(100), 
chipSet varchar2(100), 
RAM varchar2(100), 
releaseDate varchar2(100), 
audioChip varchar2(100), 
usb2 varchar2(100), 
usb3 varchar2(100), 
sata varchar2(100),
memo varchar2(50)
)

create table cpu (
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
point number not null)

create table case(
num number primary key,
casename varchar2(50),
rowprice varchar2(20),
power varchar2(50),
mainboardsize varchar2(50),
casesize varchar2(100),
addop varchar2(150))

create table gpu (
gpu_sec number primary key,
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

create table ram (
num number primary key,
name varchar2(100) not null,
spec varchar2(300) not null,
src_link varchar2(300) not null
);
