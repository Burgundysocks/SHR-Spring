package com.example.hr.controller.api;

import com.example.hr.domain.dto.PayrollDTO;
import com.example.hr.service.payroll.PayrollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/payroll")
public class PayrollApiController {

    @Autowired
    private PayrollService pservice;

    @PostMapping(value = "/pay", consumes = "application/json", produces = "application/json;charset=utf-8")
    public ResponseEntity<PayrollDTO> payroll(@RequestBody PayrollDTO pay) {
        PayrollDTO result = pservice.salaryPay(pay);
        if(result != null){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        } else{
            return new ResponseEntity<>(result, HttpStatus.OK);
        }
    }

    @GetMapping(value="/list", produces = "application/json;charset=utf-8")
    public ResponseEntity<List<PayrollDTO>> listPayroll(@RequestParam Map<String, Object> params) {
        List<PayrollDTO> list = pservice.listSalaryPay(params);
        if(list.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else{
            return new ResponseEntity<>(list, HttpStatus.OK);
        }
    }

    @GetMapping(value="/emList", produces = "application/json;charset=utf-8")
    public ResponseEntity<List<PayrollDTO>> emListPayroll(Long employeeId) {
        List<PayrollDTO> employeePay = pservice.listByEmployeeId(employeeId);
        if(employeePay.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else{
            return new ResponseEntity<>(employeePay, HttpStatus.OK);
        }
    }
}
