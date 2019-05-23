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
    @Resource
    private RAndPService rAndPService;
    @Resource
    private CheckService checkService;
    @Resource
    private TrainService trainService;

    /*管理员登录*/
    @RequestMapping("adminlogin")
    public String adminLogin(Admin admin, HttpSession session)throws Exception{
        Admin admin1 = adminService.login(admin);
        if(admin1!=null){
            session.setAttribute("ad",admin1);
            /*全部简历投递信息*/
            List<Recruit> recruitList = recruitService.getAllRecruit();

            /*选择员工查询考勤和奖惩*/
            List<Staff> allStaff = staffService.getAllStaff();
            session.setAttribute("allStaff",allStaff);

            /*查出员工考勤过的年月*//*
            List<String> ymlist = rAndPService.getRAndPYm(staff_id);
            session.setAttribute("ymlist",ymlist);
            return "staffCheckWork";*/

            /*查出所有的打卡的年月*/
            List<String> ymlist = checkService.getCheckByYm();
            session.setAttribute("ymlist",ymlist);

            /*得到各种面试*/
            List<Interview> interviews0 = interviewService.getInterviewByState(0);
            List<Interview> interviews1 = interviewService.getInterviewByState(1);
            List<Interview> interviews2 = interviewService.getInterviewByState(2);
            List<Interview> interviews3 = interviewService.getInterviewByState(3);
            session.setAttribute("interviews0",interviews0);
            session.setAttribute("interviews1",interviews1);
            session.setAttribute("interviews2",interviews2);
            session.setAttribute("interviews3",interviews3);
            /*全部招聘信息*/
            List<HiringTable> hiringTables = hiringService.getAllHiring();
            session.setAttribute("hiringTables",hiringTables);
            session.setAttribute("recruitList",recruitList);
            return "adminPage";
        }
        return "error";
    }

    /*管理员查看简历详情，通过传递过来的简历id得到简历，通过传递过来的招聘表id得到
    招聘表中部门职位的id，跳转到简历详情页面*/
    @RequestMapping("beforeInterview")
    public String beforeInterview(HttpSession session, HttpServletRequest request)throws Exception{
        Integer res_id = Integer.parseInt(request.getParameter("method"));
        Integer res_hir_id = Integer.parseInt(request.getParameter("method1"));
        HiringTable hiring = hiringService.getHiringById(res_hir_id);
        Resume resume = resumeService.getResumeById(res_id);

        Department d = departmentService.getDeptId(hiring.getHir_dept_id());
        Position p = positionService.getPositionById(hiring.getHir_pos_id());

        User user = userService.getUserById(resume.getRes_user_id());
        session.setAttribute("resume",resume);
        session.setAttribute("hiring",hiring);
        session.setAttribute("user",user);
        session.setAttribute("dept",d);
        session.setAttribute("pos",p);
        return "AdminResumeDetail";
    }

    /*得到一个简历和一个招聘表id，安排面试*/
    @RequestMapping("addInterview")
    public String addInterview(Resume resume,HttpSession session,HttpServletRequest request)throws Exception{
        Integer dept_id = Integer.parseInt(request.getParameter("dept_id"));
        Integer pos_id = Integer.parseInt(request.getParameter("pos_id"));
        /*创建面试*/
        Interview interview = new Interview();
        interview.setInt_user_id(resume.getRes_user_id());
        interview.setInt_dept_id(dept_id);
        interview.setInt_pos_id(pos_id);
        interview.setInt_address(request.getParameter("int_address"));
        interview.setInt_time(request.getParameter("int_time"));
        interview.setInt_contact(request.getParameter("int_contact"));
        interview.setInt_conphone(request.getParameter("int_conphone"));
        interview.setInt_state(0);
        System.out.println(interview);

        boolean b = interviewService.addInterview(interview);
        System.out.println(interview);

        session.setAttribute("resume",resume);
        System.out.println(resume);

        /*通过request得到一条招聘信息*/
        Integer hiring_id = Integer.parseInt(request.getParameter("hiring_id"));
        HiringTable hiring = hiringService.getHiringById(hiring_id);

        /*通过request得到一个用户*/
        Integer user_id = Integer.parseInt(request.getParameter("user_id"));
        User user = userService.getUserById(user_id);

       if(b){
            List<Recruit> recruitList = recruitService.getAllRecruit();
            session.setAttribute("recruitList",recruitList);
            session.setAttribute("user",user);

            /*得到各种面试*/
            List<Interview> interviews0 = interviewService.getInterviewByState(0);
            List<Interview> interviews1 = interviewService.getInterviewByState(1);
            List<Interview> interviews2 = interviewService.getInterviewByState(2);
            List<Interview> interviews3 = interviewService.getInterviewByState(3);
            session.setAttribute("interviews0",interviews0);
            session.setAttribute("interviews1",interviews1);
            session.setAttribute("interviews2",interviews2);
            session.setAttribute("interviews3",interviews3);
           return "adminPage";
        }
        return "error";
    }

    /*录取即添加员工*/
    @RequestMapping("addStaff")
    public String addStaff(HttpServletRequest request,HttpSession session)throws Exception{
        //获得面试信息
        Integer int_id = Integer.parseInt(request.getParameter("method"));
        Interview i = interviewService.getInterviewById(int_id);
        System.out.println(i);
        i.setInt_state(3);
        boolean b1 = interviewService.updateInterview(i);
        System.out.println(i);

        //获得用户信息
        Integer user_id = Integer.parseInt(request.getParameter("method1"));
        User u = userService.getUserById(user_id);

        //创建新员工
        Staff staff = new Staff();
        staff.setStaff_name(u.getUser_name()+"hrm");
        staff.setStaff_password("a123456");
        staff.setStaff_dept_id(i.getInt_dept_id());
        staff.setStaff_pos_id(i.getInt_pos_id());
        boolean b = staffService.addStaff(staff);
        if(b && b1){
            List<Interview> interviewList = interviewService.getInterviewByState(1);
            session.setAttribute("interviews1",interviewList);

            return "adminPage";
        }
        return "error";

    }

    /*收到的简历*/
    @RequestMapping("receivedResume")
    public String receivedResume(HttpSession session,HttpServletRequest request)throws Exception{
        /*招聘信息*/
        Integer hir_id = Integer.parseInt(request.getParameter("hir_id"));
        HiringTable hiring = hiringService.getHiringById(hir_id);
        session.setAttribute("hiring",hiring);

        /*招聘部门*/
        Integer dept_id = Integer.parseInt(request.getParameter("dept_id"));
        Department d = departmentService.getDeptId(dept_id);
        session.setAttribute("dept",d);

        /*招聘职位*/
        Integer pos_id = Integer.parseInt(request.getParameter("pos_id"));
        Position p = positionService.getPositionById(pos_id);
        session.setAttribute("pos",p);

        /*投递的简历*/
        List<Recruit> recruits = recruitService.getRecruitByHirid(hir_id);
        session.setAttribute("recruits",recruits);
        List<Resume> resumes = new ArrayList<Resume>();
        if(recruits!=null){
            for(Recruit r : recruits){
                Resume res = resumeService.getResumeById(r.getRec_res_id());
                resumes.add(res);
            }
        }
        System.out.println(resumes);
        session.setAttribute("resumes",resumes);


        return "receivedResume";
    }

    @RequestMapping("adminCheAndRap")
    public String adminCheAndRap(HttpServletRequest request,HttpSession session)throws Exception{
        Integer staff_id = Integer.parseInt(request.getParameter("allStaff"));
        Staff staff = staffService.getStaffById(staff_id);
        session.setAttribute("staff",staff);
        String ym = request.getParameter("ym");

        /*通过员工id和年月查出考勤记录*/
        List<CheckWork> checkWorks = checkService.getCheckBySidYm(staff_id,ym);
        System.out.println(checkWorks);
        session.setAttribute("checkWorks",checkWorks);

        /*通过员工id和年月查奖惩表*/
        List<RewardAndPunish> raps = rAndPService.getRAndPByStaffIdYm(staff_id,ym);
        Double total = 0.0;
        for(RewardAndPunish r : raps){
            total+=r.getRap_money();
        }
        System.out.println(raps);
        session.setAttribute("raps",raps);
        session.setAttribute("total",total);

        return "adminCheAndRap";
    }


    @RequestMapping("addTrain")
    public String addTrain(Train train,HttpSession session)throws Exception{
        System.out.println(train);
        train.setTra_state(0);
        boolean b = trainService.addTrain(train);
        if(b){
            session.setAttribute("train",train);
        }
        return "train";
    }


}

