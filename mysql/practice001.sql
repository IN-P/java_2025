use mbasic;
show tables;
desc emp;
select*from emp;
create table select_emp like emp;
insert into select_emp select*from emp;
desc select_emp;
select*from select_emp; -- 실습1
select*from select_emp where deptno=30; -- 실습2
select*from select_emp where deptno=30 and job='SALESMAN'; -- 실습3
select*from select_emp where deptno=30 or job='CLERK'; -- 실습4
select*from select_emp where sal*12=36000; -- 실습5
select*from select_emp where sal>=3000; -- 실습6
select*from select_emp where ename>='F'; -- 실습7
select*from select_emp where ename<='FORD'; -- 실습8
select*from select_emp where sal!=3000; -- 실습9
select*from select_emp where sal<>3000; -- 실습10
select*from select_emp where not sal=3000; -- 실습11
select*from select_emp where job='MANAGER' or job='SALESMAN' or job='CLERK'; -- 실습12
select*from select_emp where job in ('MANAGER','SALESMAN','CLERK'); -- 실습13
select*from select_emp where job!='MANAGER' and job<>'SALESMAN' and not job='CLERK'; -- 실습14
select*from select_emp where job not in ('MANAGER','SALESMAN','CLERK'); -- 실습15
select*from select_emp where sal>=2000 and sal<=3000; -- 실습16
select*from select_emp where sal between 2000 and 3000; -- 실습17
select*from select_emp where sal not between 2000 and 3000; -- 실습18
select*from select_emp where not (sal>=2000 and sal<=3000); -- 실습19
select*from select_emp where empno=7499 and deptno=30; -- 실습20
select*from select_emp where job='SALESMAN' or deptno=20; -- 실습21
select*from select_emp where job='ANALYST' and sal>=2500; -- 실습22
select*from select_emp where deptno=10 or deptno=20; -- 실습23
select*from select_emp where deptno not in (10,20); -- 실습24
select*from select_emp where ename like 'S%'; -- 실습25
select*from select_emp where ename like '_L%'; -- 실습26
select*from select_emp where ename like '%AM%'; -- 실습27
select*from select_emp where ename not like '%AM%'; -- 실습28
select ename as `사원이름`, sal `급여`, sal*12+comm `연봉`, comm `커미션` from select_emp where ename like '%AM%'; -- 실습29
select*from select_emp where comm=null; -- 실습30
select*from select_emp where comm is null; -- 실습31
select*from select_emp where mgr is not null; -- 실습32
select*from select_emp where sal > null; -- 실습33
select*from select_emp where sal > null or comm is null; -- 실습34
select*from select_emp where ename like '%S'; -- 실습35
select empno,ename,job,sal,deptno from select_emp where deptno=30 and job='SALESMAN'; -- 실습36
select empno,ename,job,sal,deptno from select_emp where deptno in (20,30) and sal>2000; -- 실습37
select*from select_emp where sal<2000 or sal>3000; -- 실습38
select ename,empno,sal,deptno from select_emp where (deptno=30 and ename like '%E%') and sal not between 1000 and 2000; -- 실습39
select*from select_emp where comm is null and mgr is not null and job in ('MANAGER','CLERK') and ename not like '_L%'; -- 실습40



