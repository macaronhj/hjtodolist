create table COSMETIC(
                         SEQ NUMBER(10) constraint C_CODE_PK primary key,
                         NAME VARCHAR2(14),
                         COUNT NUMBER(4),
                         COMPANY  VARCHAR2(14),
                         SALE NUMBER(10)
);

create table STORE(
                      S_SEQ NUMBER(10) constraint S_CODE_PK primary key,
                      NAME VARCHAR2(20) constraint SNAME_NN not null,
                      LOCATION VARCHAR2(30) constraint SNAME_NN not null,
                      CREATE_AT datetime NOT NULL DEFAULT CURRENT_TIMESTAMP()
);

create sequence SEQ increment by 1 start with 1 nocache;
create sequence S_SEQ increment by 1 start with 1 nocache;

insert into cosmetic values(SEQ.NEXTVAL,'TULIP',30,'아모레',12000);
insert into cosmetic values(SEQ.NEXTVAL,'ROSE',48,'아모레',24000);
insert into cosmetic values(SEQ.NEXTVAL,'SKY',491,'LG',32000);
insert into cosmetic values(SEQ.NEXTVAL,'PPIPPI',30,'COCO',9800);
insert into cosmetic values(SEQ.NEXTVAL,'DAISY',20,'아모레',51000);
insert into cosmetic values(SEQ.NEXTVAL,'SUNFLOWER',50,'LG',30000);
insert into cosmetic values(SEQ.NEXTVAL,'KOOKOO',0,'COCO',43000);
insert into cosmetic values(SEQ.NEXTVAL,'CHU',1,'LG',54000);
insert into cosmetic values(SEQ.NEXTVAL,'RURU',8,'KOSMO',18000);
insert into cosmetic values(SEQ.NEXTVAL,'LILY',320,'아모레',21000);

insert into STORE values(S_SEQ.NEXTVAL,'에뛰드','가산점',now());
insert into STORE values(S_SEQ.NEXTVAL,'맥','문정점',now());
insert into STORE values(S_SEQ.NEXTVAL,'클리오','잠실점',now());
