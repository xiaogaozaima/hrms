package com.iotek.service;

import com.iotek.model.Staff;

public interface StaffService {
    Staff getStaff(Staff staff);
    boolean addStaff(Staff staff);
}
