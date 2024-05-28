package com.fenoreste_alestra.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name="bloqueo_tdd")
public class Bloqueo implements Serializable{

    @Id
    private Integer id;
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    private String peticion;
    private Integer codigo;
    private String descripcion;
    private String autorizacion;
    private boolean correcta;

    private final long serialVersionUID = 1L;
}
