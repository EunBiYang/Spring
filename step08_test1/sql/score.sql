-- 1) 테이블 생성
create table score (
	studNo varchar2(30) primary key,  -- unique, not null 
	name varchar2(30) not null,
	kor number, 
	eng number, 
	mat number, 
	tot number,
	avg number(5, 1),
	logtime date
);
-- 2) 테이블 삭제
drop table score purge;
-- 3) 테이블 확인
select * from tab;

-- 4) 데이터 저장 (insert)
insert into score values ('2022001', '홍길동', 90,80,70,240,80.0, sysdate);

-- 5) 데이터 검색 (select)
select * from score order by studNo asc;
select * from score where studNo='2022001';

-- 6) 데이터 수정 (update)
update score set kor=95, eng=85, mat=75, tot=255, avg=85
where studNo='2022001';

-- 7) 데이터 삭제 (delete)
delete score where studNo='2022001';

-- 8) DB 저장
commit;