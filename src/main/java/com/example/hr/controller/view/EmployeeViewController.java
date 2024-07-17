package com.example.hr.controller.view;

import com.example.hr.service.employee.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/employee")
@Controller
public class EmployeeViewController {

    @Autowired
    private EmployeeService eservice;

    @GetMapping("write_info")
    public String employee(Model model) {
        return "employee/write-info";
    }

    @GetMapping("user_info")
    public String myEmployee(Model model) {
        return "employee/user-info";
    }

    @GetMapping("list")
    public String list(Model model) {
        return "employee/list";
    }

    @GetMapping("/update")
    public String update(Model model) {
        return "employee/update";
    }

    @GetMapping("/delete")
    public String delete(Model model) {
        return "employee/delete";
    }
}
