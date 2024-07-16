package com.example.hr.mapper;

import com.example.hr.domain.dto.EmployeeDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface EmployeeMapper {
    //C
    int insertEmployee(EmployeeDTO employee);
    //R
    List<EmployeeDTO> getEmployeeList(Map<String, Object> params);
    //U
    int updateEmployee(EmployeeDTO employee);
    //D -- 필요 시에만
    int deleteEmployee(long employeeId);
}
