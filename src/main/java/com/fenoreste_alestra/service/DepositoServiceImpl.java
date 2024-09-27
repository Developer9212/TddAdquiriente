package com.fenoreste_alestra.service;

import com.fenoreste_alestra.dao.DepositoDao;
import com.fenoreste_alestra.entity.Deposito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepositoServiceImpl implements IDepositoService{

    @Autowired
    private DepositoDao depositoDao;

    @Override
    public Deposito guardarDeposito(Deposito deposito) {
        depositoDao.save(deposito);
        return deposito;
    }
}
