package com.speedfast.model;

import java.time.ZoneId;
import java.time.ZonedDateTime;
/*
 * Clase que representa un evento de un pedido.
 * Se usa para registrar los cambios de estado de un pedido.
 */
public class EventoPedido {
    private Pedido pedido;
    private EstadoPedido estado;
    private ZonedDateTime fechaHora;

    public EventoPedido(Pedido pedido, EstadoPedido estado) {
        this.pedido = pedido;
        this.estado = estado;
        this.fechaHora = ZonedDateTime.now(ZoneId.of("America/Santiago"));
    }

    public Pedido getPedido() {
        return pedido;
    }

    public EstadoPedido getEstado() {
        return estado;
    }

    public ZonedDateTime getFechaHora() {
        return fechaHora;
    }

}
