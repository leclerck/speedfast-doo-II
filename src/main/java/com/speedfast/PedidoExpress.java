package com.speedfast;

public class PedidoExpress extends Pedido {

    private String prioridad;

    public PedidoExpress(String idPedido, String direccionEntrega, Double distanciaKm, String origen, String prioridad) {
        super(idPedido, direccionEntrega, distanciaKm, origen);
        this.prioridad = prioridad;
        System.out.println("--------------------------------");
        System.out.println("Pedido express registrado: #" + idPedido);
    }

    @Override
    public Integer calculartTiempoEntrega() {
        return this.getDistanciaKm() > 5 ? 15 : 10;
    }

    @Override
    public void asignarRepartidor(String nombreRepartidor) {
        System.out.println("Repartidor más cercano con disponibilidad inmediata encontrado.");
        super.asignarRepartidor(nombreRepartidor);
        System.out.println("Nivel de prioridad del pedido: " + prioridad);
    }
    public String getPrioridad() {
        return prioridad;
    }
    public void setPrioridad(String prioridad) {
        this.prioridad = prioridad;
    }

}
