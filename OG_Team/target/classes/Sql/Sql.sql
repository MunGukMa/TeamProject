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
create sequence mb_seq



insert into gamelist values('lol',9,2,'resources/icon/LOL.jpg','Intel Core I5-8600','16gb','gtx 1060',null,null);

insert into gamelist values('overwatch',5,5,'resources/icon/overwatch.jpg','Intel Core I5-8600','16gb','gtx 1060',null,null);

insert into gamelist values('battleground',6,4,'resources/icon/playerunknowns_battlegrounds.jpg','Intel Core I5-8600','16gb','gtx 1060',null,null);

insert into gamelist values('dota2',2,3,'resources/icon/dota_2.jpg','Intel Core I5-8600','16gb','gtx 1060',null,null);

insert into gamelist values('wow',7,1,'resources/icon/world_of_warcraft.jpg','Intel Core I5-8600','16gb','gtx 1060',null,null);

insert into gamelist values('rainbow6',4,5,'resources/icon/tom_clancys_rainbow_six_siege.jpg','Intel Core I5-8600','16gb','gtx 1060',null,null);
commit;