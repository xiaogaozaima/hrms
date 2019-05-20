package com.iotek.model;

import java.io.Serializable;

public class Train implements Serializable {
    private Integer tra_id;
    private String tra_date;
    private String tra_address;
    private Integer tra_state;
    private String tra_end_date;

    public Integer getTra_id() {
        return tra_id;
    }

    public void setTra_id(Integer tra_id) {
        this.tra_id = tra_id;
    }

    public String getTra_date() {
        return tra_date;
    }

    public void setTra_date(String tra_date) {
        this.tra_date = tra_date;
    }

    public String getTra_address() {
        return tra_address;
    }

    public void setTra_address(String tra_address) {
        this.tra_address = tra_address;
    }

    public Integer getTra_state() {
        return tra_state;
    }

    public void setTra_state(Integer tra_state) {
        this.tra_state = tra_state;
    }

    public String getTra_end_date() {
        return tra_end_date;
    }

    public void setTra_end_date(String tra_end_date) {
        this.tra_end_date = tra_end_date;
    }

    @Override
    public String toString() {
        return "Train{" +
                "tra_id=" + tra_id +
                ", tra_date='" + tra_date + '\'' +
                ", tra_address='" + tra_address + '\'' +
                ", tra_state=" + tra_state +
                ", tra_end_date='" + tra_end_date + '\'' +
                '}';
    }
}
