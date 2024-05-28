package com.fenoreste_alestra.dao;

import com.fenoreste_alestra.entity.Nip;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NipDao extends JpaRepository <Nip,Integer> {
}
