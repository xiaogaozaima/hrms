package com.iotek.controller;

import com.iotek.model.Admin;
import com.iotek.service.AdminService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Controller
public class AdminController {
    @Resource
    private AdminService adminService;

    @RequestMapping
    public String adminLogin(Admin admin, HttpSession session)throws Exception{
        Admin admin1 = adminService.login(admin);
        if(admin1!=null){
            session.setAttribute("ad",admin1);
            return "adminPage";
        }
        return "error";
    }

}
