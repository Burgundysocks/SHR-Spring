package com.example.hr.service.employee;

import com.example.hr.domain.dto.EmployeeDTO;
import java.util.List;
import java.util.Map;

public interface EmployeeService {

    boolean addEmployee(EmployeeDTO employee);

    List<EmployeeDTO> getEmployeeList(Map<String, Object> params);

    boolean updateEmployee(EmployeeDTO employee);

    boolean deleteEmployee(long employeeId);
}
