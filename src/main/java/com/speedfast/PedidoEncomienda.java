package com.speedfast;

public class PedidoEncomienda extends Pedido {

    private Double peso;

    public PedidoEncomienda(String idPedido, String direccionEntrega, String tipoPedido, String origen, Double peso) {
        super(idPedido, direccionEntrega, tipoPedido, origen);
        this.peso = peso;
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
