use mbasic;
create table sub_userinfo (
no int not null primary key auto_increment,
name varchar(20) not null,
age int not null,
sex char(2),
kor int,
eng int,
math int,
ban char(2),
sns char(2) default 'y'
);
desc sub_userinfo;
insert into sub_userinfo (name,age,sex,kor,eng,math,ban,sns) values
('first',11,null,100,100,99,'A','n'),
('second',22,'m',89,92,78,'B','y'),
('third',33,'m',90,92,97,'A','y'),
('fourth',44,'f',40,42,67,'C','n'),
('fifth',55,'f',89,86,99,'B','y'),
('sixth',66,'m',10,20,40,'C','n');
select * from sub_userinfo;

/*
1. 서브쿼리
- select 구문안에 select 구문
- 서브쿼리 결과가 하나이상이 반환시 in, any, all 사용

2. 형식
select 컬럼 from 테이블명 where 컬럼 in ( select 문 );

3. 다중행 연산자
- in, any(some), all
1) in : 서브쿼리의 결과가 하나라도 일치하면 true
2) any : 서브쿼리의 결과가 하나이상이면 true
3) all : 서브쿼리의 결과가 모두 만족하면 true
*/

create table atest as select 1 num from dual
union all select 2 from dual
union all select 3 from dual
union all select 4 from dual
union all select 5 from dual
union all select 6 from dual;
select * from atest;

select num from atest where num < any(select num from atest where num in (3,4,5)) order by num;
-- 1,2,3,4
select num from atest where num > any(select num from atest where num in (3,4,5)) order by num;
-- 4,5,6
select num from atest where num < all(select num from atest where num in (3,4,5)) order by num;
-- 1,2
select num from atest where num > all(select num from atest where num in (3,4,5)) order by num;
-- 6

##1-1. 평균나이 이상인 레코드를 추출
-- select * from sub_userinfo where age >= 평균나이
##1-2. 평균나이
-- select avg(age) from sub_userinfo;
##1-3.
select * from sub_userinfo where age >=(select avg(age) from sub_userinfo);

##2. first와 같은반 국어 영어 수학 점수 추출
select ban,name,kor,eng,math from sub_userinfo where ban=(select ban from sub_userinfo where name='first');

##3. fisrt와 같은반 국어 영어 수학 각점수 평균 추출
select ban,avg(kor),avg(eng),avg(math) 
from sub_userinfo 
where ban=(select ban from sub_userinfo where name='first')
group by ban;

##연습문제
select * from emp;
select * from dept;
-- 1
select sal from emp where ename='JONES';
-- 2
select * from emp where sal>2975;
-- 3
select * from emp where sal>(select sal from emp where ename='JONES');
-- 4
select * from emp where hiredate <(select hiredate from emp where ename='SCOTT');
-- 5
select empno,ename,job,sal,d.* 
from emp natural join dept d  
where deptno=20 and sal > (select avg(sal) from emp)
order by sal desc;
-- 6
select * from emp where deptno in (20,30);
-- 7 
select max(sal)
from emp
group by deptno
order by deptno;
-- 8
select * from emp 
where sal in (select max(sal) from emp group by deptno);

-- 9
select * from emp 
where sal = any (select max(sal) from emp group by deptno);

-- 10
select * from emp 
where sal = some (select max(sal) from emp group by deptno);

-- 11
select sal from emp where deptno=30;

-- 12
select * from emp
where sal < all (select max(sal) from emp group by deptno)
order by sal;
select max(sal) from emp group by deptno;
select * from emp
where sal < any (select sal from emp where deptno=30)
order by sal;

-- 13
select * from emp
where sal > any (select sal from emp where deptno=30)
order by sal desc;

-- 14
select * from emp
where sal < all (select sal from emp where deptno=30);

-- 15
select * from emp
where sal > all (select sal from emp where deptno=30)
order by sal;

-- 16 exits 배우지 않아서...
select * from emp
where exists (select 1 from dept where deptno = 10);
select * from emp;





