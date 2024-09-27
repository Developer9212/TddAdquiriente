package com.fenoreste_alestra.ws_client_tdd;

import lombok.Data;

import java.io.Serializable;

@Data
public class AssignamentAccountDto implements Serializable {

    private String cuenta;
    private String nombreLargo;
    private String nombreCorto;
    private String direccion;
    private String colonia;
    private String entidadFederativa;
    private String codigoPostal;
    private String rfc;
    private String telefono;
    private String telefono2;
    private String sucursal;
    private String producto;

    private static final long serialVersionUID = 1L;
}
