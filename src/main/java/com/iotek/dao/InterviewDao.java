package com.iotek.dao;

import com.iotek.model.Interview;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface InterviewDao {
    boolean addInterview(Interview interview);
    List<Interview> getAllInterview();
    Interview getInterviewById(@Param("int_id") Integer int_id);
}
