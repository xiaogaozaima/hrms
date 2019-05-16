package com.iotek.service;

import com.iotek.model.Admin;

public interface AdminService {
    Admin login(Admin admin);
    boolean regiest(Admin admin);
}
