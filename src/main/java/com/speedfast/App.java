package com.speedfast;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        System.out.println("Bienvenido a SpeedFast!");
        System.out.println("Realizamos envíos de comida, encomiendas y pedidos express.");

        List<Pedido> pedidos = new ArrayList<>();

        PedidoComida pedidoComida = new PedidoComida("1234567890", "Antonio Varas #666", 13.2, "McDonald's");
        pedidos.add(pedidoComida);
        pedidoComida.asignarRepartidor();
        pedidoComida.despachar();

        PedidoEncomienda pedidoEncomienda = new PedidoEncomienda("1234567891", "Serrano #1105", 3.4, 10.0);
        pedidos.add(pedidoEncomienda);
        pedidoEncomienda.asignarRepartidor("Gabriela González");
        pedidoEncomienda.cancelar();

        PedidoExpress pedidoExpress = new PedidoExpress("1234567892", "Froilán Roa #7107", 6.7, "Alta");
        pedidos.add(pedidoExpress);
        pedidoExpress.asignarRepartidor("Carlos López");

        PedidoEncomienda pedidoEncomiendaCreado = new PedidoEncomienda("1234567893", "Padre Alonso de Ovalle #1586", 2.0, 1.0);
        pedidos.add(pedidoEncomiendaCreado);

        System.out.println("--------------------------------");
        System.out.println("Estado de pedidos:");
        for (Pedido pedido : pedidos) {
            pedido.verHistorial();
        }

    }
}
