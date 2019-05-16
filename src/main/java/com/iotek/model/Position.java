package com.iotek.model;

import java.io.Serializable;

public class Position implements Serializable {
    private Integer pos_id;
    private String pos_name;
    private Integer pos_dept_id;

    public Integer getPos_id() {
        return pos_id;
    }

    public void setPos_id(Integer pos_id) {
        this.pos_id = pos_id;
    }

    public String getPos_name() {
        return pos_name;
    }

    public void setPos_name(String pos_name) {
        this.pos_name = pos_name;
    }

    public Integer getPos_dept_id() {
        return pos_dept_id;
    }

    public void setPos_dept_id(Integer pos_dept_id) {
        this.pos_dept_id = pos_dept_id;
    }

    @Override
    public String toString() {
        return "Position{" +
                "pos_id=" + pos_id +
                ", pos_name='" + pos_name + '\'' +
                ", pos_dept_id=" + pos_dept_id +
                '}';
    }
}
