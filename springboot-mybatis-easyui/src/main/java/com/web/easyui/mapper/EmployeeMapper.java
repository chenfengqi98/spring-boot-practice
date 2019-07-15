package com.web.easyui.mapper;

import com.web.easyui.entity.Employee;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
//@Mapper
public interface EmployeeMapper {
    List<Employee> getAllEmployee();
    void addEmployee(Employee employee);
    void deleteEmployee(Employee employee);
    int getTotalCount();
    List<Employee> findByPage(int start,int rows);
    Employee findById(Long emp_id);
    void updateEmployee(Employee employee);
}
