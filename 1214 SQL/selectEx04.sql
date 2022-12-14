## 1. DB 선택
use employees;

## [정렬] ####################################################
## 정렬은 숫자, 문자열, 날짜 등 데이터 상관 없이 가능
## (Syntax)
## order by 칼럼명 asc 		: 오름차순, asc 생략 가능(default = asc)
## order by 칼럼명 desc 	: 내림차순, desc는 생략 불가

## cf) 테이블 정보
desc dept_emp;

## [문제 1] 직책을 오름차순, 시작일을 내림차순으로 하여 사원번호, 직책, 시작일, 종료일 조회
select *
from titles
order by title, from_date desc;

## [함수] ####################################################
## << 숫자 >>
## 절대값
select abs(100), abs(-100);

## 소수점 이하 올림
select ceil(10.4), ceil(10.5), ceil(10.6);

## 소수점 이하 내림
select floor(10.4), floor(10.5), floor(10.6);

## 반올림
select round(10.4), round(10.5), round(10.6);
# 소수점 자리수 정하기
select round(166.555, 0), round(166.555, 1), round(166.555, -1);

## 버림
select truncate(166.555, 0), truncate(166.555, 1), truncate(166.555, -1);

## x의 y 제곱
select power(5, 2);

## 나머지
select mod(5, 2);

## 큰 값 - 괄호 안에 column 명 넣어서 계산 가능
select greatest(3, 10, 5, 20);

## 작은 값
select least(3, 10, 5, 20);

## [문자열 함수] ############################################
## 이어주기
select concat('one', ' two');

select concat(first_name, '님') 'Name', concat('성별 : ', gender) 'Gender'
from employees;

## 특정 위치에 추가 : insert(기존문자열, 변경위치, 변경개수, 변경할문자열)
# ex1) : 첫번째 인수의 2번재 자리부터 1개를 *로 변경
select insert('abcdefg', 2, 1, '*');
# ex2) : 첫번째 인수의 2번재 자리부터 0개를 *로 변경
select insert('abcdefg', 2, 0, '*');

## 교체 : replace()
select replace('abcdefg', 'bc', 'ONE');

## 위치 : instr(문자열1, 문자열2)
# 문자열1에서 문자열 2를 찾아 위치 반환
# 왼쪽 기준으로 1부터 시작하여, 없으면 0 반환
select instr('abcdefg', 'b');
select instr('abcdefg', 'z');

## [문제] bcd를 삭제하시오.
select insert('abcdefg', 2, 2, '');

## 문자열 반환
## left(문자열, 개수) : 문자열에서 왼쪽 기준으로 개수만큼 반환
## right(문자열, 개수)
## mid(문자열, 위치, 개수)
select left('abcdefg', 3), right('abcdefg', 3), mid('abcdefg', 3, 2);

## substring(문자열, 위치, 개수) : mid와 같다.
select substring('abcdefg', 3);
select mid('abcdefg', 3);

## 공백 제거
## ltrim(문자열), rtrim(문자열), trim(문자열)
# 공백 확인 위해 concat 사용
select concat('|', ltrim('   abc   '), '|') as 'ltrim', 
	   concat('|', rtrim('   abc   '), '|') as 'rtrim',
	   concat('|', trim('   abc   '), '|') as 'trim';
       
## 대문자 변경 : ucase(문자열)
## 소문자 변경 : lcase(문자열)
select ucase('aBcDe') as 'ucase', 
	   lcase('aBcDe') as 'lcase';

## 역순
select reverse('aBcDe') as 'reverse';

## 문자열 길이 - length(문자열)
select dept_name, length(dept_name) as 'length'
from departments;

## 날짜 함수 ##################################################
## 날짜와 시간
select now(), sysdate();

## 현재 날짜
select current_date(), curdate();	# 이 두 개의 함수는 같은 함수

## 현재 시간
select current_time(), curtime();

## 현재 날짜에 더한 값
## date_add(날짜, interval 값 기준) : 날짜에서 interval만큼 더한 날짜 리턴
## interval : year, month, day, hour, minute, second

## 오늘 기준으로 100(일, 개월, 년) 뒤 날짜?
select now(), date_add(now(), interval 100 day) as '100일 후',
	   date_add(now(), interval 100 month) as '100개월 후',
	   date_add(now(), interval 100 year) as '100년 후';

## 오늘 기준으로 100일 전 날짜?
select now(), date_sub(now(), interval 100 day) as '100일 전';

## 발령 7일 전
select hire_date, date_sub(hire_date, interval 7 day) as '발령 7일 전'
from employees;

## 날짜 함수
## 년, 월, 일, 시, 분, 초
select now(), year(now()), month(now()), day(now());
select now(), hour(now()), minute(now()), second(now());

## 입사년도
select hire_date, year(hire_date) as '입사년도', 
				  month(hire_date) as '입사월',
                  day(hire_date) as '입사일'
from employees;

## 월을 영어로
select now(), monthname(now());

## 요일을 숫자로 : 일요일 = 1, 월요일 = 2, ... , 토요일 = 7
select now(), dayofweek(now());

## 요일을 숫자로 : 월요일 = 0, 화요일 = 1, ... , 일요일 = 6
select now(), weekday(now());

## 일년을 기준으로 일 수 : dayofyear(날짜)
select now(), dayofyear(now());

## 일년을 기준으로 몇 번째 주 : week(날짜)
select now(), week(now());

## 형식 지정
select now(), date_format(now(), '%Y년 %m월 %d일 %H시 %i분 %s초') as '형식';





















