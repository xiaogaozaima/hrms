package com.iotek.model;

import java.io.Serializable;

public class Staff implements Serializable {
    private Integer staff_id;
    private String staff_name;
    private String staff_password;
    private Integer staff_dept_id;
    private Integer staff_pos_id;

    public Integer getStaff_id() {
        return staff_id;
    }

    public void setStaff_id(Integer staff_id) {
        this.staff_id = staff_id;
    }

    public String getStaff_name() {
        return staff_name;
    }

    public void setStaff_name(String staff_name) {
        this.staff_name = staff_name;
    }

    public String getStaff_password() {
        return staff_password;
    }

    public void setStaff_password(String staff_password) {
        this.staff_password = staff_password;
    }

    public Integer getStaff_dept_id() {
        return staff_dept_id;
    }

    public void setStaff_dept_id(Integer staff_dept_id) {
        this.staff_dept_id = staff_dept_id;
    }

    public Integer getStaff_pos_id() {
        return staff_pos_id;
    }

    public void setStaff_pos_id(Integer staff_pos_id) {
        this.staff_pos_id = staff_pos_id;
    }

    @Override
    public String toString() {
        return "Staff{" +
                "staff_id=" + staff_id +
                ", staff_name='" + staff_name + '\'' +
                ", staff_password='" + staff_password + '\'' +
                ", staff_dept_id=" + staff_dept_id +
                ", staff_pos_id=" + staff_pos_id +
                '}';
    }
}
