package com.fenoreste_alestra.service;

import com.fenoreste_alestra.dao.ModificarLimiteDao;
import com.fenoreste_alestra.entity.ModificarLimite;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ModificarLimiteServiceImpl implements IModificarLimiteService{

    @Autowired
    private ModificarLimiteDao modificarLimiteDao;


    @Override
    public ModificarLimite guardarLimite(ModificarLimite modificarLimite) {
        modificarLimiteDao.save(modificarLimite);
        return modificarLimite;
    }
}
