package com.speedfast;

/**
 * Permite registrar cambios de estado de un pedido para el historial.
 * Usado por GestorPedidos y por Repartidor para crear EventoPedido.
 */
public interface RegistroEventos {
    void registrarEvento(Pedido pedido, Estado estado);
}
