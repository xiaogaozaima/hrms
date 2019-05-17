package com.iotek.service;

import com.iotek.model.Resume;
import com.iotek.model.User;

public interface ResumeService {
    boolean addResume(Resume resume);
    boolean updateResume(Resume resume);
    Resume getResumeByUid(User user);
    Resume getResumeById(Integer id);
    //List<Resume> getResumeByUid(User user);
}
