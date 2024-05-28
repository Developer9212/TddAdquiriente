package com.fenoreste_alestra.service;

import com.fenoreste_alestra.dao.BitsInformacionDao;
import com.fenoreste_alestra.entity.BitsInformacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BistInformacionServiceImpl implements IBistInformacionService {

    @Autowired
    private BitsInformacionDao bitsInformacionDao;

    @Override
    public BitsInformacion guardarBitsInformacion(BitsInformacion bitsInformacion) {
        bitsInformacionDao.save(bitsInformacion);
        return bitsInformacion;
    }
}
