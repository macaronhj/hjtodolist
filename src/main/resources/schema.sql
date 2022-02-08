create table TODOLIST(
      SEQ NUMBER(10) constraint S_CODE_PK primary key,
      TODO VARCHAR2(100) constraint TODO_NN not null,
      CREATE date NOT NULL DEFAULT CURRENT_TIMESTAMP(),
      DEADLINE VARCHAR2(50) NOT NULL
);

create sequence SEQ increment by 1 start with 1 nocache;

insert into TODOLIST values(SEQ.NEXTVAL,'운동하기',now(),'01/01/2022');
insert into TODOLIST values(SEQ.NEXTVAL,'넷플릭스 보기',now(),'01/01/2022');
insert into TODOLIST values(SEQ.NEXTVAL,'음악 듣기',now(),'01/01/2022');
insert into TODOLIST values(SEQ.NEXTVAL,'결혼식 가기',now(),'01/01/2022');
insert into TODOLIST values(SEQ.NEXTVAL,'자바 공부하기',now(),'01/01/2022');
insert into TODOLIST values(SEQ.NEXTVAL,'스프링 공부하기',now(),'01/01/2022');

