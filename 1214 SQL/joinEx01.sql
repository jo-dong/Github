## 수평 Join : from 절에 ,(콤마)로 구분

/* 2개의 쿼리문을 같이 블럭 지정 후 CTRL + SHIFT + ENTER : Result Grid 창에 탭이 2개가 됨 */

## 사원들의 사번(dept_emp), 근무 부서 번호(dept_emp), 근무부서명(departments) 조회
select emp_no as '사번', dept_no as '부서번호' 
from dept_emp;

select * 
from departments;

/* 위에 2개 Join (수평 Join)*/
select emp_no as '사번', dept_emp.dept_no as '부서번호', dept_name as '부서명'
from dept_emp, departments
where dept_emp.dept_no = departments.dept_no	# JOIN 조건(징검다리)
order by emp_no;

## 현재 재직 중인 사원 번호, 사원 이름, 연봉 조회 - 별칭 추가
select e.emp_no as '사원 번호', first_name as '사원 이름', salary as '연봉'
from employees e, salaries s
where e.emp_no = s.emp_no						# JOIN 조건
	  and s.to_date = '9999-01-01';				# 원하는 Data를 걸러내기 위한 조건









