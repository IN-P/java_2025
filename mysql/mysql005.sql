use mbasic;
create table join_userban (
no int not null auto_increment primary key,
name varchar(20) not null,
ban char(2)
);
desc join_userban;
insert into join_userban (name,ban) values ('first','A'),
('second','B'),
('third','A'),
('fourth','C'),
('fifth','B'),
('sixth','C'),
('fifth','B'),
('sixth','C');
select*from join_userban;
update join_userban set ban='D' where no>=7;
delete from  join_userban where no>=7;
select count(ban) from join_userban group by ban;

## 데이터베이스 언어
## DDL - create, alter, drop
## DML - insert, select, update, delete
## DCL - grant, revoke

## e(entity:테이블) r(relation:관계) 속성:pk, fk
## join 
-- 두개이상의 테이블들을 연결해서 데이터를 조회
-- 테이블간의 견결고리 (pk, fk)

## 종류 : inner join. outer join

create table join_userinfo (
no int not null default 0,
name varchar(100) not null,
age int not null);
desc join_userinfo;
insert into join_userinfo values (1,'first',11),
(2,'second',22),
(3,'third',33),
(4,'fourth',44);
select*from join_userinfo;

## inner join
-- (1) join
select a.no, a.name, a.age, b.ban
from join_userinfo a, join_userban b
where a.no = b.no;

-- (2) join on
select a.no, a.name, a.age, b.ban
from join_userinfo a join join_userban b on (a.no = b.no);

-- (3) join using
select a.no, a.name, a.age, b.ban
from join_userinfo a join join_userban b using(no);

-- (4) natural join 알아서 연결해줌
select no, name, age, ban
from join_userinfo natural join join_userban;

## qusetion2
select a.no, a.name, a.age, b.ban
from join_userinfo a, join_userban b
where a.no = b.no and a.age between 20 and 40;

select a.no, a.name, a.age, b.ban
from join_userinfo a join join_userban b on (a.no = b.no)
where age between 20 and 40;

select a.no, a.name, a.age, b.ban
from join_userinfo a join join_userban b using(no)
where age between 20 and 40;

select no, name, age, ban
from join_userinfo natural join join_userban
where age between 20 and 40;

## outer join
## right join 오른쪽값 보장
select a.no, a.name, b.ban, a.age
from join_userinfo a right join join_userban b on a.no = b.no;

## left join 왼쪽값 보장
select a.no, a.name, b.ban, a.age
from join_userban b left join  join_userinfo a  on a.no = b.no;

## qusetion4
select b.no, b.name, b.ban, a.age
from join_userban b left join  join_userinfo a  on a.no = b.no;

