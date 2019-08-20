package com.demo.emp.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.demo.bean.Employees;
import com.demo.emp.mapper.EmployeeMapper;
import com.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeMapper employeeMapper;

    @Override
    public List<Employees> getEmployeeList() {
        return employeeMapper.selectAll();
    }
}
