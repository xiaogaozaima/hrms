package com.iotek.service.impl;

import com.iotek.dao.RecruitDao;
import com.iotek.model.Recruit;
import com.iotek.service.RecruitService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class RecruitServiceImpl implements RecruitService {
    @Resource
    private RecruitDao recruitDao;

    public boolean addRecruit(Recruit recruit) {
        if(recruit!=null){
            return recruitDao.addRecruit(recruit);
        }
        return false;
    }

    public boolean deleteRecruit(Recruit recruit) {
        if(recruit!=null){
            return recruitDao.deleteRecruit(recruit);
        }
        return false;
    }

    public Recruit getRecruitByResId(Integer rec_res_id,Integer hiring) {
        if(rec_res_id!=null){
            return recruitDao.getRecruitByResId(rec_res_id,hiring);
        }
        return null;
    }

    public List<Recruit> getAllRecruit() {
        return recruitDao.getAllRecruit();
    }
}
