package com.fenoreste_alestra.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name="bloqueo_temporal_tdd")
public class BloqueoTemporal implements Serializable{

    @Id
    private Integer id;
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    private String peticion;
    private String folio;
    private String respuesta;
    private boolean correcta;

    private final long serialVersionUId = 1L;
}
