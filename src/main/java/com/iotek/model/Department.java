package com.iotek.model;

import java.io.Serializable;

public class Department implements Serializable {
    private Integer dept_id;
    private String dept_name;
    private String dept_date;

    public Integer getDept_id() {
        return dept_id;
    }

    public void setDept_id(Integer dept_id) {
        this.dept_id = dept_id;
    }

    public String getDept_name() {
        return dept_name;
    }

    public void setDept_name(String dept_name) {
        this.dept_name = dept_name;
    }

    public String getDept_date() {
        return dept_date;
    }

    public void setDept_date(String dept_date) {
        this.dept_date = dept_date;
    }

    @Override
    public String toString() {
        return "Department{" +
                "dept_id=" + dept_id +
                ", dept_name='" + dept_name + '\'' +
                ", dept_date='" + dept_date + '\'' +
                '}';
    }
}
