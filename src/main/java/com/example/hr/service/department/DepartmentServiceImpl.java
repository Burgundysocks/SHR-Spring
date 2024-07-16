package com.example.hr.service.department;

import com.example.hr.domain.dto.DepartmentDTO;
import com.example.hr.mapper.DepartmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentMapper dmapper;

    @Override
    public boolean addDepartment(DepartmentDTO department) {
        return dmapper.insertDepartment(department) == 1;
    }

    @Override
    public List<DepartmentDTO> getAllDepartments() {
        return dmapper.listDepartments();
    }

    @Override
    public boolean updateDepartment(DepartmentDTO department) {
        return dmapper.updateDepartment(department) == 1;
    }

    @Override
    public boolean deleteDepartmentById(Long departmentId) {
        return dmapper.deleteDepartmentById(departmentId) == 1;
    }
}
