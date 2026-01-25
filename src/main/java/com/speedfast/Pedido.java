package com.speedfast;

public abstract class Pedido implements Despachable, Cancelable, Rastreable {

    private String idPedido;
    private String direccionEntrega;
    private Double distanciaKm;
    private String tipoPedido;
    private String estadoPedido;

    public Pedido(String idPedido, String direccionEntrega, Double distanciaKm, String tipoPedido) {
        this.idPedido = idPedido;
        this.direccionEntrega = direccionEntrega;
        this.distanciaKm = distanciaKm;
        this.tipoPedido = tipoPedido;
        this.estadoPedido = "Creado";
        System.out.println("--------------------------------");
        System.out.println("Nuevo Pedido registrado: #" + idPedido);
        this.mostrarResumen();
    }

    public abstract Integer calcularTiempoEntrega();

    public void mostrarResumen() {
        System.out.println("Resumen del pedido:");
        System.out.println("ID del pedido: " + idPedido);
        System.out.println("Tipo de pedido: " + tipoPedido);
        System.out.println("Estado del pedido: " + estadoPedido);
        System.out.println("Dirección de entrega: " + direccionEntrega);
        System.out.println("Distancia: " + distanciaKm + " km");
    }


    public void asignarRepartidor() {
        System.out.println("\nAsignando repartidor a pedido #" + idPedido + " ... OK");
        this.estadoPedido = "Asignado";
    }

    public void asignarRepartidor(String nombreRepartidor) {
        System.out.println("\nAsignando repartidor a pedido #" + idPedido + " ... Nombre: " + nombreRepartidor + ".");
        this.estadoPedido = "Asignado";
    }

    @Override
    public void despachar() {
        this.estadoPedido = "En camino";
        System.out.println("\nDespachando pedido #" + idPedido + " ...");
        System.out.println("Pedido despachado correctamente.");
        System.out.println("Tiempo de entrega estimado: " + calcularTiempoEntrega() + " minutos");
    }

    @Override
    public void cancelar() {
        this.estadoPedido = "Cancelado";
        System.out.println("\nCancelando pedido #" + idPedido + " ...");
        System.out.println("Pedido cancelado correctamente.");
    }

    @Override
    public void verHistorial() {
        System.out.println("Pedido #" + idPedido + ". Tipo de pedido: " + tipoPedido + ". Estado del pedido: " + estadoPedido);
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

}
