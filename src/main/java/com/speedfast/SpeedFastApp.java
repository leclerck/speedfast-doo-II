package com.speedfast;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import com.speedfast.util.StartupBanner;
import com.speedfast.model.PedidoComida;
import com.speedfast.model.PedidoEncomienda;
import com.speedfast.model.PedidoExpress;
import com.speedfast.service.GestorPedidos;
import com.speedfast.worker.Repartidor;

public class SpeedFastApp {
    public static void main(String[] args) {
        StartupBanner.show();
        GestorPedidos gestorPedidos = new GestorPedidos();
        Repartidor repartidorGG = new Repartidor("Gabriela González", gestorPedidos);
        Repartidor repartidorCL = new Repartidor("Carlos López", gestorPedidos);
        Repartidor repartidorJP = new Repartidor("Juan Pérez", gestorPedidos);

        PedidoComida pedidoComidaAV = new PedidoComida("1234567890", "Antonio Varas #666", "McDonald's");
        gestorPedidos.agregarPedido(pedidoComidaAV);
        gestorPedidos.asignarRepartidor(pedidoComidaAV, repartidorGG);

        PedidoEncomienda pedidoEncomiendaSerrano = new PedidoEncomienda("1234567891", "Serrano #1105", 10.0);
        gestorPedidos.agregarPedido(pedidoEncomiendaSerrano);
        gestorPedidos.asignarRepartidor(pedidoEncomiendaSerrano, repartidorJP);

        PedidoExpress pedidoExpressFroilan = new PedidoExpress("1234567892", "Froilán Roa #7107", "Alta");
        gestorPedidos.agregarPedido(pedidoExpressFroilan);
        gestorPedidos.asignarRepartidor(pedidoExpressFroilan, repartidorCL);

        PedidoEncomienda pedidoEncomiendaPAO = new PedidoEncomienda("1234567893", "Padre Alonso de Ovalle #1586",1.0);
        gestorPedidos.agregarPedido(pedidoEncomiendaPAO);
        gestorPedidos.asignarRepartidor(pedidoEncomiendaPAO, repartidorCL);

        PedidoExpress pedidoExpressPAO = new PedidoExpress("1234567894", "Padre Alonso de Ovalle #1586","Alta");
        gestorPedidos.agregarPedido(pedidoExpressPAO);
        gestorPedidos.asignarRepartidor(pedidoExpressPAO, repartidorJP);

        PedidoComida pedidoComidaPAO = new PedidoComida("1234567895", "Padre Alonso de Ovalle #1586", "Tarragona");
        gestorPedidos.agregarPedido(pedidoComidaPAO);
        gestorPedidos.asignarRepartidor(pedidoComidaPAO, repartidorGG);

        ExecutorService executor = Executors.newFixedThreadPool(3);
        executor.submit(repartidorGG);
        executor.submit(repartidorJP);
        executor.submit(repartidorCL);
        
        executor.shutdown();
        try {
            if (!executor.awaitTermination(60, TimeUnit.SECONDS)) {
                System.err.println("Hubo un retraso en los repartos del día.");
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }

        System.out.println("Cierre de operaciones de SpeedFast. Hasta mañana!");

        gestorPedidos.verHistorial();

    }
}
