package com.iotek.service.impl;

import com.iotek.dao.StaffDao;
import com.iotek.model.Staff;
import com.iotek.service.StaffService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class StaffServiceImpl implements StaffService {
    @Resource
    private StaffDao staffDao;
    public Staff getStaff(Staff staff) {
        if(staff!=null){
            return staffDao.getStaff(staff);
        }
        return null;
    }

    public boolean addStaff(Staff staff) {
        if(staff!=null){
            return staffDao.addStaff(staff);
        }
        return false;
    }
}
