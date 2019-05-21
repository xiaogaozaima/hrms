package com.iotek.model;

import java.io.Serializable;

public class Interview implements Serializable {
    private Integer int_id;
    private Integer int_user_id;
    private Integer int_dept_id;
    private Integer int_pos_id;
    private String int_time;
    private String int_address;
    private String int_contact;
    private String int_conphone;
    private Integer int_state;
    /*state: 0代表发送的面试；1代表用户同意的；2代表用户拒绝的；3代表已录用的*/

    public Integer getInt_id() {
        return int_id;
    }

    public void setInt_id(Integer int_id) {
        this.int_id = int_id;
    }

    public Integer getInt_user_id() {
        return int_user_id;
    }

    public void setInt_user_id(Integer int_user_id) {
        this.int_user_id = int_user_id;
    }

    public Integer getInt_dept_id() {
        return int_dept_id;
    }

    public void setInt_dept_id(Integer int_dept_id) {
        this.int_dept_id = int_dept_id;
    }

    public Integer getInt_pos_id() {
        return int_pos_id;
    }

    public void setInt_pos_id(Integer int_pos_id) {
        this.int_pos_id = int_pos_id;
    }

    public String getInt_time() {
        return int_time;
    }

    public void setInt_time(String int_time) {
        this.int_time = int_time;
    }

    public String getInt_address() {
        return int_address;
    }

    public void setInt_address(String int_address) {
        this.int_address = int_address;
    }

    public String getInt_contact() {
        return int_contact;
    }

    public void setInt_contact(String int_contact) {
        this.int_contact = int_contact;
    }

    public String getInt_conphone() {
        return int_conphone;
    }

    public void setInt_conphone(String int_conphone) {
        this.int_conphone = int_conphone;
    }

    public Integer getInt_state() {
        return int_state;
    }

    public void setInt_state(Integer int_state) {
        this.int_state = int_state;
    }

    @Override
    public String toString() {
        return "Interview{" +
                "int_id=" + int_id +
                ", int_user_id=" + int_user_id +
                ", int_dept_id=" + int_dept_id +
                ", int_pos_id=" + int_pos_id +
                ", int_time='" + int_time + '\'' +
                ", int_address='" + int_address + '\'' +
                ", int_contact='" + int_contact + '\'' +
                ", int_conphone='" + int_conphone + '\'' +
                ", int_state=" + int_state +
                '}';
    }
}
