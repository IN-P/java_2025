use mbasic;
create table member(
no int not null primary key auto_increment,
id varchar(100) not null,
pass varchar(50) not null
);
desc member;
insert into member (id,pass) 
values ('first','11'),
('second','22'),
('third','33'),
('fourth','44');
select * from member;