package com.example.hr.controller.api;

import com.example.hr.domain.dto.EmployeeDTO;
import com.example.hr.service.employee.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/employee")
public class EmployeeApiController {

    @Autowired
    private EmployeeService eservice;

    @PostMapping(value = "/writeInfo", consumes = "application/json", produces = "application/json;charset=utf-8")
    public ResponseEntity<?> writeEmployee(@Valid @RequestBody EmployeeDTO employee, BindingResult result) {
        if (result.hasErrors()) {
            return new ResponseEntity<>(result.getAllErrors(), HttpStatus.BAD_REQUEST);
        }

        EmployeeDTO savedEmployee = eservice.addEmployee(employee);
        if (savedEmployee == null) {
            return new ResponseEntity<>("Failed to add employee", HttpStatus.INTERNAL_SERVER_ERROR);
        } else {
            return new ResponseEntity<>(savedEmployee, HttpStatus.OK);
        }
    }

    @GetMapping(value = "/list", produces = "application/json;charset=utf-8")
    public ResponseEntity<?> getEmployeeList(@RequestParam Map<String, Object> params) {
        List<EmployeeDTO> employeeList = eservice.getEmployeeList(params);
        if (employeeList.isEmpty()) {
            return new ResponseEntity<>("No employees found", HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(employeeList, HttpStatus.OK);
        }
    }

    @GetMapping(value = "/getEmployee", produces = "application/json;charset=utf-8")
    public ResponseEntity<?> getEmployee(@RequestParam Long employeeId) {
        EmployeeDTO employee = eservice.getEmployeeById(employeeId);
        if (employee == null) {
            return new ResponseEntity<>("Employee not found", HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(employee, HttpStatus.OK);
        }
    }

    @PutMapping(value = "/update", consumes = "application/json")
    public ResponseEntity<?> updateEmployee(@Valid @RequestBody EmployeeDTO employee, BindingResult result) {
        if (result.hasErrors()) {
            return new ResponseEntity<>(result.getAllErrors(), HttpStatus.BAD_REQUEST);
        }

        boolean updateResult = eservice.updateEmployee(employee);
        if (updateResult) {
            return new ResponseEntity<>("Employee updated successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Failed to update employee", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete/{employeeId}")
    public ResponseEntity<?> deleteEmployee(@PathVariable long employeeId) {
        boolean deleteResult = eservice.deleteEmployee(employeeId);
        if (deleteResult) {
            return new ResponseEntity<>("Employee deleted successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Failed to delete employee", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
