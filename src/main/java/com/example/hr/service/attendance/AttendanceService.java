package com.example.hr.service.attendance;

import com.example.hr.domain.dto.AttendanceDTO;

import java.util.List;
import java.util.Map;

public interface AttendanceService {

    boolean checkIn(AttendanceDTO attendance);
    boolean checkOut(AttendanceDTO attendance); //update

    List<AttendanceDTO> getAttendance(Map<String, Object> params);

    boolean update(AttendanceDTO attendance);

    boolean delete(long attendanceId);
}
