package com.speedfast.model;

public abstract class Pedido {

    private String idPedido;
    private String direccionEntrega;
    private Double distanciaKm;
    private String tipoPedido;
    private Estado estadoPedido;


    public Pedido(String idPedido, String direccionEntrega, Double distanciaKm, String tipoPedido) {
        this.idPedido = idPedido;
        this.direccionEntrega = direccionEntrega;
        this.distanciaKm = distanciaKm;
        this.tipoPedido = tipoPedido;
        this.estadoPedido = Estado.CREADO;
        System.out.println("--------------------------------");
        System.out.println("Nuevo Pedido registrado: #" + idPedido);
        this.mostrarResumen();
    }

    public Pedido(String idPedido, String direccionEntrega, String tipoPedido) {
        this.idPedido = idPedido;
        this.direccionEntrega = direccionEntrega;
        this.distanciaKm = Math.random() * 5 + 0.1;
        this.tipoPedido = tipoPedido;
        this.estadoPedido = Estado.CREADO;
        System.out.println("--------------------------------");
        System.out.println("Nuevo Pedido registrado: #" + idPedido);
        this.mostrarResumen();
    }

    public abstract Integer calcularTiempoEntrega();
    public abstract void imprimirDetallesAsignacion();

    public void mostrarResumen() {
        System.out.println("Resumen del pedido:");
        System.out.println("ID del pedido: " + idPedido);
        System.out.println("Tipo de pedido: " + tipoPedido);
        System.out.println("Estado del pedido: " + estadoPedido.getNombre());
        System.out.println("Dirección de entrega: " + direccionEntrega);
        System.out.println("Distancia: " + distanciaKm + " km");
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

    public String getTipoPedido() {
        return tipoPedido;
    }
    public void setTipoPedido(String tipoPedido) {
        this.tipoPedido = tipoPedido;
    }

    public Estado getEstadoPedido() {
        return estadoPedido;
    }

    public void setEstadoPedido(Estado estadoPedido) {
        this.estadoPedido = estadoPedido;
    }

}
