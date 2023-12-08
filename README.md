# 개발자 검색/등록/수정/삭제 웹서비스
## 개발 목적
```
SI업체 관리자의 입장에서 조건에 맞는 개발자를 검색/등록/수정/삭제할 수 있게 페이징 처리를 적용한 웹 서비스 제공
```
## 검색
![검색초기화면0](https://github.com/jeonjibeom/SearchDeveloper/assets/93521256/7ef9d31f-9485-44ae-8ccc-736c7bb56720)
## 등록
![등록](https://github.com/jeonjibeom/SearchDeveloper/assets/93521256/54e88fcc-eb49-4786-8912-f912686fb9cd)
## 수정/삭제
![수정삭제](https://github.com/jeonjibeom/SearchDeveloper/assets/93521256/e3c2faed-e87e-4765-b30c-b67e26d21788)

## 사전 Oracle 작업
```
1
create table code_skill (
	skill_code      number(3),
	skill_name     varchar2(20)    not null unique,
	primary key(skill_code)
);
1
create table code_religion (
	religion_code      number(3),
	religion_name      varchar2(20)    not null unique,
	primary key(religion_code)
);
1
create table code_school (
	school_code      number(3),
	school_name   varchar2(20)    not null unique,
	primary key(school_code)
);
2
create table developer (
	developer_no        number(3),
	developer_name     varchar2(14)    not null,
	jumin_no       char(14)       not null unique,
	school_code   number(3)      not null,
	religion_code   number(3)     not null,
	graduate_day   char(10)       not null,
	foreign key(religion_code) references code_religion(religion_code),
	foreign key(school_code) references code_school(school_code),
	primary key(developer_no)
);
create sequence developer_seq start with 1 increment by 1
3
create table developer_skill (
	developer_skill_no      number(3),
	developer_no     number(3)    not null,
	skill_code   number(3)    not null,
	primary key(developer_skill_no),
	foreign key(developer_no) references developer(developer_no),
	foreign key(skill_code) references code_skill(skill_code)
);
4
insert into code_skill(skill_code,skill_name) values(  (select nvl(max(skill_code),0)+1 from code_skill), 'Java' );
insert into code_skill(skill_code,skill_name) values(  (select nvl(max(skill_code),0)+1 from code_skill), 'JSP' );
insert into code_skill(skill_code,skill_name) values(  (select nvl(max(skill_code),0)+1 from code_skill), 'ASP' );
insert into code_skill(skill_code,skill_name) values(  (select nvl(max(skill_code),0)+1 from code_skill), 'PHP' );
insert into code_skill(skill_code,skill_name) values(  (select nvl(max(skill_code),0)+1 from code_skill), 'Delphi' );

insert into code_religion(religion_code,religion_name) values( (select nvl(max(religion_code),0)+1 from code_religion), '기독교' );
insert into code_religion(religion_code,religion_name) values( (select nvl(max(religion_code),0)+1 from code_religion), '천주교' );
insert into code_religion(religion_code,religion_name) values( (select nvl(max(religion_code),0)+1 from code_religion), '불교' );
insert into code_religion(religion_code,religion_name) values( (select nvl(max(religion_code),0)+1 from code_religion), '이슬람' );
insert into code_religion(religion_code,religion_name) values( (select nvl(max(religion_code),0)+1 from code_religion), '무교' );
insert into code_school(school_code,school_name) values( (select nvl(max(school_code),0)+1 from code_school), '고졸' );
insert into code_school(school_code,school_name) values( (select nvl(max(school_code),0)+1 from code_school), '전문대졸' );
insert into code_school(school_code,school_name) values( (select nvl(max(school_code),0)+1 from code_school), '일반대졸' );
```

# 본 프로젝트는 데이터 베이스 연습과 검색/수정/삭제/등록 연습에 포커스를 맞추어 제작한 프로그램입니다.
