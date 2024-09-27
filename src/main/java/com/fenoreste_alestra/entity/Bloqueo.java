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
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    private String tarjeta;
    private String peticion;
    private Integer codigo;
    private String descripcion;
    private String autorizacion;
    private boolean correcta;

    private static final long serialVersionUID = 1L;
}
