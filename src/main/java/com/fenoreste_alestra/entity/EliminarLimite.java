package com.fenoreste_alestra.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name="eliminar_limite_tdd")
public class EliminarLimite implements Serializable {

    @Id
    private Integer id;
    private String peticion;
    private String tarjeta;
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    private Integer codigo;
    private String autorizacion;
    private String descripcion;
    private boolean correcto;

    private static final long serialVersionUID = 1L;
}
