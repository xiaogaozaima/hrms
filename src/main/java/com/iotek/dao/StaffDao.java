package com.iotek.dao;

import com.iotek.model.Staff;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StaffDao {
    Staff getStaff(Staff staff);
    boolean addStaff(Staff staff);
    Staff getStaffById(@Param("staff_id") Integer staff_id);

    List<Staff> getAllStaff();

}
