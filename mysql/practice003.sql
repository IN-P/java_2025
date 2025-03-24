-- 1
select * from emp;
select * from dept;
select * from emp, dept order by empno; 
## 연결하는 조건문 ex) using(deptno) 없다면 각테이블 행이 경우마다 다 나옴

-- 2
select * from emp join dept using(deptno) order by empno;

-- 3
select E.*,D.* from emp E join dept D where E.deptno = D.deptno order by empno;

-- 4
select empno, ename, deptno, danme, loc
from emp e, dept d
where e.deptno = d.deptno;
## select empno, ename, deptno, danme, loc 누구의 테이블인지 명시하지 않았기 때문에

-- 5
select e.empno, e.ename, e.deptno, d.dname, d.loc
from emp e, dept d
where e.deptno = d.deptno;

-- 6
select e.empno, e.ename, e.sal, e.deptno, d.dname, d.loc
from emp e join dept d on e.deptno = d.deptno  
where sal>=3000;

select empno, ename, sal, e.deptno, dname, loc
from emp e , dept d
where e.deptno = d.deptno and sal>=3000;

select empno, ename, sal, e.deptno, dname, loc
from emp e join dept d on  e.deptno = d.deptno
where sal>=3000;

select empno, ename, sal, e.deptno, dname, loc
from emp e join dept d using(deptno) 
where sal>=3000;

select empno, ename, sal, e.deptno, dname, loc
from emp e natural join dept d 
where sal>=3000;

-- 7
select * from salgrade;
select e.*, s.*
from emp e join salgrade s on e.sal between s.losal and s.hisal
order by grade, sal;

-- 8
select e1.empno, e1.ename, e1.mgr, e2.empno`mgr_empno`, e2.ename`mgr_ename`
from emp e1 join emp e2 on e1.mgr = e2.empno 
join salgrade s on e1.sal between s.losal and s.hisal
order by e1.mgr;

select e1.empno, e1.ename, e1.mgr, e2.empno`mgr_empno`, e2.ename`mgr_ename`
from emp e1, emp e2, salgrade s 
where e1.mgr = e2.empno and e1.sal between s.losal and s.hisal
order by e2.empno;

-- 9
select e1.empno, e1.ename, e1.mgr, e2.empno`mgr_empno`, e2.ename`mgr_ename`
from emp e1 left join emp e2 on e1.mgr = e2.empno 
order by e1.empno;

-- 10
select e1.empno, e1.ename, e1.mgr, e2.empno`mgr_empno`, e2.ename`mgr_ename`
from emp e1 right join emp e2 on e1.mgr = e2.empno 
order by e1.empno,e2.empno;

-- 11
select *
from emp natural join dept 
order by deptno;

-- 12
select empno,ename,job,mgr,hiredate,sal,comm,deptno,dname,loc
from emp join dept using(deptno)
where sal>=3000 
order by deptno;

-- 13
select empno,ename,job,mgr,hiredate,sal,comm,e.deptno,dname,loc
from emp e join dept d on e.deptno = d.deptno
where sal<3000 
order by deptno;

-- 14
select e.deptno,dname,empno,ename,sal
from emp e , dept d  
where e.deptno = d.deptno and sal>2000 
order by empno;

-- 15
select deptno,dname,empno,ename,sal
from emp natural join dept  
where sal>2000 
order by empno;

-- 16
select deptno,dname,avg(sal)`AVG_SAL`,max(sal)`MAX_SAL`,min(sal)`MIN_SAL`,count(*)`CNT`
from emp natural join dept
group by deptno   
order by deptno;

-- 17
select deptno,dname,avg(sal)`AVG_SAL`,max(sal)`MAX_SAL`,min(sal)`MIN_SAL`,count(*)`CNT`
from emp join dept using(deptno)
group by deptno   
order by deptno;

-- 18
select deptno,dname,empno,ename,job,sal
from dept left join emp using(deptno) 
order by deptno,ename;

-- 19
select deptno,dname,empno,ename,job,sal
from emp right join dept using(deptno) 
order by deptno,ename;

-- 20
select d.deptno, dname, e1.empno, e1.ename, e1.mgr, e1.sal ,e1.deptno, losal, hisal, grade, e2.empno`MGR_MEPNO`, e2.ename`MGR_ENAME`
from dept d natural left join emp e1
left join salgrade s on e1.sal between s.losal and s.hisal
left join emp e2 on e1.mgr = e2.empno
order by d.deptno,e1.empno;