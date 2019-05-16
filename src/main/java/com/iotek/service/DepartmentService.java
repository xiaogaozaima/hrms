package com.iotek.service;

import com.iotek.model.Department;

import java.util.List;

public interface DepartmentService {
    boolean addDept(Department department);
    boolean deleteDept(Department department);
    boolean updateDept(Department department);

    List<Department> getDepts();

    Department getDeptByName(String dept_name);

}
