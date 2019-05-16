package com.iotek.model;

import java.io.Serializable;

public class CheckWork implements Serializable {
    private Integer che_id;
    private String che_onTime;
    private String che_offTime;

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

    @Override
    public String toString() {
        return "CheckWork{" +
                "che_id=" + che_id +
                ", che_onTime='" + che_onTime + '\'' +
                ", che_offTime='" + che_offTime + '\'' +
                '}';
    }
}
