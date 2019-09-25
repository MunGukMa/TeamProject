create table chart
(
gamename VARCHAR2(30) primary key,
gamelevel number not null,
pclevel number not null, 
imagelink varchar2(100) not null
)

insert into chart values('lol',9,2,'resources/icon/LOL.jpg');

insert into chart values('overwatch',5,5,'resources/icon/overwatch.jpg');

insert into chart values('battleground',6,4,'resources/icon/playerunknowns_battlegrounds.jpg');

insert into chart values('dota2',2,3,'resources/icon/dota_2.jpg');

insert into chart values('wow',7,1,'resources/icon/world_of_warcraft.jpg');

insert into chart values('rainbow6',4,5,'resources/icon/tom_clancys_rainbow_six_siege.jpg');

commit;