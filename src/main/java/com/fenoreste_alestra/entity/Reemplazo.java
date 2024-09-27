package com.fenoreste_alestra.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name="reemplazo_tdd")
public class Reemplazo implements Serializable{

    @Id
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    private String peticion;
    private String tarjeta;
    private Integer codigo;
    private String descripcion;
    private String autorizacion;
    private String tarjetanueva;
    private String cuentaambiente;
    private String fechaexpiracion;
    private String status;
    private String tipo;
    private boolean correcto;

    private static final long serialVersionUID = 1L;
}
