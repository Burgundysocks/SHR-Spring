package com.example.hr.mapper;

import com.example.hr.domain.dto.AttendanceDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface AttendanceMapper {
    // C
    int insertCheckIn(AttendanceDTO attendance);

    // R
    List<AttendanceDTO> getAttendance(Map<String, Object> params);
    List<AttendanceDTO> getAttendanceByEmployeeId(Long employeeId);

    // U
    int insertCheckOut(AttendanceDTO attendance);
    int updateAttendance(AttendanceDTO attendance); //-필요 시에만 사용
    // D - 필요 시에만 사용
    int deleteAttendanceById(Long attendanceId);
}
