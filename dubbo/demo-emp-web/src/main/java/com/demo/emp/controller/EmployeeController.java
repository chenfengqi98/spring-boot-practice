package com.demo.emp.controller;

        import com.alibaba.dubbo.config.annotation.Reference;
        import com.demo.bean.Employees;
        import com.demo.service.EmployeeService;
        import org.springframework.stereotype.Controller;
        import org.springframework.web.bind.annotation.RequestMapping;
        import org.springframework.web.bind.annotation.ResponseBody;

        import java.util.List;

@Controller
public class EmployeeController {
    @Reference
    private EmployeeService employeeService;

    @RequestMapping("getEmployeeList")
    @ResponseBody
    public List<Employees> getEmployeeList(){
        List<Employees> employeesList = employeeService.getEmployeeList();
        return employeesList;
    }
}
