package com.speedfast;

public class PedidoComida extends Pedido {

    private String restaurante;

    public PedidoComida(String idPedido, String direccionEntrega, Double distanciaKm, String origen, String restaurante) {
        super(idPedido, direccionEntrega, distanciaKm, origen);
        this.restaurante = restaurante;
        System.out.println("--------------------------------");
        System.out.println("Pedido de comida registrado: #" + idPedido);
    }

    @Override
    public Integer calculartTiempoEntrega() {
        return (int) Math.ceil(15 + (this.getDistanciaKm() * 2));
    }

    @Override
    public void asignarRepartidor(String nombreRepartidor) {
        super.asignarRepartidor(nombreRepartidor);
        System.out.println("Verificando mochila térmica... OK");
        System.out.println("Destino Restaurante: " + restaurante);
    }

    public String getRestaurante() {
        return restaurante;
    }

    public void setRestaurante(String restaurante) {
        this.restaurante = restaurante;
    }

}
