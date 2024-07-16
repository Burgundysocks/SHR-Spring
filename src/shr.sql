create database hr;

use hr;

create table user( -- 아이디기록
	user_id varchar(300) primary key,
    password varchar(300) not null,
    role enum('ADMIN', 'EMPLOYEE') not null
);

create table employee( -- 직원
	employee_id bigint auto_increment primary key,
    user_id varchar(300),
	first_name varchar(300) not null,
    last_name varchar(300) not null,
    gender enum('MALE','FEMALE') not null,
    phone varchar(300),
    email varchar(300),
    birth date,
    hire_date date,
    zipcode varchar(300),
    addr varchar(300),
    addr_detail varchar(300),
    addr_etc varchar(300),
    department_id bigint not null,
    salary int not null,
    is_employee enum ('TRUE','FALSE') default 'TRUE',
    foreign key (user_id) references user(user_id),
    foreign key (department_id) references department(department_id)
);


create table department( -- 부서
	department_id bigint auto_increment primary key,
    department_name varchar(300) not null,
    d_explain text
);

create table attendance( -- 출퇴근
	attendance_id bigint auto_increment primary key,
    employee_id bigint not null,
    date datetime default now(),
    check_in timestamp default now(),
    check_out timestamp default null,
    foreign key (employee_id) references employee(employee_id) 
);

create table payroll( -- 급여
	payroll_id bigint auto_increment  primary key ,
    employee_id bigint not null,
    salary int not null,
    pay_day date not null
);

insert into user(user_id,password,role) values("asdf","1234","EMPLOYEE");
INSERT INTO department (department_name, d_explain) VALUES ('HR', 'Human Resources Department');
INSERT INTO employee (user_id, first_name, last_name, gender, phone, email, birth, hire_date, zipcode, addr, addr_detail, addr_etc, department_id, salary)
VALUES ('qwer', 'John', 'Doe', 'MALE', '123-456-7890', 'john.doe@example.com', '1980-01-01', '2020-01-01', '12345', '123 Main St', 'Apt 1', 'Near Park', 1, 50000);
INSERT INTO attendance (employee_id) VALUES (1);
select * from attendance;
INSERT INTO payroll (employee_id, salary, pay_day) VALUES (2, 50000, now());

drop table employee;
drop table attendance;
select * from user;
select * from employee;

select a.attendance_id, a.employee_id, a.date, a.check_in, a.check_out,
		e.employee_id,e.first_name, e.last_name, e.gender,
		e.phone, e.email, e.birth, e.hire_date,
		e.department_id, e.salary, e.is_employee,
		d.department_name, d.d_explain
	from attendance a
	join employee e on a.employee_id = e.employee_id
	join department d on e.department_id = d.department_id
	where a.employee_id = 1;
    
    update attendance
        set check_out = now()
        where employee_id = 1 and check_out is null;
        
                select e.employee_id, e.first_name, e.last_name, e.gender, e.phone, e.email,
               e.hire_date, e.department_id, e.salary as employee_salary,
               p.payroll_id, p.salary as payroll_salary, p.pay_day
        from employee e
        join payroll p on e.employee_id = p.employee_id
        where
        employee_id > 0;
        
                select e.employee_id, e.user_id, e.first_name, e.last_name, e.gender, e.phone, e.email,
        e.birth, e.hire_date, e.zipcode, e.addr, e.addr_detail, e.addr_etc,
        e.department_id, e.is_employee, p.salary as payroll_salary, p.pay_day
        from employee e
        join payroll p on e.employee_id = p.employee_id
        where e.employee_id = 1;
        

drop table user;
drop table employee;
drop table department;
drop table attendance;
drop table payroll;


