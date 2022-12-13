## 1. DB 선택
use employees;

## 2. 사원의 성, 이름, 성별 조회
select first_name, last_name, gender
from employees;

## 3. 부서의 부서번호, 부서명 조회
select dept_no, dept_name 
from departments;

## 4. 사원의 사원번호, 연봉 조회
select emp_no, salary
from salaries;

## 5. 사원의 사원번호, 직책 조회
select emp_no, title
from titles;


## 산술 연산자 ###############################
select 10 + 10;
select 30 * 3, 20 - 2;

## 사원들의 연봉 계산
select salary, salary + 10 as "연봉 10달러 증가", salary * 10 '10년치 연봉'
from salaries
limit 20;

## [문제] 사원번호, 연봉, 10% 인상된 각 사원의 연봉 조회
select emp_no as '사원번호', salary as '연봉', salary * 1.1 as "10% 인상 연봉"
from salaries;

## 중복 제거 distinct : Row가 완전히 같아야 중복으로 인지하고 제거함
select distinct dept_no, to_date
from dept_emp;

/*
## where절 조건에서 사용하는 연산자 ###############################
비교 	  : =    <>    >     <    >=    <=			(<> : !=)
범위 	  : between A and B
집합 	  : In (여러 값) 	 - 소괄호 생략 불가
			not In (여러 값)  - 소괄호 생략 불가
패턴 	  : like - 같니?
		    not like
            와일드 카드 -  % : 모든,   _ : 한 글자 
null 	  : is null
			is not null
복합 조건 : and, or, not
*/

## d005 부서 매니저의 사원번호, 부서번호 조회
select emp_no as '사원번호', dept_no as '부서번호'
from dept_manager
where dept_no like 'd005';
# where dept_no = 'd005';

####################################################################

## [문제 1] d003 부서 소속(담당)이 아닌 매니저들의 사원번호, 부서번호 추출.
select dept_no, emp_no
from dept_manager
where dept_no not like 'd003';		# 문자열 비교 시 - not like
# where dept_no <> 'd003';			# 정수 비교 시 - <>

## [문제 2] 연봉이 150,000 이상인 사원들의 사원번호, 연봉 추출.
select emp_no, salary
from salaries
where salary >= 150000;

## [문제 3] 1986년 이후에 입사한 사원의 사원번호, 입사일, 이름 추출.
select emp_no, hire_date, first_name
from employees
where hire_date >= '1986-01-01';
# where year(hire_date) >= 1986;

## [문제 4] 1990년 이후부터 매니저로 근무하고 있는 사원들의 사원번호, 부서번호, 매니저 시작 날짜 추출.
select emp_no, dept_no, from_date
from dept_manager
where year(from_date) >= 1990;

## [문제 5] 1990년 이전 입사한 사원들의 사원번호, 입사일 추출.
select emp_no, hire_date
from employees
where year(hire_date) < 1990; 

####################################################################

## [문제 1] d001 부서 매니저 중 1990년 이후부터 매니저인 사원의 
## 			사원번호, 부서번호, 매니저 시작일 추출
select emp_no, dept_no, from_date
from dept_manager
where dept_no like 'd001' and from_date >= '1990-01-01';

## [문제 2] 1990년 이후 입사한 남자 사원의 사원번호, 성별, 입사일 추출
select emp_no, gender, hire_date
from employees
where gender like 'M' and hire_date >= '1990-01-01';

## [문제 3] 1990년 이후 연봉을 60,000 이상 받는 사원의 
## 			사원번호, 연봉, 시작 날짜 추출
select emp_no, salary, from_date
from salaries
where from_date >= '1990-01-01' and salary >= 60000;

## [문제 4] 1990년 이후 연봉을 60,000 ~ 70,000 받는 사원의 
## 			사원번호, 연봉, 시작 날짜 추출
select emp_no, salary, from_date
from salaries
where from_date >= '1990-01-01' 
	  and (salary between 60000 and 70000);

################################################################
## not 연산자 사용
## [문제] d003 부서 소속(담당)이 아닌 매니저들의 사원번호, 부서번호 추출.
select dept_no, emp_no
from dept_manager
where not dept_no like 'd003';

################################################################
## in 연산자
## [문제] d001 부서와 d002 부서 매니저의 사원번호, 부서번호 추출
select emp_no, dept_no
from dept_manager
where dept_no in('d001', 'd002');
# where dept_no like 'd001' or dept_no like 'd002';

################################################################
## like 연산자
# A로 시작하는 : 'A%'
# A로 끝나는 : '%A'
# A가 포함된 : '%A%'

## [문제 1] 성별이 남자인 사원의 사번, 이름, 성별 조회
select emp_no, first_name, gender
from employees
where binary gender like 'M';
# MySQL은 'm'해도 찾아줌 - 대, 소문자 구분 X
# binary를 넣으면 대, 소문자 구분

## -- 코드 블럭 지정 후, ctrl + shift + enter = 블럭 지정한 코드만 실행 --------------------------

## [문제 2] 이름이 G로 시작되는 사원의 사번, 이름 추출
select emp_no, first_name
from employees
where first_name like 'G%';

## [문제 3] 이름이 I로 끝나는 사원의 사번, 이름 추출
select emp_no, first_name
from employees
where first_name like '%I';

## [문제 4] 이름에 U가 포함되는 사원의 사번, 이름 추출
select emp_no, first_name
from employees
where first_name like '%U%';

## [문제 5] 이름의 두 번째 글자가 R인 사원의 사번, 이름 추출
## 단, 이름은 3글자
select emp_no, first_name
from employees
where first_name like '_R_';

################################################################
## is Null

## Null 값 입력 가능한 테이블이 column 검색
desc employees;
desc dept_manager;
desc departments;
desc dept_emp;
desc salaries;
desc titles;		## Field - to_date : Null 가능



