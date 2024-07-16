create database hr;

use hr;

create table user( -- 아이디기록
	user_id varchar(300) primary key,
    password varchar(300) not null,
    role enum('ADMIN', 'EMPLOYEE') not null
);

create table employee( -- 직원
	employee_id long auto_increment primary key,
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
    department_id int not null,
    salary int not null,
    is_employee enum ('TRUE','FALSE') default 'TRUE',
    foreign key (user_id) references user(user_id),
    foreign key (department_id) references department(department_id)
);

create table department( -- 부서
	department_id long auto_increment primary key,
    department_name varchar(300) not null,
    d_explain text
);

create table attendance( -- 출퇴근
	attendance_id long auto_increment primary key,
    employee_id long not null,
    date date not null,
    check_in timestamp,
    check_out timestamp,
    foreign key (employee_id) references employee(employee_id) 
);

create table payroll( -- 급여
	payroll_id long auto_increment primary key,
    employee_id long not null,
    salary int not null,
    pay_day date not null
);


