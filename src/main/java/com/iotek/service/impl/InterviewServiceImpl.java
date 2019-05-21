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

    public boolean updateInterview(Interview interview) {
        if(interview!=null){
            return interviewDao.updateInterview(interview);
        }
        return false;
    }

    public List<Interview> getAllInterview() {
        return interviewDao.getAllInterview();
    }

    public Interview getInterviewById(Integer int_id) {
        if(int_id!=null){
            return interviewDao.getInterviewById(int_id);
        }
        return null;
    }

    public List<Interview> getInterviewByUid(Integer int_user_id) {
        if(int_user_id!=null){
            return interviewDao.getInterviewByUid(int_user_id);
        }
        return null;
    }

    public List<Interview> getInterviewByState(Integer int_state) {
        if(int_state!=null){
            return interviewDao.getInterviewByState(int_state);
        }
        return null;
    }
}
