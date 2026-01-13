package com.speedfast;

public class App {
    public static void main(String[] args) {

        PedidoComida pedidoComida = new PedidoComida("1234567890", "Calle 123 # 45-67", "Comida", "Santiago", "McDonald's");
        pedidoComida.asignarRepartidor("Juan Pérez");
        
        PedidoEncomienda pedidoEncomienda = new PedidoEncomienda("1234567891", "Calle 123 # 45-67", "Encomienda", "Santiago", 10.0);
        pedidoEncomienda.asignarRepartidor("Gabriela González");
        
        PedidoExpress pedidoExpress = new PedidoExpress("1234567892", "Calle 123 # 45-67", "Express", "Santiago", "Alta");
        pedidoExpress.asignarRepartidor("Carlos López");
        
    }
}
