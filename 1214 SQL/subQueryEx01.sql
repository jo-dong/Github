## Sub Query : Query문 내에 있는 Query문

## d001 부서에 근무하고 있는 사원들의 사원번호와 first_name 조회
## 1)
select emp_no, first_name
from employees;

## 2)
select dept_no, emp_no
from dept_emp
where dept_no like 'd001';

## 3) subQuery
select emp_no as '사번', first_name as '이름'
from employees
where emp_no in(select emp_no from dept_emp where dept_no like 'd001');
#      얘                얘  -> 일치시켜야 함

## 4) join
select e.emp_no as '사번', first_name as '이름'
from employees e, dept_emp d
where e.emp_no = d.emp_no
	  and d.dept_no like 'd001';