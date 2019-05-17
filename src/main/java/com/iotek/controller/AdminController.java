package com.iotek.controller;

import com.iotek.model.*;
import com.iotek.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class AdminController {
    @Resource
    private AdminService adminService;
    @Resource
    private RecruitService recruitService;
    @Resource
    private ResumeService resumeService;
    @Resource
    private InterviewService interviewService;
    @Resource
    private UserService userService;
    @Resource
    private StaffService staffService;

    @RequestMapping("adminlogin")
    public String adminLogin(Admin admin, HttpSession session)throws Exception{
        Admin admin1 = adminService.login(admin);
        if(admin1!=null){
            session.setAttribute("ad",admin1);

            List<Recruit> recruitList = recruitService.getAllRecruit();
            List<Interview> interviewList = interviewService.getAllInterview();
            /*List<Resume> resumeList = new ArrayList<Resume>();
            for(Recruit recruit : recruitList){
                Resume resume = resumeService.getResumeById(recruit.getRec_res_id());
                resumeList.add(resume);
            }
            session.setAttribute("resumeList",resumeList);*/
            session.setAttribute("recruitList",recruitList);
            session.setAttribute("interviewList",interviewList);
            return "adminPage";
        }
        return "error";
    }

    @RequestMapping("beforeInterview")
    public String beforeInterview(HttpSession session, HttpServletRequest request)throws Exception{
        Integer res_id = Integer.parseInt(request.getParameter("method"));
        Resume resume = resumeService.getResumeById(res_id);
        session.setAttribute("resume",resume);
        return "addInterview";
    }

    @RequestMapping("addInterview")
    public String addInterview(Resume resume)throws Exception{
        System.out.println("admincon的resume"+resume);
        Interview interview = new Interview();
        System.out.println("addinter"+interview);
        interview.setInt_user_id(resume.getRes_user_id());
        boolean b = interviewService.addInterview(interview);
        if(b){
            return "adminPage";
        }
        return "error";
    }
    @RequestMapping("addStaff")
    public String addStaff(HttpServletRequest request)throws Exception{
        Integer int_id = Integer.parseInt(request.getParameter("method"));
        Integer user_id = Integer.parseInt(request.getParameter("method1"));
        User u = userService.getUserById(user_id);
        Staff staff = new Staff();
        staff.setStaff_name(u.getUser_name()+"hrm");
        staff.setStaff_password("a123456");
        boolean b = staffService.addStaff(staff);
        if(b){
            return "adminPage";
        }
        return "error";

    }
}
