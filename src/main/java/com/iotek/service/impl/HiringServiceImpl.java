package com.iotek.service.impl;

import com.iotek.dao.HiringTablesDao;
import com.iotek.model.HiringTable;
import com.iotek.service.HiringService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class HiringServiceImpl implements HiringService {
    @Resource
    private HiringTablesDao hiringDao;

    public List<HiringTable> getAllHiring() {
        return hiringDao.getAllHiring();
    }

    public HiringTable getHiringById(Integer hir_id) {
        if(hir_id!=null){
            return hiringDao.getHiringById(hir_id);
        }
        return null;
    }
}
