package com.fenoreste_alestra.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name="informacion_tdd")
public class Informacion implements Serializable {

    @Id
    private Integer id;
    private String peticion;
    private String tarjeta;
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    private String nombre;
    private String direccion;
    private String direccion2;
    private String colonia;
    private String localidad;
    private String estado;
    private String codigopostal;
    private String telefono;
    private String telefono2;
    private String telefono3;
    private boolean correcto;

    private static final long serialVersionUID = 1L;
}
