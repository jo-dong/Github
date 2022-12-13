## 주석 --------------------------------------
	# 한 줄 주석
	-- 한 줄 주석 (하이픈과 문자 사이에 공백 필수)
	/* 
    여러 줄 주석
    */
# -------------------------------------------

## 1. DB 목록
show databases;

## 2. DB 선택
use mysql;

## 3. Table 목록
show tables;

## 4. user 테이블 조회
select * from user;

## 5. user 테이블 구조
desc user;			# describe == desc

## employees 추가 후 DB 목록 조회
show databases;

## employees DB 선택
use employees;

## table 목록 조회
show tables;

## employees table 구조
desc employees;
