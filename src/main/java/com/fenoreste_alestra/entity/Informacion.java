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
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    private String peticion;
    private String tarjeta;
    private  Integer codigo;
    private String descripcion;
    private String tarjetaresponse;
    private String nombre;
    private String direccion;
    private String colonia;
    private String localidad;
    private String estado;
    private String rfc;
    private String codigopostal;
    private String telefono;
    private boolean correcto;

    private static final long serialVersionUID = 1L;
}
