package com.speedfast;

public class Pedido {

    private String idPedido;
    private String direccionEntrega;
    private String tipoPedido;
    private String origen;

    public Pedido(String idPedido, String direccionEntrega, String tipoPedido, String origen) {
        this.idPedido = idPedido;
        this.direccionEntrega = direccionEntrega;
        this.tipoPedido = tipoPedido;
        this.origen = origen;
    }

    public void asignarRepartidor(String nombreRepartidor) {
        System.out.println("Asignando repartidor. Nombre: " + nombreRepartidor + ". ID de Pedido: " + idPedido);
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

    public String getTipoPedido() {
        return tipoPedido;
    }

    public void setTipoPedido(String tipoPedido) {
        this.tipoPedido = tipoPedido;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

}
