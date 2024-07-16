package com.example.hr.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDTO {
    private Long employeeId;
    private String userId;
    private String firstName;
    private String lastName;
    private Gender gender;
    private String phone;
    private String email;
    private Date birth;
    private Date hireDate;
    private String zipcode;
    private String addr;
    private String addrDetail;
    private String addrEtc;
    private Long departmentId;
    private int salary;
    private isEmployee isEmployee;

}

