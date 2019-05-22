package com.iotek.model;

import java.io.Serializable;

public class CheckWork implements Serializable {
    private Integer che_id;
    private String che_onTime;
    private String che_offTime;
    private Integer che_staff_id;
    private String che_ym;
    private String che_date;

    public Integer getChe_id() {
        return che_id;
    }

    public void setChe_id(Integer che_id) {
        this.che_id = che_id;
    }

    public String getChe_onTime() {
        return che_onTime;
    }

    public void setChe_onTime(String che_onTime) {
        this.che_onTime = che_onTime;
    }

    public String getChe_offTime() {
        return che_offTime;
    }

    public void setChe_offTime(String che_offTime) {
        this.che_offTime = che_offTime;
    }

    public Integer getChe_staff_id() {
        return che_staff_id;
    }

    public void setChe_staff_id(Integer che_staff_id) {
        this.che_staff_id = che_staff_id;
    }

    public String getChe_ym() {
        return che_ym;
    }

    public void setChe_ym(String che_ym) {
        this.che_ym = che_ym;
    }

    public String getChe_date() {
        return che_date;
    }

    public void setChe_date(String che_date) {
        this.che_date = che_date;
    }

    @Override
    public String toString() {
        return "CheckWork{" +
                "che_id=" + che_id +
                ", che_onTime='" + che_onTime + '\'' +
                ", che_offTime='" + che_offTime + '\'' +
                ", che_staff_id=" + che_staff_id +
                ", che_ym='" + che_ym + '\'' +
                ", che_date='" + che_date + '\'' +
                '}';
    }
}
