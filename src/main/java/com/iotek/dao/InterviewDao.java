package com.iotek.dao;

import com.iotek.model.Interview;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface InterviewDao {
    boolean addInterview(Interview interview);
    boolean updateInterview(Interview interview);
    List<Interview> getAllInterview();
    Interview getInterviewById(@Param("int_id") Integer int_id);
    List<Interview> getInterviewByUid(@Param("int_user_id") Integer int_user_id);
    List<Interview> getInterviewByState(@Param("int_state") Integer int_state);


}
