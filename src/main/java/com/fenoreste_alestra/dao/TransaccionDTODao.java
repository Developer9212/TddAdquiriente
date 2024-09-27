package com.fenoreste_alestra.dao;

import com.fenoreste_alestra.entity.TransaccionDTO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransaccionDTODao extends JpaRepository<TransaccionDTO, Integer> {
}
