package com.iotek.controller;

import com.iotek.model.Resume;
import com.iotek.model.User;
import com.iotek.service.ResumeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Controller
public class ResumeController {
    @Resource
    private ResumeService resumeService;

    @RequestMapping("addResume")
    public String addResume(Resume resume, HttpSession session)throws Exception{
        System.out.println(resume);
        boolean b = resumeService.addResume(resume);
        System.out.println(resume);
        session.setAttribute("resume",resume);
        return "success";

    }

    @RequestMapping("showResume")
    public String showResume(HttpSession session)throws Exception{
        User user = (User) session.getAttribute("user1");
        Resume resume = resumeService.getResumeByUid(user);
        session.setAttribute("resume",resume);
        return "error";
    }

    @RequestMapping("updateResume")
    public String updateResume(HttpSession session, Resume resume)throws Exception{
        boolean b = resumeService.updateResume(resume);
        if(b){
            return "success";
        }
        return "error";
    }

    @RequestMapping("deleteResume")
    public String deleteResume(HttpSession session, Resume resume)throws Exception{
        return null;
    }

}
