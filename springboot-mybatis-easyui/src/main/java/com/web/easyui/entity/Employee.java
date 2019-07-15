package com.web.easyui.entity;

public class Employee {
    private Long emp_id;
    private String emp_name;
    private String emp_sex;
    private Integer emp_age;
    private String emp_phone;
    private String emp_dep;

    @Override
    public String toString() {
        return "Employee{" +
                "emp_id=" + emp_id +
                ", emp_name='" + emp_name + '\'' +
                ", emp_sex='" + emp_sex + '\'' +
                ", emp_age=" + emp_age +
                ", emp_phone='" + emp_phone + '\'' +
                ", emp_dep='" + emp_dep + '\'' +
                '}';
    }

    public Employee(Long emp_id, String emp_name, String emp_sex, Integer emp_age, String emp_phone, String emp_dep) {
        this.emp_id = emp_id;
        this.emp_name = emp_name;
        this.emp_sex = emp_sex;
        this.emp_age = emp_age;
        this.emp_phone = emp_phone;
        this.emp_dep = emp_dep;
    }

    public Employee() {
    }

    public Employee(String emp_name, String emp_sex, Integer emp_age, String emp_phone, String emp_dep) {
        this.emp_name = emp_name;
        this.emp_sex = emp_sex;
        this.emp_age = emp_age;
        this.emp_phone = emp_phone;
        this.emp_dep = emp_dep;
    }

    public void setEmp_id(Long emp_id) {
        this.emp_id = emp_id;
    }

    public void setEmp_name(String emp_name) {
        this.emp_name = emp_name;
    }

    public void setEmp_sex(String emp_sex) {
        this.emp_sex = emp_sex;
    }

    public void setEmp_age(Integer emp_age) {
        this.emp_age = emp_age;
    }

    public void setEmp_phone(String emp_phone) {
        this.emp_phone = emp_phone;
    }

    public void setEmp_dep(String emp_dep) {
        this.emp_dep = emp_dep;
    }

    public Long getEmp_id() {
        return emp_id;
    }

    public String getEmp_name() {
        return emp_name;
    }

    public String getEmp_sex() {
        return emp_sex;
    }

    public Integer getEmp_age() {
        return emp_age;
    }

    public String getEmp_phone() {
        return emp_phone;
    }

    public String getEmp_dep() {
        return emp_dep;
    }
}
