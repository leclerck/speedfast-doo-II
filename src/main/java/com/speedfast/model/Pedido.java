package com.speedfast.model;

public abstract class Pedido {

    private Integer idPedido;
    private String direccionEntrega;
    private Double distanciaKm;
    private String tipoPedido;
    private EstadoPedido estado;


    public Pedido(Integer idPedido, String direccionEntrega, Double distanciaKm, String tipoPedido) {
        this.idPedido = idPedido;
        this.direccionEntrega = direccionEntrega;
        this.distanciaKm = distanciaKm;
        this.tipoPedido = tipoPedido;
        this.estado = EstadoPedido.PENDIENTE;
        System.out.println("--------------------------------");
        System.out.println("Nuevo Pedido registrado: #" + idPedido);
        this.mostrarResumen();
    }

    public Pedido(Integer idPedido, String direccionEntrega, String tipoPedido) {
        this.idPedido = idPedido;
        this.direccionEntrega = direccionEntrega;
        this.distanciaKm = Math.random() * 2 + 0.1;
        this.tipoPedido = tipoPedido;
        this.estado = EstadoPedido.PENDIENTE;
        System.out.println("--------------------------------");
        System.out.println(">>> Nuevo Pedido registrado: #" + idPedido + " - De tipo " + tipoPedido);
    }

    /** Constructor interno para subclase PedidoCierre (fin de jornada) */
    protected Pedido() {
        this.idPedido = -1;
        this.direccionEntrega = "";
        this.distanciaKm = 0.0;
        this.tipoPedido = "CIERRE";
        this.estado = EstadoPedido.PENDIENTE;
    }

    public abstract Integer calcularTiempoEntrega();
    public abstract void imprimirDetallesAsignacion();

    public void mostrarResumen() {
        System.out.println("Resumen del pedido:");
        System.out.println("ID del pedido: " + idPedido);
        System.out.println("Tipo de pedido: " + tipoPedido);
        System.out.println("Estado del pedido: " + estado.getNombre());
        System.out.println("Dirección de entrega: " + direccionEntrega);
        System.out.println("Distancia: " + distanciaKm + " km");
    }

    public Integer getIdPedido() {
        return idPedido;
    }
    public void setIdPedido(Integer idPedido) {
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

    public EstadoPedido getEstado() {
        return estado;
    }

    public void setEstado(EstadoPedido estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Pedido [idPedido=" + idPedido + ", direccionEntrega=" + direccionEntrega + ", distanciaKm="
                + distanciaKm + ", tipoPedido=" + tipoPedido + ", estado=" + estado + "]";
    }
    
}
