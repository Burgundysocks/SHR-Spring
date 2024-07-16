package com.example.hr.mapper;

import com.example.hr.domain.dto.PayrollDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface PayrollMapper {
    // C
    int insertPayroll(PayrollDTO payroll);
    // R
    List<PayrollDTO> getPayByEmployeeId(Long employeeId);
    List<PayrollDTO> getPayroll(Map<String, Object> params);
    // U - 필요 시에만 사용
    int updatePayroll(PayrollDTO payroll);
    // D - 필요 시에만 사용
    int deletePayrollById(Long payrollId);
}
