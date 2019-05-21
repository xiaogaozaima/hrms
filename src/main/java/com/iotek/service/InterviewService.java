package com.iotek.service;

import com.iotek.model.Interview;

import java.util.List;

public interface InterviewService {
    boolean addInterview(Interview interview);
    boolean updateInterview(Interview interview);

    List<Interview> getAllInterview();
    Interview getInterviewById(Integer int_id);
    List<Interview> getInterviewByUid(Integer int_user_id);
    List<Interview> getInterviewByState(Integer int_state);


}
