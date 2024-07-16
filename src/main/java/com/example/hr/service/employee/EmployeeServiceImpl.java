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
    public EmployeeDTO addEmployee(EmployeeDTO employee) {
        int result = emapper.insertEmployee(employee);
        if(result == 1){
            EmployeeDTO addEmployee = emapper.getEmployeeById(employee.getEmployeeId());
            if(addEmployee != null){
                return addEmployee;
            } else {
                return null;
            }
        }
        return null;
    }

    @Override
    public EmployeeDTO getEmployeeById(Long employeeId) {
        return emapper.getEmployeeById(employeeId);
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
