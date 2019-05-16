package com.iotek.model;

import java.io.Serializable;

public class Resume implements Serializable {
    private Integer res_id;
    private String res_name;
    private String res_sex;
    private String res_bothday;
    private String res_nation;
    private String res_native;
    private String res_address;
    private Integer res_user_id;
    private String res_phone;
    private String res_email;
    private String res_graduate;
    private String res_education;
    private String res_skill;
    private String res_evaluation;

    public Integer getRes_id() {
        return res_id;
    }

    public void setRes_id(Integer res_id) {
        this.res_id = res_id;
    }

    public String getRes_name() {
        return res_name;
    }

    public void setRes_name(String res_name) {
        this.res_name = res_name;
    }

    public String getRes_sex() {
        return res_sex;
    }

    public void setRes_sex(String res_sex) {
        this.res_sex = res_sex;
    }

    public String getRes_bothday() {
        return res_bothday;
    }

    public void setRes_bothday(String res_bothday) {
        this.res_bothday = res_bothday;
    }

    public String getRes_nation() {
        return res_nation;
    }

    public void setRes_nation(String res_nation) {
        this.res_nation = res_nation;
    }

    public String getRes_native() {
        return res_native;
    }

    public void setRes_native(String res_natv) {
        this.res_native = res_natv;
    }

    public String getRes_address() {
        return res_address;
    }

    public void setRes_address(String res_address) {
        this.res_address = res_address;
    }

    public Integer getRes_user_id() {
        return res_user_id;
    }

    public void setRes_user_id(Integer res_user_id) {
        this.res_user_id = res_user_id;
    }

    public String getRes_phone() {
        return res_phone;
    }

    public void setRes_phone(String res_phone) {
        this.res_phone = res_phone;
    }

    public String getRes_email() {
        return res_email;
    }

    public void setRes_email(String res_email) {
        this.res_email = res_email;
    }

    public String getRes_graduate() {
        return res_graduate;
    }

    public void setRes_graduate(String res_graduate) {
        this.res_graduate = res_graduate;
    }

    public String getRes_education() {
        return res_education;
    }

    public void setRes_education(String res_education) {
        this.res_education = res_education;
    }

    public String getRes_skill() {
        return res_skill;
    }

    public void setRes_skill(String res_skill) {
        this.res_skill = res_skill;
    }

    public String getRes_evaluation() {
        return res_evaluation;
    }

    public void setRes_evaluation(String res_evaluation) {
        this.res_evaluation = res_evaluation;
    }

    @Override
    public String toString() {
        return "Resume{" +
                "res_id=" + res_id +
                ", res_name='" + res_name + '\'' +
                ", res_sex='" + res_sex + '\'' +
                ", res_bothday='" + res_bothday + '\'' +
                ", res_nation='" + res_nation + '\'' +
                ", res_natv='" + res_native + '\'' +
                ", res_address='" + res_address + '\'' +
                ", res_user_id='" + res_user_id + '\'' +
                ", res_phone='" + res_phone + '\'' +
                ", res_email='" + res_email + '\'' +
                ", res_graduate='" + res_graduate + '\'' +
                ", res_education='" + res_education + '\'' +
                ", res_skill='" + res_skill + '\'' +
                ", res_evaluation='" + res_evaluation + '\'' +
                '}';
    }
}
