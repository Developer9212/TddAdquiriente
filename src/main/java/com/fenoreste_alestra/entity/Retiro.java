package com.fenoreste_alestra.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name="retiro_tdd")
public class Retiro implements Serializable {

    @Id
    private Integer id;
    private String peticion;
    private String tarjeta;
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    private Integer codigo;
    private String autorizacion;
    private String descripcion;
    private Double saldo_antes_retiro;
    private Double saldo_despues_retiro;
    private boolean correcto;

    private static final long serialVersionUID = 1L;
}
