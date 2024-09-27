package com.fenoreste_alestra.dao;

import com.fenoreste_alestra.entity.Activacion;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ActivacionDao extends CrudRepository<Activacion, Integer> {


}
