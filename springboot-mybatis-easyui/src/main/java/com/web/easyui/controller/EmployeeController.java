package com.web.easyui.controller;

import com.web.easyui.entity.Employee;
import com.web.easyui.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    /*@RequestMapping(value = "/")
    public ModelAndView index(ModelAndView modelAndView){
        modelAndView.setViewName("reception.html");
        return modelAndView;
    }*/

    @RequestMapping(value = "/getEmployee",method = RequestMethod.GET)
    public List<Employee> getAllEmployee(){
        return employeeService.getAllEmployee();
    }

    @RequestMapping(value = "/findByPage",method = RequestMethod.POST)
    public Map findByPage(HttpServletRequest request){
        int page = Integer.parseInt(request.getParameter("page"));
        int rows = Integer.parseInt(request.getParameter("rows"));
        int total = employeeService.getTotalCount();
        int start = (page-1)*rows;
        List<Employee> list = employeeService.findByPage(start,rows);
        Map map = new HashMap();
        map.put("total",total);
        map.put("rows",list);
        return map;
    }
    @RequestMapping(value = "/addEmployee",method = RequestMethod.POST,consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public Map addEmployee(@RequestParam(value = "emp_name",required = true)String emp_name,
                           @RequestParam(value = "emp_sex",required = true) String emp_sex,
                           @RequestParam(value = "emp_age",required = true)Integer emp_age,
                           @RequestParam(value = "emp_phone",required = true)String emp_phone,
                           @RequestParam(value = "emp_dep",required = true)String emp_dep){
        Employee employee = new Employee(emp_name,emp_sex,emp_age,emp_phone,emp_dep);
        Map<String,String> map = new HashMap();
        try {
            employeeService.addEmployee(employee);
            map.put("msg","保存成功");
        }catch (Exception e){
            e.printStackTrace();
            map.put("msg","保存失败");
        }
        return map;
    }
    @RequestMapping(value = "/deleteEmployee",method = RequestMethod.DELETE)
    public Map deleteEmployee(@RequestParam(value = "emp_id",required = true)Long emp_id){
        Employee employee = new Employee();
        employee.setEmp_id(emp_id);
        Map<String,String> map = new HashMap();
        try {
            employeeService.deleteEmployee(employee);
            map.put("msg","删除成功");
        }catch (Exception e){
            e.printStackTrace();
            map.put("msg","删除失败");
        }
        return map;
    }
    @RequestMapping(value = "/findById")
    public Employee findById(@RequestParam(value = "emp_id",required = true)Long emp_id){
        return employeeService.findById(emp_id);
    }
    @RequestMapping(value = "updateEmployee")
    public Map updateEmployee(@RequestParam(value = "emp_name",required = true)String emp_name,
                              @RequestParam(value = "emp_sex",required = true) String emp_sex,
                              @RequestParam(value = "emp_age",required = true)Integer emp_age,
                              @RequestParam(value = "emp_phone",required = true)String emp_phone,
                              @RequestParam(value = "emp_dep",required = true)String emp_dep,
                              @RequestParam(value = "emp_id",required = true)Long emp_id){
        Employee employee = new Employee(emp_id,emp_name,emp_sex,emp_age,emp_phone,emp_dep);
        //System.out.println(employee.toString());
        Map<String,String> map = new HashMap();
        try {
            employeeService.updateEmployee(employee);
            map.put("msg","更新成功!");
        }catch (Exception e){
            e.printStackTrace();
            map.put("msg","更新失败!");
        }
        return map;
    }
}
