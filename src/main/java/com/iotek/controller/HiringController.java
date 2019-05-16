package com.iotek.controller;

import com.iotek.model.HiringTable;
import com.iotek.model.Recruit;
import com.iotek.model.Resume;
import com.iotek.model.User;
import com.iotek.service.HiringService;
import com.iotek.service.RecruitService;
import com.iotek.service.ResumeService;
import com.iotek.service.UserService;
import org.omg.PortableInterceptor.INACTIVE;
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

    @RequestMapping("postResume")
    public String postResume(HttpServletRequest request,HttpSession session,HiringTable hiringTable)throws Exception{
        System.out.println("postResume里面的hiring"+hiringTable);
        Integer user_id = Integer.parseInt(request.getParameter("user_id"));
        User user = userService.getUserById(user_id);
        Resume resume = resumeService.getResumeByUid(user);

        Integer hir_id = Integer.parseInt(request.getParameter("hir_id"));
        HiringTable hiring = hiringService.getHiringById(hir_id);

        Recruit recruit = new Recruit();
        recruit.setRec_hir_id(hir_id);
        recruit.setRec_res_id(resume.getRes_id());
        boolean b = recruitService.addRecruit(recruit);
        if(b){
            return "hiringDetail";
        }
        return "error";
    }
}
