package com.iotek.controller;

import com.iotek.model.*;
import com.iotek.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class HiringController {
    @Resource
    private HiringService hiringService;
    @Resource
    private UserService userService;
    @Resource
    private ResumeService resumeService;
    @Resource
    private RecruitService recruitService;
    @Resource
    private DepartmentService departmentService;
    @Resource
    private PositionService positionService;



    /*查看招聘表所有记录*/
    @RequestMapping("showHiringDetail")
    public String showHiringDetail(HttpServletRequest request, HttpSession session)throws Exception{
        Integer hir_id = Integer.parseInt(request.getParameter("hir_id"));
        Integer user_id = Integer.parseInt(request.getParameter("user_id"));
        User user = userService.getUserById(user_id);
        session.setAttribute("user",user);
        HiringTable hiring = hiringService.getHiringById(hir_id);
        System.out.println("hiring"+hiring);
        session.setAttribute("hiringTable",hiring);
        System.out.println("hir_id="+hir_id);
        //return "test";
        return "hiringDetail";
    }

    /*投递简历*/
    @RequestMapping("postResume")
    public String postResume(HttpServletRequest request,HttpSession session,HiringTable hiringTable)throws Exception{
        System.out.println("postResume里面的hiring"+hiringTable);
        Integer user_id = Integer.parseInt(request.getParameter("user_id"));
        User user = userService.getUserById(user_id);
        Resume resume = resumeService.getResumeByUid(user);

        Integer hir_id = Integer.parseInt(request.getParameter("hir_id"));
        HiringTable hiring = hiringService.getHiringById(hir_id);

        /*不能对一个招聘重复投递简历*/
        if(recruitService.getRecruitByResId(resume.getRes_id(),hir_id)!=null) {
            return "error";
        }else {
            /*没投递过的可以投递*/
            Recruit recruit = new Recruit();
            recruit.setRec_hir_id(hir_id);
            recruit.setRec_res_id(resume.getRes_id());
            boolean b = recruitService.addRecruit(recruit);
            if(b){
                return "success";
            }
        }

        return "error";
    }

    @RequestMapping("addHiring")
    public String addHiring(HttpServletRequest request,HttpSession session)throws Exception{
        String dept_name = request.getParameter("dept_name");
        String pos_name = request.getParameter("pos_name");
        String hir_disc = request.getParameter("hir_disc");

        Department d = departmentService.getDeptByName(dept_name);
        Position p = positionService.getPositionByName(pos_name);

        HiringTable hiringTable = new HiringTable();
        hiringTable.setHir_dept_id(d.getDept_id());
        hiringTable.setHir_pos_id(p.getPos_id());
        hiringTable.setHir_disc(hir_disc);

        boolean b = hiringService.addHiring(hiringTable);
        if(b){
            return "adminPage";
        }
        return "error";
    }
}
