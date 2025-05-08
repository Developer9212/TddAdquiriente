package com.fenoreste_alestra.dao;

import com.fenoreste_alestra.entity.Reemplazo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ReemplazoDao extends JpaRepository<Reemplazo, Integer> {

    public  Reemplazo findByTarjetanueva(String tarjetanueva);
}
