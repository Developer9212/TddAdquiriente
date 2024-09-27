package com.fenoreste_alestra.dao;

import com.fenoreste_alestra.entity.Asignacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AsignacionDao extends JpaRepository<Asignacion, Integer> {

    @Query(value = "SELECT * FROM asignar_tdd WHERE tarjeta=?1 ORDER BY fecha DESC LIMIT 1",nativeQuery = true)
    public Asignacion buscarPorId(String tarjeta);
}
