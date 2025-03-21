## ■ function
##1. Number
##2. String
##3. Date
##4. if / case

##1. Number (ceil 올림, floor 내림, round 반올림, mod 나머지)
use mbasic;
select ceil(1.1)`올림`,floor(1.9)`내림`,round(1.5)`반올림`,mod(10,3)`나머지`;
-- 연습문제 1
select 123.4578, round(123.4578)`ROUND1`,round(123.4578,-1)`ROUND2`,round(123.4578,1)`ROUND3`,round(123.4578,2)`ROUND4`; 
-- 연습문제 2
select 123.4578, ceil(123.4578)`CEIL`, floor(123.4578)`FLOOR`;

##2. String
## length() 문자길이, upper()/loewr() 대문자/소문자, instr(문자열,찾을 문자열) 위치찾기 
## substr(문자열,시작,객수) 문자열 일부 추출, left(문자열,갯수) 왼쪽에서 추출, right(문자열,갯수) 오른쪽에서 추출 
## concat(문자열,문자열) 연결, trim() - ltrim왼쪽,rtrim오른쪽 공백제거, replace(문자열,찾아서바꾸기) 찾아서 바꾸기 
## repeat(문자열,반복횟수) 반복, lpad(문자열,전체자리수,특정문자) 왼쪽특정문자채우기, rpad() 오른쪽특정문자채우기

-- 2-1. basic
-- 1) length(문자열) 개수
select length('abc');

-- 2) upper / lower
select 'abc', upper('abc'), lower('abc');

-- 3) instr 위치
select instr('abc', 'b') `B의 위치`, instr('abc', 'ab') `ab의 위치`, instr('abc','ac') `ac의 위치`;

-- 4) left, right, substr
select left('abc', 1), left('abc',2), right('abc',1), right('abc',2);
select substr('abcde', 2,2) `bc`, substr('abcde',2,3) `bcd`,substr('abcde',1,3) `abc`;

-- 5) 문자열 연결 concat(문자열1, 문자열2)
select concat('hello ', 'mysql') `hello mysql`;

-- 6) trim 좌우공백제거
select trim(' a b c ') `a b c`;
select concat('#',trim(' a b c '),'#')`#a b c#`,
	concat('#',ltrim(' a b c '),'#')`#a b c #`,
	concat('#',rtrim(' a b c '),'#')`# a b c#`;
    
-- 7) replace (문자열에서,무엇을찾아서,바꾸기)
select replace("hello sally",'sally','alpha')`hello alpha`;

-- 8) repeat (무엇을,몇개반복)
select repeat('*',5)`*****`;

-- 9) 빈칸채우기 
select lpad('abc',10,'#'),
	rpad('abc',10,'#');
    
## 연습문제
create table fn_select_userinfo2(
no int not null default 0,
name varchar(20) not null,
age int not null,
email varchar(20) not null
);
desc fn_select_userinfo2;
insert into fn_select_userinfo2 values(1,'aaa',11,'aaa@gmail.com');
insert into fn_select_userinfo2 values(2,'bbb',22,'bbb@gmail.com');
insert into fn_select_userinfo2 values(3,'ccc',33,'ccc@gmail.com');
insert into fn_select_userinfo2 values(4,'ddd',44,'ddd@gmail.com');
insert into fn_select_userinfo2 values(5,'abc',55,'abc@gmail.com');
insert into fn_select_userinfo2 values(6,'bca',66,'bca@gmail.com');
select*from fn_select_userinfo2;

-- 1
select name`이름`,length(name)`갯수` from fn_select_userinfo2;
-- 2
select name,left(name,1)`첫번째 글자`,right(name,1)`마지막 글자` from fn_select_userinfo2;
-- 3
select name,replace(name,'aaa','aaa 1등') from fn_select_userinfo2;
-- 4
select concat(name,'는 개발자입니다.')`직업` from fn_select_userinfo2;
-- 5 
select upper(name) from fn_select_userinfo2;
-- 6
select lower(name) from fn_select_userinfo2;
-- 7
select name, instr(name,'b') from fn_select_userinfo2 where age>=40;
-- 8
select name, instr(name,'b') from fn_select_userinfo2 where age>=40 order by age desc limit 2;
-- 9
select name,concat(left(name,1),'*',right(name,1))`test` from fn_select_userinfo2;
-- 10
create table select_userinfo2(
no int not null,
name varchar(20) not null,
age int not null,
email varchar(20) not null
);
insert into select_userinfo2 values(1,'aaaa',11,'aaa@gmail.com');
insert into select_userinfo2 values(2,'bbaab',22,'bbb@gmail.com');
insert into select_userinfo2 values(3,'cccaac',33,'ccc@gmail.com');
insert into select_userinfo2 values(4,'daadd',44,'ddd@gmail.com');
insert into select_userinfo2 values(5,'abc',55,'abc@gmail.com');
insert into select_userinfo2 values(6,'baaca',66,'bca@gmail.com');
select*from select_userinfo2;
select name,concat(left(name,1),repeat('*',length(name)-2),right(name,1))`test` from select_userinfo2;

##3. DATE
-- 1) 시스템의 현재 시각조회
select now();
select current_timestamp();
select curdate();
select curtime();
select current_date();
select current_time();

-- 2) 요일 (0=MON,1=TUE,...,6=SUN)
select weekday(now()); -- 4 금
select weekday("2025-03-21");

-- 3) 날짜형식 date_format(날짜지정,'%Y-%m-%d')
select date_format("2025-03-21",'%Y-%m-%d');
select date_format(now(),'%Y-%m-%d %H:%i:%s');

-- 4) 100일 전/ 후 date_add
select date_add(now(),interval -10 day);
select date_add(now(),interval 10 day);
select date_add(now(),interval -3 hour);

-- 5) datediff(날짜1,날짜2) 날짜차이
select datediff('2025-03-22','2025-03-21');
select timestampdiff(hour,'2025-03-22','2025-03-21');

##연습문제 1
create table date_userinfo (
no int not null default 0,
name varchar(100) not null,
age int not null,
date datetime default current_timestamp
);
desc date_userinfo;
insert into date_userinfo values (1,'aaa',11,'2022-12-30 00:00:00');
insert into date_userinfo values (2,'bbb',22,'2022-11-30 00:00:00');
insert into date_userinfo values (3,'ccc',33,'2022-10-30 00:00:00');
insert into date_userinfo values (4,'ddd',44,'2022-09-30 00:00:00');
select*from date_userinfo;
-- 1
select name,date from date_userinfo where date<'2022-11-01';
-- 2
select name,date,date_add(date,interval 30 day)`event` from date_userinfo where date between '2022-12-01' and '2022-12-31';
select name,date,date_add(date,interval 30 day)`event` from date_userinfo where month(date)=12; -- month() 월만
-- 3
select name,date_format(date,'%Y년 %m월 %d일')`가입날짜` from date_userinfo;

##연습문제 2
-- 1
select now();
-- 2
select datediff('2025-12-25',now());
-- 3
select date_add(now(),interval 5 month);
-- 4
select date_add(curdate(),interval(6-weekday(curdate())) day);

##4. if / case
-- if(조건,참,거짓)
-- 다형식
/*   case
   when 조건1 then 상태1
    when 조건2 then 상태2
    else 모든조건에 해당하지 않을 때, 생략가능
    end
*/

create table control (no int);
insert into control values (1),(2),(3);
select*from control;

-- 1-1.
select no, if(no=1,'1이다','1이 아니다')`상태` from control;
-- 1-2.
select no, if(no>1,'1보다 크다','1보다 작거나같다')`상태` from control;
-- 1-3. case when/then end
select no,case 
			when no=1 then '1이다'
            when no=2 then '2이다'
            when no=3 then '3이다'
            else '1,2,3 이 아니다'
		  end `state`
from control;
-- 1-4. 2이다, 크다, 작다
select no,case
			when no=2 then '2이다'
            when no>2 then '크다'
            when no<2 then '작다'
		  end 'state'
from control;

## 연습문제 1
create table if_userinfo(
no int not null auto_increment primary key,
name varchar(100) not null,
age int default 0,
sex char(1),
sns char(1)
);
desc if_userinfo;
insert into if_userinfo (name,age,sex,sns) values 
('first',11,null,'n'), 
('second',22,'m','y'),
('third',33,'m','y'),
('fourth',44,'f','n'),
('fifth',55,'f','y'),
('sixth',66,'m','n');
select*from if_userinfo;
-- 1
select *,if(sns='y','수신유지','수신거부')`수신여부상태` from if_userinfo;
-- 2
select *,if(age<19,'미성년자','성인')`성인여부` from if_userinfo;
-- 3
select count(*)`sns수신거부수` from if_userinfo where sns='n';
select sum(if(sns='n',1,0))`sns수신거부수` from if_userinfo;
select count(if(sns='n',1,null))`sns수신거부수` from if_userinfo;

## 연습문제 2 emp 테이블에서
-- 1
select ename`ENAME`,deptno`DEPTNO`,case 
when deptno=10 then 'ACCOUNTING'
when deptno=20 then 'RESEARCH'
when deptno=30 then 'SALES'
end`부서이름` 
from emp;
select ename`ENAME`,deptno`DEPTNO`,case deptno 
when 10 then 'ACCOUNTING'
when 20 then 'RESEARCH'
when 30 then 'SALES'
end`부서이름` 
from emp;
-- 2
select ename,job,case
when job='CLERK' then '판매원'
when job='SALESMAN' then '영업사원'
else '사원'
end`job2`
from emp;