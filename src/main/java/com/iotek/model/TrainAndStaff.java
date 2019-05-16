package com.iotek.model;

import java.io.Serializable;

public class TrainAndStaff implements Serializable {
    private Integer id;
    private Integer staff_id;
    private Integer train_id;

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

    public Integer getTrain_id() {
        return train_id;
    }

    public void setTrain_id(Integer train_id) {
        this.train_id = train_id;
    }

    @Override
    public String toString() {
        return "TrainAndStaff{" +
                "id=" + id +
                ", staff_id=" + staff_id +
                ", train_id=" + train_id +
                '}';
    }
}
