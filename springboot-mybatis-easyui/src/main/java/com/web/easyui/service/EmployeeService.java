package com.web.easyui.service;

import com.web.easyui.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAllEmployee();
    void addEmployee(Employee employee);
    void deleteEmployee(Employee employee);
    int getTotalCount();
    List<Employee> findByPage(int start,int rows);
    Employee findById(Long emp_id);
    void updateEmployee(Employee employee);

}
