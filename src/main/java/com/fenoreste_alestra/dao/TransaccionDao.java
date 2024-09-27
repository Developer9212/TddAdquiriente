package com.fenoreste_alestra.dao;

import com.fenoreste_alestra.entity.Transaccion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TransaccionDao extends JpaRepository<Transaccion, Integer> {

    @Query(value ="SELECT nextval('transacciones_tdd_sequence')",nativeQuery = true)
    public Integer valorSiguiente();


}
