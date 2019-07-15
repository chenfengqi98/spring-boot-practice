package com.web.easyui.service.Impl;

import com.web.easyui.entity.Employee;
import com.web.easyui.mapper.EmployeeMapper;
import com.web.easyui.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Primary
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeMapper employeeMapper;

    @Override
    public List<Employee> getAllEmployee() {
        return employeeMapper.getAllEmployee();
    }

    @Override
    public List<Employee> findByPage(int start, int rows) {
        return employeeMapper.findByPage(start,rows);
    }

    @Override
    public Employee findById(Long emp_id) {
        return employeeMapper.findById(emp_id);
    }

    @Override
    public void updateEmployee(Employee employee) {
        employeeMapper.updateEmployee(employee);
    }

    @Override
    public int getTotalCount() {
        return employeeMapper.getTotalCount();
    }

    @Override
    public void addEmployee(Employee employee) {
        employeeMapper.addEmployee(employee);
    }

    @Override
    public void deleteEmployee(Employee employee) {
        employeeMapper.deleteEmployee(employee);
    }
}
