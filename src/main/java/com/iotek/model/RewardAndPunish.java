package com.iotek.model;

import java.io.Serializable;

public class RewardAndPunish implements Serializable {
    private Integer rap_id;
    private Integer rap_staff_id;
    private String rap_detail;
    private Double rap_money;
    private Integer rap_che_id;
    private String rap_ym;

    public Integer getRap_id() {
        return rap_id;
    }

    public void setRap_id(Integer rap_id) {
        this.rap_id = rap_id;
    }

    public Integer getRap_staff_id() {
        return rap_staff_id;
    }

    public void setRap_staff_id(Integer rap_staff_id) {
        this.rap_staff_id = rap_staff_id;
    }

    public String getRap_detail() {
        return rap_detail;
    }

    public void setRap_detail(String rap_detail) {
        this.rap_detail = rap_detail;
    }

    public Double getRap_money() {
        return rap_money;
    }

    public void setRap_money(Double rap_money) {
        this.rap_money = rap_money;
    }

    public Integer getRap_che_id() {
        return rap_che_id;
    }

    public void setRap_che_id(Integer rap_che_id) {
        this.rap_che_id = rap_che_id;
    }

    public String getRap_ym() {
        return rap_ym;
    }

    public void setRap_ym(String rap_ym) {
        this.rap_ym = rap_ym;
    }

    @Override
    public String toString() {
        return "RewardAndPunish{" +
                "rap_id=" + rap_id +
                ", rap_staff_id=" + rap_staff_id +
                ", rap_detail='" + rap_detail + '\'' +
                ", rap_money=" + rap_money +
                ", rap_che_id=" + rap_che_id +
                ", rap_ym='" + rap_ym + '\'' +
                '}';
    }
}
