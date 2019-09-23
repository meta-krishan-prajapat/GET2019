drop database student;
create database student;

use student;

create table students(
id int auto_increment,
first_name varchar(100),
last_name varchar(100),
father_name varchar(100),
email varchar(200),
class int,
age int,
unique(email),
primary key(id)
);

insert into students(first_name ,last_name,father_name,email,class,age)
values("");

select * from students;
Select * from students order by class;

