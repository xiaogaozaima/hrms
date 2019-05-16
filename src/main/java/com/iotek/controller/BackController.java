package com.iotek.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BackController {

    @RequestMapping("backToUserLogin")
    public String backToUserLogin()throws Exception{
        return "../../userlogin";
    }
    @RequestMapping("backToEnter")
    public String backToEnter()throws Exception{
        return "../../index";
    }
    @RequestMapping("backToAdmin")
    public String backToAdmin()throws Exception{
        return "../../adminlogin";
    }
}
