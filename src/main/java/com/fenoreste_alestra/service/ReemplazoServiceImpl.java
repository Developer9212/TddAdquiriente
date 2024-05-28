package com.fenoreste_alestra.service;

import com.fenoreste_alestra.dao.ReemplazoDao;
import com.fenoreste_alestra.entity.Reemplazo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReemplazoServiceImpl implements IReemplazoService{

    @Autowired
    private ReemplazoDao reemplazoDao;


    @Override
    public Reemplazo guardarReemplazo(Reemplazo reemplazo) {
        reemplazoDao.save(reemplazo);
        return reemplazo;
    }
}
