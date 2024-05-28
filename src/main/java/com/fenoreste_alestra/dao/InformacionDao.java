package com.fenoreste_alestra.dao;

import com.fenoreste_alestra.entity.Informacion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InformacionDao extends JpaRepository<Informacion, Integer> {
}
