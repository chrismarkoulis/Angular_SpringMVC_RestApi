create database SALESdb;

use SALESdb;

create table salesman(
scode int unsigned not null,
sname varchar(20) not null,  
scity varchar(20) null,
scomm decimal(5,2) unsigned null,  
primary key (scode)
);

insert into salesman(sname,scode,scity,scomm)
values('John_Doe',101,'Athens',0.14),
('Allan_Heinrich',102,'Germany',0.15),
('Jim_Papadopoulos',103,'Athens',0.17),
('Raphael_Guillaume',104,'Paris',0.16),
('Chris_Mark',105,'Athens',0.14);

select * from salesman;