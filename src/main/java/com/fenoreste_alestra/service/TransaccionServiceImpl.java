package com.fenoreste_alestra.service;

import com.fenoreste_alestra.dao.TransaccionDao;
import com.fenoreste_alestra.entity.Transaccion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransaccionServiceImpl implements ITransaccionService{

    @Autowired
    private TransaccionDao transaccionDao;

    @Override
    public Transaccion guardarTransaccion(Transaccion transaccion) {
        transaccionDao.save(transaccion);
        return transaccion;
    }

    @Override
    public Integer valorProximo() {
        return transaccionDao.valorSiguiente();
    }

    @Override
    public Transaccion obtenerTransaccion(Integer id) {
        return transaccionDao.findById(id).orElse(null);
    }
}
