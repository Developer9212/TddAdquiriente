package com.fenoreste_alestra.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name="transaccion_tdd")
public class TransaccionDTO implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idoperacionsaicoop;
    private String tarjeta;
    private Integer tipotransaccion;
    private Double monto;
    private Integer codigo;
    private String descripcion;
    private String fecha;
    private Double saldodisponible;

    private static final long serialVersionUID = 1L;
}