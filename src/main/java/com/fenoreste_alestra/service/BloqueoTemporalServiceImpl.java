package com.fenoreste_alestra.service;

import com.fenoreste_alestra.dao.BloqueoTemporalDao;
import com.fenoreste_alestra.entity.BloqueoTemporal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BloqueoTemporalServiceImpl implements IBloqueoTemporalService{

    @Autowired
    private BloqueoTemporalDao bloqueoTemporalDao;

    @Override
    public BloqueoTemporal guardaBloqueoTemporal(BloqueoTemporal bloqueo) {
        bloqueoTemporalDao.save(bloqueo);
        return bloqueo;
    }
}
