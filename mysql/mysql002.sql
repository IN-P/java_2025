use mbasic;

desc milk;

select*from milk;
insert into milk (mname,mprice) values ('melon',5000);
update milk set mprice=1500 where mno=4;
delete from milk where mno=4 and mname='melon';
## 한줄 실행 ctrl + enter
## 여러줄 실행 ctrl + shift + enter 

desc userinfo_ex;

create table userinfo_ex select*from userinfo;
alter table userinfo_ex modify no int not null auto_increment primary key;

select*from userinfo_ex;
update userinfo_ex set name='second' where no=2;
insert into userinfo_ex (name,age) values ('fifth',55);
insert into userinfo_ex values (6,'sixth',66);
set sql_safe_updates=0; -- 안전모드 끄는 명령어
update userinfo_ex set age=10;
update userinfo_ex set name='third',age=33 where no=3 and age=10;
delete from userinfo_ex where no=3 and age=10;
delete from userinfo_ex;

alter table userinfo_ex rename select_userinfo; 
-- 1. 전체 데이터 검색
select*from select_userinfo;
-- 2. 부분검색
select name, age from select_userinfo;
-- 3. 중복제거 (distinct)
select distinct name from select_userinfo;
-- 4. 별명 ( ` : 1번키 왼쪽) as 생략가능 
select name as `이름`, age `나이` from select_userinfo;
-- 5. where 조건 (= 같다, != <> 다르다, < <= > >= )
select*from select_userinfo where name='second';
select*from select_userinfo where name!='second';
select*from select_userinfo where name<>'second';

select*from select_userinfo where age<33;
select*from select_userinfo where age<=33;
select*from select_userinfo where age>33;
select*from select_userinfo where age>=33;
-- 6. and, beween and / or, in
select*from select_userinfo where age>=22 and age<=33;
select*from select_userinfo where age between 22 and 33;

select*from select_userinfo where age=22 or age=33;
select*from select_userinfo where age in(22,33);
-- 7. null 검색 is null
desc select_userinfo;
alter table select_userinfo modify age int;
select*from select_userinfo;
insert into select_userinfo (name) values ('seven');

-- null은 값이 아닌 비어있는 상태를 나타낸다
select*from select_userinfo where age=null; ## 찾을 수 없음
select*from select_userinfo where age is null;
select*from select_userinfo where age!=null; ## 찾을 수 없음
select*from select_userinfo where age is not null;

select*from select_userinfo where age not between 22 and 33;
select*from select_userinfo where age not in(22,33);

-- 아래줄로 복사 ctrl + d
-- 8. like 문자열검색 (like 'a%', '%a', '%a%', '_a%' )
select*from select_userinfo where name='first'; -- first 찾기
select*from select_userinfo where name like 'f%'; -- f로 시작하는문자열 찾기
select*from select_userinfo where name like '%t'; -- t로 끝나는문자열 찾기
select*from select_userinfo where name like '%i%'; -- i가 포함되는문자열 찾기
select*from select_userinfo where name like '_e%'; -- 두번쨰 문자가 e인 문자열 찾기

