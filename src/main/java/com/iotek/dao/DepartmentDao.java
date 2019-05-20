package com.iotek.dao;

import com.iotek.model.Department;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DepartmentDao {
    boolean addDept(Department department);
    boolean deleteDept(Department department);
    boolean updateDept(Department department);

    List<Department> getDepts();

    Department getDeptByName(@Param("dept_name") String dept_name);
    Department getDeptId(@Param("dept_id") Integer dept_id);

}
