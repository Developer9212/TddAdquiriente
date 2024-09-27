package com.fenoreste_alestra.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name="asignar_tdd")
public class Asignacion implements Serializable {

    @Id
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    private String peticion;
    private String tarjeta;
    private Integer codigo;
    private String descripcion;
    private String autorizacion;
    private String numerocuenta;
    private String numerocliente;
    private String nombrecliente;
    private String clabeinterbancaria;
    private String fechamovimiento;
    private String horamovimiento;
    private boolean correcto;

    private static final long serialVersionUID = 1L;
}
