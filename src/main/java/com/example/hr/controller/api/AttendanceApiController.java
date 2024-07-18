package com.example.hr.controller.api;

import com.example.hr.domain.dto.AttendanceDTO;
import com.example.hr.service.attendance.AttendanceService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/attendance")
public class AttendanceApiController {

    @Autowired
    private AttendanceService aservice;

    @PostMapping(value = "/checkIn", consumes = "application/json", produces = "application/json;charset=utf-8")
    public ResponseEntity<?> checkIn(@Valid @RequestBody AttendanceDTO attendanceDTO) {
        AttendanceDTO result = aservice.checkIn(attendanceDTO);
        if (result != null) {
            return new ResponseEntity<>(result, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(value = "/checkOut", consumes = "application/json", produces = "application/json;charset=utf-8")
    public ResponseEntity<String> checkOut(@Valid @RequestBody AttendanceDTO attendanceDTO) {
        boolean result = aservice.checkOut(attendanceDTO);
        if (result) {
            return new ResponseEntity<>("checkout", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("fail", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/list", produces = "application/json;charset=utf-8")
    public ResponseEntity<?> getAttendanceList(@RequestParam Map<String, Object> params) {
        List<AttendanceDTO> attendanceList = aservice.getAttendance(params);
        if (attendanceList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(attendanceList, HttpStatus.OK);
        }
    }

    @GetMapping(value = "/em-list", produces = "application/json;charset=utf-8")
    public ResponseEntity<?> getEmployeeAttendance(@RequestParam Long employeeId) {
        List<AttendanceDTO> employeeAttendanceList = aservice.getAttendanceByEmployeeId(employeeId);
        if (employeeAttendanceList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(employeeAttendanceList, HttpStatus.OK);
        }
    }
}

