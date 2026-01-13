package com.speedfast;

public class PedidoExpress extends Pedido {

    private String prioridad;

    public PedidoExpress(String idPedido, String direccionEntrega, String tipoPedido, String origen, String prioridad) {
        super(idPedido, direccionEntrega, tipoPedido, origen);
        this.prioridad = prioridad;
    }
    @Override
    public void asignarRepartidor(String nombreRepartidor) {
        super.asignarRepartidor(nombreRepartidor);
        System.out.println("Repartidor más cercano con disponibilidad inmediata encontrado.");
        System.out.println("Nivel de prioridad del pedido: " + prioridad);
    }
    public String getPrioridad() {
        return prioridad;
    }
    public void setPrioridad(String prioridad) {
        this.prioridad = prioridad;
    }

}
