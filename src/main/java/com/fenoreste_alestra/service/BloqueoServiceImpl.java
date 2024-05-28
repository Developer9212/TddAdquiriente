package com.fenoreste_alestra.service;

import com.fenoreste_alestra.dao.BloqueoDao;
import com.fenoreste_alestra.entity.Bloqueo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BloqueoServiceImpl implements IBloqueoService{

    @Autowired
    private BloqueoDao bloqueoDao;

    @Override
    public Bloqueo guardarBloqueo(Bloqueo bloqueo) {
        bloqueoDao.save(bloqueo);
        return bloqueo;
    }
}
