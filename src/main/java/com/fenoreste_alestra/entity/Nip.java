package com.fenoreste_alestra.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name="asignacionnip_tdd")
public class Nip implements Serializable {

    @Id
    private Integer id;
    private String peticion;
    private String tarjeta;
    private Date fecha;
    private Integer codigo;
    private String descripcion;
    private boolean correcto;

    private static final long serialVersionUID = 1L;
}
