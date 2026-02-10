package com.speedfast.model;

/*
 * Enum que representa los estados posibles de un pedido.
 */
public enum EstadoPedido {
    PENDIENTE("Pendiente"),
    EN_REPARTO("En reparto"),
    ENTREGADO("Entregado"),
    CANCELADO("Cancelado");

    private String nombre;

    EstadoPedido(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }
}
