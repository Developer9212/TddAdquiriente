package com.fenoreste_alestra.service;

import com.fenoreste_alestra.dao.InformacionDao;
import com.fenoreste_alestra.entity.Informacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InformacionServiceImpl implements IInformacionService {

    @Autowired
    private InformacionDao informacionDao;

    @Override
    public Informacion guardarInformacion(Informacion informacion) {
        informacionDao.save(informacion);
        return informacion;
    }
}
