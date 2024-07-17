package com.example.hr.controller.api;

import com.example.hr.domain.dto.AttendanceDTO;
import com.example.hr.service.attendance.AttendanceService;
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
    public ResponseEntity<AttendanceDTO> checkIn(@RequestBody AttendanceDTO attendance) {
        AttendanceDTO result = aservice.checkIn(attendance);
        if(result != null){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        } else{
            return new ResponseEntity<>(result, HttpStatus.OK);
        }
    }

    @PutMapping(value ="/checkOut", consumes = "application/json")
    public ResponseEntity<String> checkOut(@RequestBody AttendanceDTO attendance) {
        boolean reulst = aservice.checkOut(attendance);
        if(reulst){
            return new ResponseEntity<>("checkout", HttpStatus.OK);
        } else{
            return new ResponseEntity<>("fail", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping(value="/list", produces = "application/json;charset=utf-8")
    public ResponseEntity<List<AttendanceDTO>> attendance(@RequestParam Map<String, Object> params) {
        List<AttendanceDTO> list = aservice.getAttendance(params);
        if(list.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else{
            return new ResponseEntity<>(list, HttpStatus.OK);
        }
    }

    @GetMapping(value="/em-list", produces = "application/json;charset=utf-8")
    public ResponseEntity<List<AttendanceDTO>> employeeAttendance(Long employeeId) {
        List<AttendanceDTO> listByEmployee = aservice.getAttendanceByEmployeeId(employeeId);
        if(listByEmployee.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else{
            return new ResponseEntity<>(listByEmployee, HttpStatus.OK);
        }
    }

}
