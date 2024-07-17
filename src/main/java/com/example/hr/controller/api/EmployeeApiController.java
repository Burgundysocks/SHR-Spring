package com.example.hr.controller.api;

import com.example.hr.domain.dto.EmployeeDTO;
import com.example.hr.service.employee.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/employee")
public class EmployeeApiController {

    @Autowired
    private EmployeeService eservice;

    @PostMapping(value = "/writeInfo", consumes = "application/json", produces = "application/json;charset=utf-8")
    public ResponseEntity<EmployeeDTO> writeEmployee(@RequestBody EmployeeDTO employee) {
        EmployeeDTO result = eservice.addEmployee(employee);
        if (result != null) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        } else{
            return new ResponseEntity<>(result, HttpStatus.OK);
        }
    }
    @GetMapping(value = "/list", produces = "application/json;charset=utf-8")
    public ResponseEntity<List<EmployeeDTO>> getEmployeeList(@RequestParam Map<String, Object> params) {
        List<EmployeeDTO> employeeList = eservice.getEmployeeList(params);
        if (employeeList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(employeeList, HttpStatus.OK);
        }
    }

    @GetMapping(value = "/getEmployee", produces = "application/json;charset=utf-8")
    public ResponseEntity<EmployeeDTO> getEmployee(Long employeeId) {
        EmployeeDTO employee = eservice.getEmployeeById(employeeId);
        if (employee == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(employee, HttpStatus.OK);
        }
    }

    @PutMapping(value = "/update", consumes = "application/json")
    public ResponseEntity<String> updateEmployee(@RequestBody EmployeeDTO employee) {
        boolean result = eservice.updateEmployee(employee);
        if (result) {
            return new ResponseEntity<>("update", HttpStatus.OK);
        }else{
            return new ResponseEntity<>("fail", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete/{employeeId}")
    public ResponseEntity<String> deleteEmployee(@PathVariable long employeeId) {
        boolean result = eservice.deleteEmployee(employeeId);
        if (result) {
            return new ResponseEntity<>("delete",HttpStatus.OK);
        }
        return new ResponseEntity<>("fail", HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
