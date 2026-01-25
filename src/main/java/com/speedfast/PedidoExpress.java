package com.speedfast;

public class PedidoExpress extends Pedido {

    private String prioridad;

    public PedidoExpress(String idPedido, String direccionEntrega, Double distanciaKm, String prioridad) {
        super(idPedido, direccionEntrega, distanciaKm, "Express");
        this.prioridad = prioridad;
    }

    @Override
    public Integer calcularTiempoEntrega() {
        return this.getDistanciaKm() > 5 ? 15 : 10;
    }

    @Override
    public void asignarRepartidor(String nombreRepartidor) {
        System.out.println("\nBuscando repartidor más cercano con disponibilidad inmediata... OK");
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
