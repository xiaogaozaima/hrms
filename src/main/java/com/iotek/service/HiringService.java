package com.iotek.service;

import com.iotek.model.HiringTable;

import java.util.List;

public interface HiringService {
    List<HiringTable> getAllHiring();
    HiringTable getHiringById(Integer hir_id);

    boolean addHiring(HiringTable hiringTable);
}
