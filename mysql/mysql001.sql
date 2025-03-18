# 1. rdb : 관게형데이터베이스 - 테이블(Entity)들의 관계(Relationship) 왜래키(Attribute)
# 2. 데이터베이스 언어 
#	정의어 DDL - create, alter, drop - cad
#	조작어 DML - insert, select, update, delete - crud
# 	제어어 DCL - grant, revoke

use mbasic;
show tables;
desc userinfo;
create table userinfo_repeat(
no int not null auto_increment primary key,
name varchar(10) not null,
age int not null
);
alter table  userinfo_repeat modify name varchar(100) not null;
alter table userinfo_repeat add email varchar(50);
alter table userinfo_repeat drop email;
alter table userinfo_repeat rename userinfo;

#실습1) insert

# 1-1) 구조와 순서를 알고있을 때
insert into userinfo value (1,'first',11);
insert into userinfo value ('second',22,2); # 필드 순서 안맞음!
select*from userinfo;

# 1-2 원하는 필드만 데이터 입력
insert into userinfo (name,age) value ('second',22);
select*from userinfo;
insert into userinfo (age,name) value (33,'third');

# 1-3 연습문제
desc emp;
insert into emp value (7934,'MILLER','CLERK',7782,'1982-01-23',1300,null,10);
select*from emp;

desc dept;
insert into dept value (40,'OPERATIONS','BOSTON');
select*from dept;

desc salgrade;
insert into salgrade value (5,3001,9999);
select*from salgrade;

#실습2) update
/*    update  테이블명
    set     필드1 = 값1, 필드2=값2
     where   조건
*/
select*from userinfo;
insert into userinfo (name,age) values ('fourth',44);
#2-1. 전체데이터 수정
set sql_safe_updates=0; -- 안전모드 끄는 명령어 

update userinfo set age=0; -- error code 1175 위에서 안전모드 종료 했기때문에 가능
select*from userinfo;

#2-2. 바꿀데이터 여러개
update userinfo
set age=11
where no=1;
update userinfo set age=22,name='two' where no=2;
update userinfo set name='second' where no=2 and age=22;

update userinfo set name='third', age=33 where no=3;
update userinfo set age=44 where name='fourth';

#2-3 연습문제
desc score;
insert into score (sname,sjava,sjsp,sspring,sproject) values ('abc',89,98,69,77);
select*from score;

alter table score modify ssavg double;

update score set sjava=90,sjsp=90,sspring=90 where sname='ccc';
update score set semail='admin@gmail.com';
update score set sstotal=sjava+sjsp+sspring+sproject;
update score set ssavg=sstotal/4;
update score set semail='first@gmail.com' where ssavg=100;
update score set sjava=92,sjsp=78 where sname='bbb';
update score set semail='second@gmail.com',sname='second' where ssavg=89.5;
update score set semail='ccc@gmail.com' where sname='ccc';
update score set semail='blackstududent@gmail.com' where sproject<80;
update score set semail='hello@gmail.com' where ssavg=89.5 and sproject=98;

#실습3) delete
-- 준비 
create table userinfo_delete select*from userinfo; -- 수치복사 속성은 복사안됨
alter table userinfo_delete add primary key(no); -- 속성추가
alter table userinfo_delete modify no int not null auto_increment; -- 속성추가
desc userinfo;
desc userinfo_delete;
select*from userinfo;
select*from userinfo_delete;
#3-1 age가 11인 유저 삭제
delete from userinfo_delete where age=11;
select*from userinfo_delete;

# 이름이 second 이고 나이가 22살인 유저
delete from userinfo_delete where name='second' and age=22;

#전체데이터삭제
delete from userinfo_delete;

#3-2 연습문제
create table emp_del select*from emp;
desc emp;
desc emp_del;
alter table emp_del modify empno int not null auto_increment primary key;
select*from emp;
select*from emp_del;

delete from emp_del where job='SALESMAN';
delete from emp_del where job='MANAGER' and ename='JONES';
delete from emp_del;

