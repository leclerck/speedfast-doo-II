package com.speedfast;

import java.time.ZoneId;
import java.time.ZonedDateTime;
/*
 * Clase que representa un evento de un pedido.
 * Se usa para registrar los cambios de estado de un pedido.
 */
public class EventoPedido {
    private Pedido pedido;
    private Estado estado;
    private ZonedDateTime fechaHora;

    public EventoPedido(Pedido pedido, Estado estado) {
        this.pedido = pedido;
        this.estado = estado;
        this.fechaHora = ZonedDateTime.now(ZoneId.of("America/Santiago"));
    }

    public Pedido getPedido() {
        return pedido;
    }

    public Estado getEstado() {
        return estado;
    }

    public ZonedDateTime getFechaHora() {
        return fechaHora;
    }

}
