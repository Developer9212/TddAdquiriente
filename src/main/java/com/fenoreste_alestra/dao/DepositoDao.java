package com.fenoreste_alestra.dao;

import com.fenoreste_alestra.entity.Deposito;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepositoDao extends JpaRepository<Deposito, Integer> {
}
