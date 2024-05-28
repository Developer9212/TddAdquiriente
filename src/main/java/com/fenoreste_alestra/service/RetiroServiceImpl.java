package com.fenoreste_alestra.service;

import com.fenoreste_alestra.dao.RetiroDao;
import com.fenoreste_alestra.entity.Retiro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RetiroServiceImpl implements IRetiroService{

    @Autowired
    private RetiroDao retiroDao;

    @Override
    public Retiro guardarRetiro(Retiro retiro) {
        retiroDao.save(retiro);
        return retiro;
    }
}
