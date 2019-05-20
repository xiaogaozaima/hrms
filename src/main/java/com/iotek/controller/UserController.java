package com.iotek.controller;

import com.iotek.model.HiringTable;
import com.iotek.model.Interview;
import com.iotek.model.Resume;
import com.iotek.model.User;
import com.iotek.service.HiringService;
import com.iotek.service.InterviewService;
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
    @Resource
    private InterviewService interviewService;

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
        /*用户和简历*/
        session.setAttribute("u",user1);
        Resume resume = resumeService.getResumeByUid(user1);
        session.setAttribute("resume",resume);

        /*招聘信息*/
        List<HiringTable> hiringList = hiringService.getAllHiring();
        session.setAttribute("hiringList",hiringList);
        System.out.println("下面是投了简历的招聘表");
        System.out.println(hiringList);

        /*面试信息*/
        List<Interview> interviewList = interviewService.getAllInterview();
        session.setAttribute("interviewList",interviewList);
        System.out.println("下面是面试信息");
        System.out.println(interviewList);


        return "success";
    }





}
