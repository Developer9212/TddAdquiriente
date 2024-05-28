package com.fenoreste_alestra.service;

import com.fenoreste_alestra.dao.NipDao;
import com.fenoreste_alestra.entity.Nip;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NipServiceImpl implements  INipService{

    @Autowired
    private NipDao nipDao;

    @Override
    public Nip guardarNip(Nip nip) {
        nipDao.save(nip);
        return nip;
    }
}
