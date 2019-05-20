package com.iotek.service;

import com.iotek.model.Interview;

import java.util.List;

public interface InterviewService {
    boolean addInterview(Interview interview);
    List<Interview> getAllInterview();
    Interview getInterviewById(Integer int_id);


}
