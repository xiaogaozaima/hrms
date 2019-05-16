package com.iotek.service.impl;

import com.iotek.dao.DepartmentDao;
import com.iotek.model.Department;
import com.iotek.service.DepartmentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Resource
    private DepartmentDao departmentDao;

    public boolean addDept(Department department) {
        if(department!=null){
            return departmentDao.addDept(department);
        }
        return false;
    }

    public boolean deleteDept(Department department) {
        if(department!=null){
            return departmentDao.deleteDept(department);
        }
        return false;
    }

    public boolean updateDept(Department department) {
        if(department!=null){
            return departmentDao.updateDept(department);
        }
        return false;
    }

    public List<Department> getDepts() {
        List<Department> list = departmentDao.getDepts();
        if(list!=null && list.size()!=0){
            return list;
        }
        return null;
    }

    public Department getDeptByName(String dept_name) {
        if(dept_name!=null){
            return departmentDao.getDeptByName(dept_name);
        }
        return null;
    }
}
