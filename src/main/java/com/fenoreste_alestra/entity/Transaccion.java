package com.fenoreste_alestra.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name="transacciones_tdd")
public class Transaccion implements Serializable {
     
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "my_sequence_generator")
    @SequenceGenerator(name = "my_sequence_generator", sequenceName = "transacciones_tdd_sequence", allocationSize = 1)
    private Integer idoperacionsaicoop;
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    private String peticion;
    private String tarjeta;
    private Integer codigo;
    private String descripcion;
    private Integer noperaciones;
    private boolean correcto;

    private static final long serialVersionUID = 1L;
}
