package com.iotek.model;

import java.io.Serializable;

public class Recruit implements Serializable {
    private Integer rec_id;
    private Integer rec_hir_id;
    private Integer rec_res_id;

    public Integer getRec_id() {
        return rec_id;
    }

    public void setRec_id(Integer rec_id) {
        this.rec_id = rec_id;
    }

    public Integer getRec_hir_id() {
        return rec_hir_id;
    }

    public void setRec_hir_id(Integer rec_hir_id) {
        this.rec_hir_id = rec_hir_id;
    }

    public Integer getRec_res_id() {
        return rec_res_id;
    }

    public void setRec_res_id(Integer rec_res_id) {
        this.rec_res_id = rec_res_id;
    }

    @Override
    public String toString() {
        return "Recruit{" +
                "rec_id=" + rec_id +
                ", rec_hir_id=" + rec_hir_id +
                ", rec_res_id=" + rec_res_id +
                '}';
    }
}
