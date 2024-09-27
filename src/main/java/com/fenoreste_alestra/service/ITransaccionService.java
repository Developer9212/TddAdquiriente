package com.fenoreste_alestra.service;

import com.fenoreste_alestra.entity.Transaccion;

public interface ITransaccionService {

    public Transaccion guardarTransaccion(Transaccion transaccion);

    public Integer valorProximo();

    public Transaccion obtenerTransaccion(Integer id);
}
