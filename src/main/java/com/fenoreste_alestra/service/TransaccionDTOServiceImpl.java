package com.fenoreste_alestra.service;

import com.fenoreste_alestra.dao.TransaccionDTODao;
import com.fenoreste_alestra.dao.TransaccionDao;
import com.fenoreste_alestra.entity.TransaccionDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransaccionDTOServiceImpl implements ITransaccionDTOService{

    @Autowired
    private TransaccionDTODao transaccionDTODao;

    @Override
    public TransaccionDTO guardarTransaccionDTO(TransaccionDTO transaccionDTO) {
        transaccionDTODao.save(transaccionDTO);
        return transaccionDTO;
    }
}
