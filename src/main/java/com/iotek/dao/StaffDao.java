package com.iotek.dao;

import com.iotek.model.Staff;

public interface StaffDao {
    Staff getStaff(Staff staff);
    boolean addStaff(Staff staff);
}
