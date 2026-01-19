package com.speedfast;

public class App {
    public static void main(String[] args) {
        System.out.println("--------------------------------");
        System.out.println("Bienvenido a SpeedFast!");
        System.out.println("Realizamos envíos de comida, encomiendas y pedidos express.");
        PedidoComida pedidoComida = new PedidoComida("1234567890", "Antonio Varas #666", 13.2, "Providencia", "McDonald's");
        pedidoComida.mostrarResumen();
        pedidoComida.asignarRepartidor("Juan Pérez");
        System.out.println("Tiempo de entrega: " + pedidoComida.calculartTiempoEntrega() + " minutos");

        PedidoEncomienda pedidoEncomienda = new PedidoEncomienda("1234567891", "Serrano #1105", 3.4, "Melipilla", 10.0);
        pedidoEncomienda.mostrarResumen();
        pedidoEncomienda.asignarRepartidor("Gabriela González");
        System.out.println("Tiempo de entrega: " + pedidoEncomienda.calculartTiempoEntrega() + " minutos");

        PedidoExpress pedidoExpress = new PedidoExpress("1234567892", "Froilán Roa #7107", 6.7, "La Florida", "Alta");
        pedidoExpress.mostrarResumen();
        pedidoExpress.asignarRepartidor("Carlos López");
        System.out.println("Tiempo de entrega: " + pedidoExpress.calculartTiempoEntrega() + " minutos");
    }
}
