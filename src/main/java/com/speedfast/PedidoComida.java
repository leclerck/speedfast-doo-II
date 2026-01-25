package com.speedfast;

public class PedidoComida extends Pedido {

    private String restaurante;

    public PedidoComida(String idPedido, String direccionEntrega, Double distanciaKm, String restaurante) {  
        super(idPedido, direccionEntrega, distanciaKm, "Comida");
        this.restaurante = restaurante;
    }

    @Override
    public Integer calcularTiempoEntrega() {
        return (int) Math.round(15 + (this.getDistanciaKm() * 2));
    }

    @Override
    public void asignarRepartidor(String nombreRepartidor) {
        super.asignarRepartidor(nombreRepartidor);
        System.out.println("Verificando mochila térmica... OK");
        System.out.println("Restaurante: " + restaurante);
    }

    public String getRestaurante() {
        return restaurante;
    }

    public void setRestaurante(String restaurante) {
        this.restaurante = restaurante;
    }

}
