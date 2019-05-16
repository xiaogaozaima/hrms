package com.iotek.dao;

import com.iotek.model.Recruit;

public interface RecruitDao {
    boolean addRecruit(Recruit recruit);
    boolean deleteRecruit(Recruit recruit);
}
