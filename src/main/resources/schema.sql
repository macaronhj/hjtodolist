CREATE TABLE MEMBER (
    memberSeq number(10) CONSTRAINT ms_code_pk PRIMARY KEY,
    email VARCHAR2(80) NOT NULL, /* 이메일 */
    name VARCHAR2(50) NOT NULL, /* 이름 */
    pwd VARCHAR2(30) NOT NULL /* 비밀번호 */
);
CREATE TABLE todolist(
      seq number(10) CONSTRAINT s_code_pk PRIMARY KEY,
      category varchar(100) CONSTRAINT category_nn not null,
      todo varchar(100) CONSTRAINT todo_nn not null,
      create date NOT NULL DEFAULT CURRENT_TIMESTAMP(),
      startdate varchar(50) NOT NULL,
      deadline varchar(50) NOT NULL,
      memberSeq number(10) CONSTRAINT ms_fk REFERENCES MEMBER ON DELETE CASCADE
);

CREATE SEQUENCE seq INCREMENT by 1 start with 1 nocache;
CREATE SEQUENCE memberSeq INCREMENT by 1 start with 1 nocache;

INSERT INTO MEMBER VALUES(memberSeq.NEXTVAL,'heejin','heejin249@naver.com','1111');
INSERT INTO MEMBER VALUES(memberSeq.NEXTVAL,'hanyoung','hanyoung123@naver.com','2222');

INSERT INTO todolist VALUES(seq.NEXTVAL,'집 청소','화장실 청소하기',now(),'01/01/2022','01/01/2022',1);
INSERT INTO todolist VALUES(seq.NEXTVAL,'공부','백준 코테 하기',now(),'01/01/2022','01/01/2022',1);
INSERT INTO todolist VALUES(seq.NEXTVAL,'장보기','계란, 우유 사기',now(),'01/01/2022','01/01/2022',1);
INSERT INTO todolist VALUES(seq.NEXTVAL,'행사','사촌언니 결혼식 가기',now(),'01/01/2022','01/01/2022',2);
INSERT INTO todolist VALUES(seq.NEXTVAL,'집 청소','고양이 배변통 정리하기',now(),'01/01/2022','01/01/2022',2);
INSERT INTO todolist VALUES(seq.NEXTVAL,'취업','노션에 포폴 정리해놓기',now(),'01/01/2022','01/01/2022',2);

