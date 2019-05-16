package com.iotek.model;

import java.io.Serializable;

public class Train implements Serializable {
    private Integer id;
    private String date;
    private String address;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Train{" +
                "id=" + id +
                ", date='" + date + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
