package com.iotek.service;

import com.iotek.model.Staff;

import java.util.List;

public interface StaffService {
    Staff getStaff(Staff staff);
    boolean addStaff(Staff staff);
    //User login(User user);
    Staff stafflogin(Staff staff);
    Staff getStaffById(Integer staff_id);

    List<Staff> getAllStaff();

}
