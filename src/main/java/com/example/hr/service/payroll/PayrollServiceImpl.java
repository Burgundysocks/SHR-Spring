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
    public PayrollDTO salaryPay(PayrollDTO pay) {
        int result = pmapper.insertPayroll(pay);
        if(result == 1){
            List<PayrollDTO> payList = pmapper.getPayByEmployeeId(pay.getEmployeeId());
            if(!payList.isEmpty()){
                return payList.get(0);
            }
            else{
                return null;
            }
        }
        else {
            return null;
        }
    }

    @Override
    public List<PayrollDTO> listByEmployeeId(Long employeeId) {
        return pmapper.getPayByEmployeeId(employeeId);
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
