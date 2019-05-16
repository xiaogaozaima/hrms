package com.iotek.controller;

import com.iotek.model.HiringTable;
import com.iotek.model.Resume;
import com.iotek.model.User;
import com.iotek.service.HiringService;
import com.iotek.service.ResumeService;
import com.iotek.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class UserController {
    @Resource
    private UserService userService;
    @Resource
    private ResumeService resumeService;
    @Resource
    private HiringService hiringService;

    @RequestMapping("userregiste")
    public String userregiste(User user, Model model, HttpSession session) throws Exception{
        boolean b = userService.regiest(user);
        //model.addAttribute("u",user1);
        return "../../userlogin";
    }

    @RequestMapping("userlogin")
    public String userlogin(User user, Model model, HttpSession session, HttpServletResponse response) throws Exception{
        User user1 = userService.login(user);
        if(user1==null){
            return "../../userlogin";
        }
        session.setAttribute("u",user1);
        Resume resume = resumeService.getResumeByUid(user1);
        session.setAttribute("resume",resume);

        List<HiringTable> hiringList = hiringService.getAllHiring();
        session.setAttribute("hiringList",hiringList);
        System.out.println(hiringList);
        return "success";
    }





}
