package com.fenoreste_alestra.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name="bloqueo_tdd")
public class Deposito implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String tarjeta;
    private  String peticion;
    private Date fecha;
    private Integer codigo;
    private String descripcion;
    private String autorizacion;
    private Double saldo_antes_abono;
    private Double saldo_despues_abono;
    private boolean correcto;

    private static final long serialVersionUID = 1L;
}
