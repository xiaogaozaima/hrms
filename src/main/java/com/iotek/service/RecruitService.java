package com.iotek.service;

import com.iotek.model.Recruit;

import java.util.List;

public interface RecruitService {
    boolean addRecruit(Recruit recruit);
    boolean deleteRecruit(Recruit recruit);
    Recruit getRecruitByResId(Integer rec_res_id,Integer hiring);
    List<Recruit> getAllRecruit();
}
