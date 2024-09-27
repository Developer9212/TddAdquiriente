package com.fenoreste_alestra.service;

import com.fenoreste_alestra.dao.SaldoDao;
import com.fenoreste_alestra.entity.Saldo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SaldoServiceImpl implements ISaldoService{

    @Autowired
    private SaldoDao saldoDao;

    @Override
    public Saldo guardarSaldo(Saldo saldo) {
        saldoDao.save(saldo);
        return saldo;
    }
}
