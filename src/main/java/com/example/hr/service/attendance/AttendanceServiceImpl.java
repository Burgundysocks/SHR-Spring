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
    public boolean checkIn(AttendanceDTO attendance) {
        return amapper.insertCheckIn(attendance) == 1;
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
    public boolean update(AttendanceDTO attendance) {
        return amapper.updateAttendance(attendance) == 1;
    }

    @Override
    public boolean delete(long attendanceId) {
        return amapper.deleteAttendanceById(attendanceId) == 1;
    }
}
