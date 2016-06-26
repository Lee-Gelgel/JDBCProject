drop table member;

create table member(
	no int auto_increment,
    name varchar(10),
    phone varchar(13),
    gender varchar(1),
    code varchar(2),
    primary key (no),
    foreign key (code) references class(code)
);

create table class(
	code varchar(2) primary key,
	name varchar(10) unique
)

select * from member;
select * from class;

insert into class (code, name) values ('M','Manager');
insert into class (code, name) values ('C','Customer');

insert into member (name,phone,gender,code) values ('gelgel','010-9481-9054','M','M');
insert into member (name,phone,gender,code) values ('lulu','010-9471-9054','F','C');

select no, member.name, phone, gender, code, class.name from member join class using (code);

