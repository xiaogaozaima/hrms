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
    @Resource
    private HiringService hiringService;
    @Resource
    private DepartmentService departmentService;
    @Resource
    private PositionService positionService;

    @RequestMapping("adminlogin")
    public String adminLogin(Admin admin, HttpSession session)throws Exception{
        Admin admin1 = adminService.login(admin);
        if(admin1!=null){
            session.setAttribute("ad",admin1);

            List<Recruit> recruitList = recruitService.getAllRecruit();
            List<Interview> interviewList = interviewService.getAllInterview();
            /*全部招聘信息*/
            List<HiringTable> hiringTables = hiringService.getAllHiring();
            session.setAttribute("hiringTables",hiringTables);
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

    /*管理员查看简历详情，通过传递过来的简历id得到简历，通过传递过来的招聘表id得到
    招聘表中部门职位的id，跳转到简历详情页面*/
    @RequestMapping("beforeInterview")
    public String beforeInterview(HttpSession session, HttpServletRequest request)throws Exception{
        Integer res_id = Integer.parseInt(request.getParameter("method"));
        System.out.println("简历的id："+res_id);
        Integer res_hir_id = Integer.parseInt(request.getParameter("method1"));
        System.out.println("招聘的id："+res_hir_id);
        HiringTable hiring = hiringService.getHiringById(res_hir_id);
        System.out.println("招聘信息："+hiring);
        Resume resume = resumeService.getResumeById(res_id);
        System.out.println("简历："+resume);

        User user = userService.getUserById(resume.getRes_user_id());
        session.setAttribute("resume",resume);
        session.setAttribute("hiring",hiring);
        session.setAttribute("user",user);
        return "AdminResumeDetail";
    }

    /*得到一个简历和一个招聘表id，安排面试*/
    @RequestMapping("addInterview")
    public String addInterview(Resume resume,HttpSession session,HttpServletRequest request)throws Exception{
        Interview interview = new Interview();
        interview.setInt_user_id(resume.getRes_user_id());
        session.setAttribute("resume",resume);
        boolean b = interviewService.addInterview(interview);

        /*通过request得到一条招聘信息*/
        Integer hiring_id = Integer.parseInt(request.getParameter("hiring_id"));
        HiringTable hiring = hiringService.getHiringById(hiring_id);
        System.out.println("通过request得到一条招聘信息"+hiring);

        /*通过request得到一个用户*/
        Integer user_id = Integer.parseInt(request.getParameter("user_id"));
        User user = userService.getUserById(user_id);
        System.out.println("通过request得到一个用户"+user);

       if(b){
            List<Recruit> recruitList = recruitService.getAllRecruit();
            session.setAttribute("recruitList",recruitList);
            /*String dept_name = departmentService.getDeptId(hiring.getHir_dept_id()).getDept_name();
            String pos_name = positionService.getPositionById(hiring.getHir_pos_id()).getPos_name();
            session.setAttribute("dept_name",dept_name);
            session.setAttribute("pos_name",pos_name);*/
            session.setAttribute("user",user);

           return "adminPage";
        }
        return "error";
    }
    @RequestMapping("addStaff")
    public String addStaff(HttpServletRequest request,HttpSession session)throws Exception{
        Integer int_id = Integer.parseInt(request.getParameter("method"));
        Integer user_id = Integer.parseInt(request.getParameter("method1"));
        User u = userService.getUserById(user_id);
        Staff staff = new Staff();
        staff.setStaff_name(u.getUser_name()+"hrm");
        staff.setStaff_password("a123456");
        boolean b = staffService.addStaff(staff);
        if(b){
            List<Interview> interviewList = interviewService.getAllInterview();
            session.setAttribute("interviewList",interviewList);
            return "adminPage";
        }
        return "error";

    }
}
