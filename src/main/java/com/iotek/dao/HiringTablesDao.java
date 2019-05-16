package com.iotek.dao;

import com.iotek.model.HiringTable;

import java.util.List;

public interface HiringTablesDao {
    List<HiringTable> getAllHiring();

    HiringTable getHiringById(Integer hir_id);

}
