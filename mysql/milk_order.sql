use mbasic;
desc milk_order;
create table milk_order (
ono int not null primary key auto_increment,
oname varchar(20) not null,
onum int not null,
odate datetime default now(), -- current_timestamp 대신에 now() 사용가능 
oip varchar(100) not null
); 
 
select*from milk_order;
-- Q1.  milk_order 값삽입.  insert 구문 완성    (oname, onum, oip)     'white' , 2,  '127.0.0.1'
insert into milk_order (oname,onum,oip) values ('white',2,'127.0.0.1');
-- Q2.  milk_order no가 1인데이터 조회 
select*from milk_order where ono=1;
-- Q3.  milk_order 전체데이터조회
select*from milk_order;
-- Q4.  milk_order 해당번호의 이름과 갯수 수정
update milk_order set oname='choco', onum=1 where ono=1;
-- Q5.  milk_order 해당번호의 데이터 삭제
delete from milk_order where ono=1;
