package com.carlos.core.entity;

/**
 * Created by Administrator on 2017/8/26 0026.
 */
public class Department {
    private Integer id;
    private String departmentName;

    public Department() {
        // TODO Auto-generated constructor stub
    }

    public Department(int i, String string) {
        this.id = i;
        this.departmentName = string;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    @Override
    public String toString() {
        return "Department [id=" + id + ", departmentName=" + departmentName
                + "]";
    }

}
