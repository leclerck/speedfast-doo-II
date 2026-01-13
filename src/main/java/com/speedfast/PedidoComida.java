package com.speedfast;

public class PedidoComida extends Pedido {

    private String restaurante;

    public PedidoComida(String idPedido, String direccionEntrega, String tipoPedido, String origen, String restaurante) {
        super(idPedido, direccionEntrega, tipoPedido, origen);
        this.restaurante = restaurante;
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
