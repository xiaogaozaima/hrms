package com.iotek.service.impl;

import com.iotek.dao.ResumeDao;
import com.iotek.model.Resume;
import com.iotek.model.User;
import com.iotek.service.ResumeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ResumeServiceImpl implements ResumeService {
    @Resource
    private ResumeDao resumeDao;

    public boolean addResume(Resume resume) {
        if(resume!=null){
            return resumeDao.addResume(resume);
        }
        return false;
    }

    public boolean updateResume(Resume resume) {
        if(resume!=null){
            return resumeDao.updateResume(resume);
        }
        return false;
    }

    public Resume getResumeByUid(User user) {
        if(user!=null){
            return resumeDao.getResumeByUid(user);
        }
        return null;
    }

    public Resume getResumeById(Integer id) {
        if(id!=null){
            return resumeDao.getResumeById(id);
        }
        return null;
    }

    /*public List<Resume> getResumeByUid(User user) {
        if(user!=null){
            return resumeDao.getResumeByUid(user);
        }
        return null;
    }*/
}
