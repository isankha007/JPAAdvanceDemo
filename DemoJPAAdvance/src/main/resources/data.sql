/*
create table course(
	id integer not null,
	name varchar(255) not null,
	primary key(id) 
);
*/
insert into course(id,name,created_date,last_updated_date) values (10001,'JPA in 50 steps',sysdate(),sysdate());
insert into course(id,name,created_date,last_updated_date) values (10002,'JPA in 100 steps',sysdate(),sysdate());



insert into passport(id,number) values(40001,'E12345');
insert into passport(id,number) values(40002,'A12334');
insert into passport(id,number) values(40003,'M23122');


insert into student(id,name,passport_id) values(20001,'Sankha',40001);
insert into student(id,name,passport_id) values(20002,'Adam',40002);
insert into student(id,name,passport_id) values(20003,'Jane',40003);




insert into review(id,rating,descriptions,course_id) values(50003,'5','some good desc',10001);
insert into review(id,rating,descriptions,course_id) values(50002,'5','some awesome desc',10001);
insert into review(id,rating,descriptions,course_id) values(50001,'5','some great desc',10002);


insert into student_course(student_id,course_id) values(20001,10001);
insert into student_course(student_id,course_id) values(20002,10001);
insert into student_course(student_id,course_id) values(20003,10001);
insert into student_course(student_id,course_id) values(20001,10002);