package com.iotek.dao;

import com.iotek.model.Recruit;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RecruitDao {
    boolean addRecruit(Recruit recruit);
    boolean deleteRecruit(Recruit recruit);
    Recruit getRecruitByResId(@Param("rec_res_id") Integer rec_res_id, @Param("hiring") Integer hiring);
    List<Recruit> getAllRecruit();
    List<Recruit> getRecruitByHirid(@Param("rec_hir_id")Integer rec_hir_id);
}
