package com.carlos.core.entity;

import java.util.Date;

/**
 * Created by Administrator on 2017/8/26 0026.
 */
public class Employee {
    private Integer id;
    private String lastName;
    private Date birth;
    private String email;
    private Department department;
    private Integer gender;
    private Float salary;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Employee(){


    }
    public Employee(Integer id, String lastName, String email, Integer gender,
                    Department department) {
        super();
        this.id = id;
        this.lastName = lastName;
        this.email = email;
        this.gender = gender;
        this.department = department;
    }
    @Override
    public String toString() {
        return "Employee [id=" + id + ", lastName=" + lastName + ", email="
                + email + ", gender=" + gender + ", department=" + department
                + ", birth=" + birth + ", salary=" + salary + "]";
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Float getSalary() {
        return salary;
    }

    public void setSalary(Float salary) {
        this.salary = salary;
    }
}
