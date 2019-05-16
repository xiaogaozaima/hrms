package com.iotek.service.impl;

import com.iotek.dao.AdminDao;
import com.iotek.model.Admin;
import com.iotek.service.AdminService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class AdminServiceImpl implements AdminService {

    @Resource
    private AdminDao adminDao;

    public Admin login(Admin admin) {
        if(admin!=null){
            return adminDao.getAdmin(admin);
        }
        return null;
    }

    public boolean regiest(Admin admin) {
        if(admin!=null){
            return adminDao.addAdmin(admin);
        }
        return false;
    }
}
