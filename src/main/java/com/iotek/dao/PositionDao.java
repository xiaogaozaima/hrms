package com.iotek.dao;

import com.iotek.model.Department;
import com.iotek.model.Position;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PositionDao {
    boolean addPosition(Position position);
    boolean deletePosition(Position position);//删除单独一个职位
    boolean deletePositionByDept(Department department);//通过部门删除职位
    boolean updatePosition(Position position);//只能更改职位名称

    List<Position> getAllPosition();
    Position getPositionById(Integer pos_id);
    Position getPositionByName(@Param("pos_name") String pos_name);
}
