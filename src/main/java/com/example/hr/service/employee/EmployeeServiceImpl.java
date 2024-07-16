package com.example.hr.service.employee;

import com.example.hr.domain.dto.EmployeeDTO;
import com.example.hr.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeMapper emapper;

    @Override
    public boolean addEmployee(EmployeeDTO employee) {
        return emapper.insertEmployee(employee) == 1;
    }

    @Override
    public List<EmployeeDTO> getEmployeeList(Map<String, Object> params) {
        return emapper.getEmployeeList(params);
    }

    @Override
    public boolean updateEmployee(EmployeeDTO employee) {
        return emapper.updateEmployee(employee) == 1;
    }

    @Override
    public boolean deleteEmployee(long employeeId) {
        return emapper.deleteEmployee(employeeId) == 1;
    }
}
