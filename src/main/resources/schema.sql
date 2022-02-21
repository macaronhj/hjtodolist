CREATE TABLE MEMBER (
    memberSeq number(10) CONSTRAINT ms_code_pk PRIMARY KEY,
    email VARCHAR2(80) NOT NULL, /* 이메일 */
    name VARCHAR2(50) NOT NULL, /* 이름 */
    pwd VARCHAR2(30) NOT NULL /* 비밀번호 */
);
CREATE TABLE todolist(
      seq number(10) CONSTRAINT s_code_pk PRIMARY KEY,
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

INSERT INTO todolist VALUES(seq.NEXTVAL,'운동하기',now(),'01/01/2022','01/01/2022',1);
INSERT INTO todolist VALUES(seq.NEXTVAL,'넷플릭스 보기',now(),'01/01/2022','01/01/2022',1);
INSERT INTO todolist VALUES(seq.NEXTVAL,'음악 듣기',now(),'01/01/2022','01/01/2022',1);
INSERT INTO todolist VALUES(seq.NEXTVAL,'결혼식 가기',now(),'01/01/2022','01/01/2022',2);
INSERT INTO todolist VALUES(seq.NEXTVAL,'자바 공부하기',now(),'01/01/2022','01/01/2022',2);
INSERT INTO todolist VALUES(seq.NEXTVAL,'스프링 공부하기',now(),'01/01/2022','01/01/2022',2);

