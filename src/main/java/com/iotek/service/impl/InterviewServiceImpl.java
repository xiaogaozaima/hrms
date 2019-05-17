package com.iotek.service.impl;

import com.iotek.dao.InterviewDao;
import com.iotek.model.Interview;
import com.iotek.service.InterviewService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class InterviewServiceImpl implements InterviewService {
    @Resource
    private InterviewDao interviewDao;

    public boolean addInterview(Interview interview) {
        if(interview!=null){
            return interviewDao.addInterview(interview);
        }
        return false;
    }

    public List<Interview> getAllInterview() {
        return interviewDao.getAllInterview();
    }
}
