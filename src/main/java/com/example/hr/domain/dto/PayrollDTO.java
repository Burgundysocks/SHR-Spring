package com.example.hr.domain.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter @Setter
public class PayrollDTO {
    private Long payrollId;
    private Long employeeId;
    private int salary;
    private Date payDay;
}