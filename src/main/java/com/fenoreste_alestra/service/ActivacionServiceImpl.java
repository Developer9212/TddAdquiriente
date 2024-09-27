package com.fenoreste_alestra.service;

import com.fenoreste_alestra.dao.ActivacionDao;
import com.fenoreste_alestra.entity.Activacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ActivacionServiceImpl implements IActivacionService{
   
	@Autowired
    private ActivacionDao activacionDao;

    @Override
    public void guardarActive(Activacion active) {
        activacionDao.save(active);
    }
}
