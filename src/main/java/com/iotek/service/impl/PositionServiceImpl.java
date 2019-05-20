package com.iotek.service.impl;

import com.iotek.dao.PositionDao;
import com.iotek.model.Department;
import com.iotek.model.Position;
import com.iotek.service.PositionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class PositionServiceImpl implements PositionService {
    @Resource
    private PositionDao positionDao;

    public boolean addPosition(Position position) {
        if(position!=null){
            return positionDao.addPosition(position);
        }
        return false;
    }

    public boolean deletePosition(Position position) {
        if(position!=null){
            return positionDao.deletePosition(position);
        }
        return false;
    }

    public boolean deletePositionByDept(Department department) {
        if(department!=null){
            return positionDao.deletePositionByDept(department);
        }
        return false;
    }

    public boolean updatePosition(Position position) {
        if(position!=null){
            return positionDao.updatePosition(position);
        }
        return false;
    }

    public List<Position> getAllPosition() {
        List<Position> positionList = positionDao.getAllPosition();
        return positionList;
    }

    public Position getPositionById(Integer pos_id) {
        if(pos_id!=null){
            return positionDao.getPositionById(pos_id);
        }
        return null;
    }

    public Position getPositionByName(String pos_name) {
        if(pos_name!=null){
            return positionDao.getPositionByName(pos_name);
        }
        return null;
    }

}
