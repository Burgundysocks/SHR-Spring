package com.example.hr.service.payroll;


import com.example.hr.domain.dto.PayrollDTO;
import com.example.hr.mapper.PayrollMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class PayrollServiceImpl implements PayrollService {

    @Autowired
    private PayrollMapper pmapper;

    @Override
    public boolean salaryPay(PayrollDTO pay) {
        return pmapper.insertPayroll(pay) == 1;
    }

    @Override
    public List<PayrollDTO> listSalaryPay(Map<String, Object> params) {
        return pmapper.getPayroll(params);
    }

    @Override
    public boolean updateSalaryPay(PayrollDTO pay) {
        return false;
    }

    @Override
    public boolean deleteSalaryPay(PayrollDTO pay) {
        return false;
    }
}
