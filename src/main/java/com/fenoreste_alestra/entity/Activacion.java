package com.fenoreste_alestra.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="activacion_tdd")
@Data
public class Activacion implements Serializable {

    @Id
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    private String autorizacion;
    private String tarjeta;
    private String peticion;
    private Integer codigo;
    private String descripcion;
    private boolean correcta;
    private static final long serialVersionUID = 1L;
}
