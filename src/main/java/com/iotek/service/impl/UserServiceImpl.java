package com.iotek.service.impl;

import com.iotek.dao.UserDao;
import com.iotek.model.User;
import com.iotek.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;

    public User login(User user) {
        if(user!=null){
            return userDao.getUser(user);
        }
        return null;
    }

    public boolean regiest(User user) {
        if(user!=null){
           return userDao.addUser(user);
        }
        return false;
    }
}
