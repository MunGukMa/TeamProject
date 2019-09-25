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

