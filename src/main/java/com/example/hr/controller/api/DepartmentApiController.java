package com.example.hr.controller.api;

import com.example.hr.domain.dto.DepartmentDTO;
import com.example.hr.service.department.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/api/department")
@RestController
public class DepartmentApiController {

    @Autowired
    private DepartmentService dservice;

    @GetMapping(value = "/list", produces = "application/json;charset=utf-8")
    public ResponseEntity<List<DepartmentDTO>> getAllDepartments() {
        List<DepartmentDTO> deparment = dservice.getAllDepartments();

        return new ResponseEntity<>(deparment, HttpStatus.OK);
    }
}
