package com.iotek.model;

import java.io.Serializable;

public class Salary implements Serializable {
    private Integer id;
    private Integer staff_id;
    private Double money;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStaff_id() {
        return staff_id;
    }

    public void setStaff_id(Integer staff_id) {
        this.staff_id = staff_id;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "Salary{" +
                "id=" + id +
                ", staff_id=" + staff_id +
                ", money=" + money +
                '}';
    }
}
