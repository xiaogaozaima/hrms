package com.iotek.service;

import com.iotek.model.User;

public interface UserService {
    User login(User user);
    boolean regiest(User user);
    User getUserById(Integer user_id);
}
