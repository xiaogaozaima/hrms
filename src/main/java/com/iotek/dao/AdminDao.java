package com.iotek.dao;

import com.iotek.model.Admin;

public interface AdminDao {
    Admin getAdmin(Admin admin);
    boolean addAdmin(Admin admin);
}
