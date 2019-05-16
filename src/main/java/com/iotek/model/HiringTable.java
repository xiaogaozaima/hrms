package com.iotek.model;

import java.io.Serializable;

public class HiringTable implements Serializable {
    private Integer hir_id;
    private Integer hir_dept_id;
    private Integer hir_pos_id;
    private String hir_disc;

    public Integer getHir_id() {
        return hir_id;
    }

    public void setHir_id(Integer hir_id) {
        this.hir_id = hir_id;
    }

    public Integer getHir_dept_id() {
        return hir_dept_id;
    }

    public void setHir_dept_id(Integer hir_dept_id) {
        this.hir_dept_id = hir_dept_id;
    }

    public Integer getHir_pos_id() {
        return hir_pos_id;
    }

    public void setHir_pos_id(Integer hir_pos_id) {
        this.hir_pos_id = hir_pos_id;
    }

    public String getHir_disc() {
        return hir_disc;
    }

    public void setHir_disc(String hir_disc) {
        this.hir_disc = hir_disc;
    }

    @Override
    public String toString() {
        return "HiringTable{" +
                "hir_id=" + hir_id +
                ", hir_dept_id=" + hir_dept_id +
                ", hir_pos_id=" + hir_pos_id +
                ", hir_disc='" + hir_disc + '\'' +
                '}';
    }
}
