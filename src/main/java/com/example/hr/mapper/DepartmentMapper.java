package com.example.hr.mapper;

import com.example.hr.domain.dto.DepartmentDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DepartmentMapper {
    // C - 필요 시에만 사용
    int insertDepartment(DepartmentDTO department);
    // R
    List<DepartmentDTO> listDepartments();
    // U - 필요 시에만 사용
    int updateDepartment(DepartmentDTO department);
    // D - 필요 시에만 사용
    int deleteDepartmentById(Long departmentId);
}
