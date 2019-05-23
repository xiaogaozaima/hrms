package com.iotek.service.impl;

import com.iotek.dao.StaffDao;
import com.iotek.model.Staff;
import com.iotek.service.StaffService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

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

    public Staff stafflogin(Staff staff) {
        if(staff!=null){
            return staffDao.getStaff(staff);
        }
        return null;
    }

    public Staff getStaffById(Integer staff_id) {
        if(staff_id!=null){
            return staffDao.getStaffById(staff_id);
        }
        return null;
    }

    public List<Staff> getAllStaff() {
        return staffDao.getAllStaff();
    }
}
