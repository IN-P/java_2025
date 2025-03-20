use mbasic;

create table select_userinfo like userinfo;
insert into select_userinfo select*from userinfo;

## ■ 1. order by + limit
/*
select 필드1, 필드2
from 테이블명
where 조건식(필터)
order by 기준필드 [asc(1,2,3 오름차순) || desc(3,2,1 내림차순)]
limit 몇개
*/

-- 1-2. 정렬
select*from select_userinfo;
select*from select_userinfo order by age desc; -- 내림
select*from select_userinfo order by age asc;  -- 오름
-- 나이많은 3명
select*from select_userinfo order by age desc limit 3;
-- no가 높은순으로 4명
select*from select_userinfo order by no desc limit 4;
-- no 두번째로 높은 순으로 2명 limit 어디서부터, 몇개
select*from select_userinfo order by no desc limit 0,2;
select*from select_userinfo order by no desc limit 1,2;



-- 2-1 테이블 준비
create table group_userinfo(
no int not null auto_increment primary key,
name varchar(20) not null,
age int not null,
sex char(2),
kor int,
eng int,
math int,
ban char(2),
sns char(2) default 'y' -- default 값 추가 하는 방법
);
desc group_userinfo;
insert into group_userinfo (name,age,sex,kor,eng,math,ban,sns) values ('sixth',66,'m',10,20,44,'C','n');
select*from group_userinfo;

-- 2-2 기본
select @@sql_mode; 
set SESSION sql_mode='STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';
select*from group_userinfo group by ban;
-- 반별로 묶어서 보여질때 이름이나 나이 점수 등이 누구로 올라와야하는지 오류가남 그래서 설정 건드림

/*  
select   필드1, 필드2
from     테이블명
where    조건식 
group by 그풉핑
having 조건식
order by 기준필드  [asc(1,2,3오름차순) | desc(3,2,1 내림차순)]
limit    몇개

avg(컬럼명) 평균, max 최대값, min 최소값, sum 합계, count 갯수
*/

-- 나이평균
select avg(age) from group_userinfo;

-- 반별 몇명있는지
select ban, count(*) from group_userinfo group by ban;

-- 반별 국, 영, 수의 총점 확인
select ban, sum(kor) `국어총합`, sum(eng) `영어총합`, sum(math)`수학총합`
from group_userinfo
group by ban;

-- 반별 국, 영, 수의 평균확인
select ban, avg(kor), avg(eng), avg(math) from group_userinfo group by ban;
-- 반별 나이의 총합과 나이 평균확인
select ban, sum(age), avg(age) from group_userinfo group by ban;
-- 반별 국영수의 평균 확인후 '국어' 평균점수가 89이상인 데이터만 고르기
select ban, avg(kor), avg(eng), avg(math) from group_userinfo group by ban having avg(kor)>=89;
-- 반별 나이의 총합과 나이 평균 확인후 그중에서 나이의 평균이 35세 이상인 데이터 추출
select ban, sum(age), avg(age) from group_userinfo group by ban having avg(age)>=35;
-- 반별 나이의 총합과 나이 평균 확인후 그중에서 나이의 평균이 35세 이상인 데이터 추출후 평균나이의 내림차순으로 정렬
select ban, sum(age), avg(age) from group_userinfo group by ban having avg(age)>=35 order by avg(age) desc;