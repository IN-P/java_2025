use mbasic;
create table sboaed (
bno int not null primary key auto_increment,
bname varchar(100) not null,
bpass varchar(50) not null,
btitle varchar(1000) not null,
bcontent text not null,
bdate timestamp not null default current_timestamp,
bhit int default 0,
bip varchar(50) not null
);
