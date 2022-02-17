/*
create table course(
	id integer not null,
	name varchar(255) not null,
	primary key(id) 
);
*/
insert into course(id,name,created_date,last_updated_date) values (10001,'JPA in 50 steps',sysdate(),sysdate());
insert into course(id,name,created_date,last_updated_date) values (10002,'JPA in 100 steps',sysdate(),sysdate());

insert into student(id,name) values(20001,'Sankha');
insert into student(id,name) values(20002,'Adam');
insert into student(id,name) values(20003,'Jane');

insert into passport(id,number) values(40001,'E12345');
insert into passport(id,number) values(40002,'A12334');
insert into passport(id,number) values(40003,'M23122');