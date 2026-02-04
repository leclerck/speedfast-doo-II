package com.speedfast.model;

public enum Estado {
    CREADO("Creado"),
    ASIGNADO("Asignado"),
    EN_CAMINO("En camino"),
    ENTREGADO("Entregado"),
    CANCELADO("Cancelado");

    private String nombre;

    Estado(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }
}
