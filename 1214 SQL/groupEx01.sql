/*
## 그룹 함수 ######################################################
## 집계 함수 ######################################################
	count(컬럼명)	: Row 개수(Null은 세지 않음)
	sum(컬럼명)		: 합
	avg(컬럼명)		: 평균
	max(컬럼명)		: 최대값
	min(컬럼명)		: 최소값

select 		컬럼명, 컬럼명
from		테이블명
where		조건
group by	컬럼명, 컬럼명
having		조건			- group by를 하고난 결과의 조건
order by	컬럼명;
*/

## 사원 총 수
select count(emp_no) as '총 사원 수', count(*) as '총 사원 수'
from employees;

## 직책 테이블의 총 Row 수
select count(emp_no) as '총 사원 수', 
	   count(*) as '총 사원 수', 		# 특정 값이 null이어도 ㄱㅊ.
	   count(to_date) as '총 사원 수'	# 한 개가 null.
from titles;

######################################################################################
desc titles;

select *
from titles
where to_date is null;		# null 없음

select * from titles;		# target : 10002번 사원 --> to_date에 null 넣기

update titles
set to_date = null
where emp_no = 10002;

## 직원들의 급여 총 합, 최고, 최저
select sum(salary),		# 주의: 같은 사람의 salary가 여러 개임, 그래서 sum의 결과는 잘못됨
	   max(salary),
       min(salary)
from salaries;

###################################################################################
## 남과 여 직원 수
select gender, count(emp_no) as '성별 기준 사원 수'		# count() <- 괄호 안에 보통 PK를 많이 넣음
from employees
group by gender;

## 직책 별 직원 수
select title, count(emp_no) as '직책별 사원 수'
from titles
group by title;

## 직책 별 직원 수 -> 직원 수가 5만 이상인 직책만 조회
select title, count(emp_no) as '직책별 사원 수'
from titles
group by title
having count(emp_no) >= 50000;













