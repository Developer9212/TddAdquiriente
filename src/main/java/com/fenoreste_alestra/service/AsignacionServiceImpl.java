package com.fenoreste_alestra.service;

import com.fenoreste_alestra.dao.AsignacionDao;
import com.fenoreste_alestra.entity.Asignacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AsignacionServiceImpl implements IAsignacionService{

    @Autowired
    private AsignacionDao asignacionDao;

    @Override
    public Asignacion guardarAsignacion(Asignacion asignacion) {
        asignacionDao.save(asignacion);
        return asignacion;
    }
}
