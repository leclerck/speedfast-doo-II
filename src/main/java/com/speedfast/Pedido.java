package com.speedfast;

public abstract class Pedido {

    private String idPedido;
    private String direccionEntrega;
    private Double distanciaKm;
    private String origen;

    public Pedido(String idPedido, String direccionEntrega, Double distanciaKm, String origen) {
        this.idPedido = idPedido;
        this.direccionEntrega = direccionEntrega;
        this.distanciaKm = distanciaKm;
        this.origen = origen;
    }

    public abstract Integer calculartTiempoEntrega();

    public void mostrarResumen() {
        System.out.println("Resumen del pedido:");
        System.out.println("ID del pedido: " + idPedido);
        System.out.println("Dirección de entrega: " + direccionEntrega);
        System.out.println("Distancia: " + distanciaKm + " km");
        System.out.println("Origen: " + origen);
    }

    public void asignarRepartidor(String nombreRepartidor) {
        System.out.println("Asignando repartidor... Nombre: " + nombreRepartidor + ".");
    }

    public String getIdPedido() {
        return idPedido;
    }
    public void setIdPedido(String idPedido) {
        this.idPedido = idPedido;
    }

    public String getDireccionEntrega() {
        return direccionEntrega;
    }

    public void setDireccionEntrega(String direccionEntrega) {
        this.direccionEntrega = direccionEntrega;
    }

    public Double getDistanciaKm() {
        return distanciaKm;
    }

    public void setDistanciaKm(Double distanciaKm) {
        this.distanciaKm = distanciaKm;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

}
