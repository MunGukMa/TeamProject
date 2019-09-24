create table mainboard_product
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

create sequence mainboard_seq;

create table power_product
(
    num number primary key,
    name varchar2(200) not null,
    price varchar2(20) not null,
    power varchar2(20) not null,
    output varchar2(20) not null,
    fanSize varchar2(20) not null,
    fanNum varchar2(10) not null,
    atx varchar2(10) not null,
    sata varchar2(10) not null,
    connecter varchar2(200) not null,
    etc varchar2(500) not null,
    releaseDate varchar2(20) not null
);

create sequence power_seq;

create table steam_product
(
    num number primary key,
    appid varchar2(100) not null,
    name varchar2(200) not null
);

create sequence steam_seq;