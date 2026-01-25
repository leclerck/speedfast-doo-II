package com.speedfast;

public class PedidoEncomienda extends Pedido {

    private Double peso;

    public PedidoEncomienda(String idPedido, String direccionEntrega, Double distanciaKm, Double peso) {
        super(idPedido, direccionEntrega, distanciaKm, "Encomienda");
        this.peso = peso;
    }
    @Override
    public Integer calcularTiempoEntrega() {
        return (int) Math.round(20 + (this.getDistanciaKm() * 1.5));
    }
    @Override
    public void asignarRepartidor(String nombreRepartidor) {
        super.asignarRepartidor(nombreRepartidor);
        System.out.println("Verificando peso y embalaje... OK");
        System.out.println("Peso del pedido: " + peso + " kg");
    }

    public Double getPeso() {
        return peso;
    }
    public void setPeso(Double peso) {
        this.peso = peso;
    }

}
