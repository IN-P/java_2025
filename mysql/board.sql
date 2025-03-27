use mbasic;
create table board(
bno int not null primary key auto_increment,
btitle varchar(1000) not null,
bcontent text not null,
bname varchar(100) not null,
bhit int default 0,
bdate timestamp not null default current_timestamp,
bip varchar(100) not null
);
desc board;
