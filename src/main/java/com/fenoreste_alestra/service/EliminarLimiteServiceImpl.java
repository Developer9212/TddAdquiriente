package com.fenoreste_alestra.service;

import com.fenoreste_alestra.dao.EliminarLimiteDao;
import com.fenoreste_alestra.entity.EliminarLimite;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EliminarLimiteServiceImpl implements IEliminarLimiteService{

    @Autowired
    private EliminarLimiteDao eliminarLimiteDao;

    @Override
    public EliminarLimite guardarLimite(EliminarLimite limite) {
        eliminarLimiteDao.save(limite);
        return limite;
    }
}
