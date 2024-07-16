package com.example.hr.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class AttendanceDTO {
    private Long attendanceId;
    private Long employeeId;
    private Date date;
    private Date checkIn;
    private Date checkOut;

}