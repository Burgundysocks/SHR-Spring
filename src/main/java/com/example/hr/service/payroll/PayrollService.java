package com.example.hr.service.payroll;

import com.example.hr.domain.dto.PayrollDTO;

import java.util.List;
import java.util.Map;

public interface PayrollService {

    boolean salaryPay(PayrollDTO pay);

    List<PayrollDTO> listSalaryPay(Map<String, Object> params);

    boolean updateSalaryPay(PayrollDTO pay);

    boolean deleteSalaryPay(PayrollDTO pay);
}
