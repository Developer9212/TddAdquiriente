package com.fenoreste_alestra.dao;

import com.fenoreste_alestra.entity.BloqueoTemporal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BloqueoTemporalDao extends JpaRepository<BloqueoTemporal, Integer> {
}
