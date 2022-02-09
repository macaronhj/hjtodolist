CREATE TABLE todolist(
      seq number(10) CONSTRAINT s_code_pk PRIMARY KEY,
      todo varchar(100) CONSTRAINT todo_nn not null,
      create date NOT NULL DEFAULT CURRENT_TIMESTAMP(),
      startdate varchar(50) NOT NULL,
      deadline varchar(50) NOT NULL
);

CREATE SEQUENCE seq INCREMENT by 1 start with 1 nocache;

INSERT INTO todolist VALUES(seq.NEXTVAL,'운동하기',now(),'01/01/2022','01/01/2022');
INSERT INTO todolist VALUES(seq.NEXTVAL,'넷플릭스 보기',now(),'01/01/2022','01/01/2022');
INSERT INTO todolist VALUES(seq.NEXTVAL,'음악 듣기',now(),'01/01/2022','01/01/2022');
INSERT INTO todolist VALUES(seq.NEXTVAL,'결혼식 가기',now(),'01/01/2022','01/01/2022');
INSERT INTO todolist VALUES(seq.NEXTVAL,'자바 공부하기',now(),'01/01/2022','01/01/2022');
INSERT INTO todolist VALUES(seq.NEXTVAL,'스프링 공부하기',now(),'01/01/2022','01/01/2022');

