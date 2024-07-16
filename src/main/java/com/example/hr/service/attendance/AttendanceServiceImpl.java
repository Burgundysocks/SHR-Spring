package com.example.hr.service.attendance;

import com.example.hr.domain.dto.AttendanceDTO;
import com.example.hr.mapper.AttendanceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class AttendanceServiceImpl implements AttendanceService {

    @Autowired
    private AttendanceMapper amapper;

    @Override
    public AttendanceDTO checkIn(AttendanceDTO attendance) {
        int result = amapper.insertCheckIn(attendance);
        if (result == 1) {
            List<AttendanceDTO> attendanceList = amapper.getAttendanceByEmployeeId(attendance.getEmployeeId());
            if (!attendanceList.isEmpty()) {
                return attendanceList.get(0);
            } else {

                return null;
            }
        } else {
            return null;
        }
    }


    @Override
    public boolean checkOut(AttendanceDTO attendance) {
        return amapper.insertCheckOut(attendance) == 1;
    }

    @Override
    public List<AttendanceDTO> getAttendance(Map<String, Object> params) {
        return amapper.getAttendance(params);
    }

    @Override
    public List<AttendanceDTO> getAttendanceByEmployeeId(Long employeeId) {
        return amapper.getAttendanceByEmployeeId(employeeId);
    }


    @Override
    public boolean update(AttendanceDTO attendance) {
        return amapper.updateAttendance(attendance) == 1;
    }

    @Override
    public boolean delete(long attendanceId) {
        return amapper.deleteAttendanceById(attendanceId) == 1;
    }
}
