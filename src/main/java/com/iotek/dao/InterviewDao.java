package com.iotek.dao;

import com.iotek.model.Interview;

import java.util.List;

public interface InterviewDao {
    boolean addInterview(Interview interview);
    List<Interview> getAllInterview();
}
