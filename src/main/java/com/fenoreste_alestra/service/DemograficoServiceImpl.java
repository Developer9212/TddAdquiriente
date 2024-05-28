package com.fenoreste_alestra.service;

import com.fenoreste_alestra.dao.DemograficoDao;
import com.fenoreste_alestra.entity.Demografico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DemograficoServiceImpl implements IDemograficoService{

    @Autowired
    private DemograficoDao demograficoDao;

    @Override
    public Demografico guardaDemografico(Demografico demografico) {
        return demograficoDao.save(demografico);
    }
}
