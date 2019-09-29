create table chart
(
gamename VARCHAR2(30) primary key,
gamelevel number not null,
pclevel number not null, 
imagelink varchar2(100) not null,
cpu varchar2(50) not null,
ram varchar2(50) not null,
vga varchar2(50) not null
)

insert into chart values('lol',9,2,'resources/icon/LOL.jpg','cpu1','ram1','vga1');

insert into chart values('overwatch',5,5,'resources/icon/overwatch.jpg','cpu2','ram2','vga2');

insert into chart values('battleground',6,4,'resources/icon/playerunknowns_battlegrounds.jpg','cpu3','ram3','vga3');

insert into chart values('dota2',2,3,'resources/icon/dota_2.jpg','cpu4','ram4','vga4');

insert into chart values('wow',7,1,'resources/icon/world_of_warcraft.jpg','cpu5','ram5','vga5');

insert into chart values('rainbow6',4,5,'resources/icon/tom_clancys_rainbow_six_siege.jpg','cpu6','ram6','vga6');

commit;