/* Q1) MOVIE DATABASE 생성 */

/* Q2) 아래 ERD와 테이블 정보를 참고하여 MOVIE 데이터베이스에 3개의 테이블 생성 */

-- FILM_ACTOR TABLE 생성
DROP TABLE FILM_ACTOR;

CREATE TABLE FILM_ACTOR(
        ACTOR_ID NUMBER(4) CONSTRAINT ACTOR_ID_FK
                           REFERENCES ACTOR(ACTOR_ID),
        FILM_ID NUMBER(4) CONSTRAINT FILM_ID_FK
                          REFERENCES FILM(FILM_ID)
        );
        
-- FILM TABLE 생성
DROP TABLE FILM;

CREATE TABLE FILM(
        FILM_ID NUMBER(4) PRIMARY KEY,
        TITLE VARCHAR2(255),
        DESCRIPTION VARCHAR2(100),
        RELEASE_YEAR DATE,
        PRODUCTION_COMPANY VARCHAR2(100)
        );
        
-- ACTOR TABLE 생성
DROP TABLE ACTOR;
 
CREATE TABLE ACTOR(
        ACTOR_ID NUMBER(4) PRIMARY KEY,
        NAME VARCHAR2(45),
        BIRTH_DATE DATE
        );
        
DESC FILM_ACTOR;
DESC FILM;
DESC ACTOR;

/* Q3) 아래 테이블 그림을 참고하여 테이블에 데이터 추가 */

-- FILM_ACTOR TABLE
INSERT INTO FILM_ACTOR VALUES(2, 1001);
INSERT INTO FILM_ACTOR VALUES(3, 1001);
INSERT INTO FILM_ACTOR VALUES(2, 1002);
INSERT INTO FILM_ACTOR VALUES(5, 1002);
INSERT INTO FILM_ACTOR VALUES(2, 1003);
INSERT INTO FILM_ACTOR VALUES(4, 1003);
INSERT INTO FILM_ACTOR VALUES(1, 1004);
INSERT INTO FILM_ACTOR VALUES(2, 1004);
INSERT INTO FILM_ACTOR VALUES(2, 1005);
INSERT INTO FILM_ACTOR VALUES(4, 1005);
INSERT INTO FILM_ACTOR VALUES(6, 1006);

SELECT *
FROM FILM_ACTOR;

-- FILM TABLE
INSERT INTO FILM VALUES(1001, '초록물고기', '이창동 감독의 데뷔작', TO_DATE(1997, 'YYYY'), '이스트필름');
INSERT INTO FILM VALUES(1002, '접속', 'PC 통신을 통해 신청자에게 접속하면서 생기는 로맨스', TO_DATE(1997, 'YYYY'), '명필름');
INSERT INTO FILM VALUES(1003, '8월의 크리스마스', '허진호 감독의 데뷔작', TO_DATE(1998, 'YYYY'), '우노필름');
INSERT INTO FILM VALUES(1004, '쉬리', '국내 첩보 액션 스릴러 영화', TO_DATE(1999, 'YYYY'), '(주)강제규필름');
INSERT INTO FILM VALUES(1005, '텔미썸띵', '이승현 감독의 멜로 영화', TO_DATE(1999, 'YYYY'), '쿠앤씨필름');
INSERT INTO FILM VALUES(1006, '시월애', '이승현 감독의 멜로 영화', TO_DATE(2000, 'YYYY'), '싸이더스');

SELECT FILM_ID, TITLE, DESCRIPTION, TO_CHAR(RELEASE_YEAR, 'YYYY') AS "RELEASE_YEAR", PRODUCTION_COMPANY
FROM FILM;

-- ACTOR TABLE
INSERT INTO ACTOR VALUES(1, '송강호', TO_DATE('1967-01-17', 'YYYY-MM-DD'));
INSERT INTO ACTOR VALUES(2, '한석규', TO_DATE('1964-11-03', 'YYYY-MM-DD'));
INSERT INTO ACTOR VALUES(3, '문성근', TO_DATE('1953-05-28', 'YYYY-MM-DD'));
INSERT INTO ACTOR VALUES(4, '심은하', TO_DATE('1972-09-23', 'YYYY-MM-DD'));
INSERT INTO ACTOR VALUES(5, '전도연', TO_DATE('1973-02-11', 'YYYY-MM-DD'));
INSERT INTO ACTOR VALUES(6, '이정재', TO_DATE('1981-10-30', 'YYYY-MM-DD'));

SELECT ACTOR_ID, NAME, TO_CHAR(BIRTH_DATE, 'YYYY-MM-DD') AS "BIRTH_DATE"
FROM ACTOR;

--------------------------------------------

/* Q4) 1999년 이후에 제작된 영화 수를 조회 */
SELECT COUNT(RELEASE_YEAR) AS "99년 이후 제작된 영화"
FROM FILM
WHERE RELEASE_YEAR >= TO_DATE(1999, 'YYYY');


/* Q5) 1999년에 개봉된 영화 조회 */
SELECT TITLE AS "1999년 개봉 영화"
FROM FILM
WHERE RELEASE_YEAR = TO_DATE(1999, 'YYYY');


/* Q6) 쉬리에 출연한 배우 이름을 조회하시오. (JOIN OR SUBQUERY 이용) */
SELECT NAME AS "쉬리 출연 배우"
FROM ACTOR
WHERE ACTOR_ID IN
(SELECT ACTOR_ID
FROM FILM_ACTOR
WHERE FILM_ID = 1004);


/* Q7) 한석규 배우가 출연한 영화 수를 조회하시오 */
SELECT COUNT(ACTOR_ID) AS "한석규 배우 영화수"
FROM FILM_ACTOR
WHERE ACTOR_ID = 2;


/* Q8) 1970년대에 태어난 배우 이름과 생년월일 조회 */
SELECT NAME AS "이름", BIRTH_DATE AS "생년월일"
FROM ACTOR
WHERE (TO_DATE(1970, 'YYYY') < BIRTH_DATE)
AND (BIRTH_DATE < TO_DATE(1980, 'YYYY'));
