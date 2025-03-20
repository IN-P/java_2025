select*from select_emp;

select*from select_emp where job='SALESMAN';
select ename,mgr,sal from select_emp;
select ename,mgr,sal from select_emp where job='SALESMAN';
select*from select_emp order by sal desc;
select*from select_emp order by job asc, sal desc; -- 차순정리 동시에 사용법
select ename,sal,empno from select_emp where sal>=2000 order by empno desc;
select distinct job from select_emp; -- distinct 중복행제거
select empno `사원번호`,ename `이름`,job `담당 업무` from select_emp;
select*from select_emp order by sal asc;
select*from select_emp order by sal desc;
select*from select_emp order by deptno asc, sal desc;
select*from select_emp order by deptno desc, ename asc;

select*from emp;
select sum(sal)`급여합계` from emp; -- 1
select sum(comm)`추가수당` from emp; -- 2
select sum(distinct sal), sum(all sal), sum(sal) from emp; -- 3
select count(ename)`데이터갯수` from emp; -- 4
select count(deptno)`부서30 직원수` from emp group by deptno having deptno=30; -- 5
select count(distinct sal), count(all sal), count(sal) from emp; -- 6
select count(comm)`추가수당을받는 사원수` from emp; -- 7
select count(comm)`추가수당을받는 사원수` from emp where comm is not null; -- 8
select max(sal)`부서10 최대급여` from emp group by deptno having deptno=10; -- 9
select min(sal)`부서10 최소급여` from emp group by deptno having deptno=10; -- 10
select max(hiredate)`부서20 최근입사일` from emp group by deptno having deptno=20; -- 11
select min(hiredate)`부서20 제일오래 된 입사일` from emp group by deptno having deptno=20; -- 12
select avg(sal)`부서30 평균급여` from emp group by deptno having deptno=30; -- 13
select avg(distinct sal)`부서30 중복제거 평균급여` from emp group by deptno having deptno=30; -- 14
select deptno, avg(sal)`평균급여` from emp group by deptno order by deptno asc; -- 15
select deptno, job, avg(sal)`평균급여` from emp group by deptno,job order by deptno asc; -- 16
select deptno, job, avg(sal)`평균급여` from emp group by deptno,job having avg(sal)>=2000 order by deptno asc; -- 17
-- 18 
select deptno, job, avg(sal)
from emp 
where avg(sal)>=2000 
group by deptno,job 
order by deptno,job;
-- 그룹화 했을 경우 조건식은 where 가 아닌 having 을 사용해야한다.
-- order by 에서 asc, desc 를 붙이지 않으면 디폴트값은 asc 이다.
select deptno,job,avg(sal) from emp where sal<=3000 group by deptno,job having avg(sal)>=2000 order by deptno; -- 19
-- 20
select deptno,job,count(ename)`사원수`,max(sal)`최고급여`,sum(sal)`급여합`,avg(sal)`평균급여`
from emp
group by deptno,job
order by deptno,job;

