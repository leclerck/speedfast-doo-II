package com.speedfast;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import com.speedfast.util.StartupBanner;
import com.speedfast.model.PedidoComida;
import com.speedfast.model.PedidoEncomienda;
import com.speedfast.model.PedidoExpress;
import com.speedfast.model.ZonaDeCarga;
import com.speedfast.service.GestorPedidos;
import com.speedfast.worker.Repartidor;

public class SpeedFastApp {
    public static void main(String[] args) {
        StartupBanner.show();

        GestorPedidos gestorPedidos = new GestorPedidos();
        ZonaDeCarga zonaDeCarga = new ZonaDeCarga(gestorPedidos);

        // Creación de los repartidores
        Repartidor repartidorGG = new Repartidor("Gabriela González", gestorPedidos, zonaDeCarga);
        Repartidor repartidorCL = new Repartidor("Carlos López", gestorPedidos, zonaDeCarga);
        Repartidor repartidorJP = new Repartidor("Juan Pérez", gestorPedidos, zonaDeCarga);

        // Creación de los pedidos
        zonaDeCarga.agregarPedido(new PedidoComida(1234567890, "Antonio Varas #666", "McDonald's"));
        zonaDeCarga.agregarPedido(new PedidoEncomienda(1234567891, "Serrano #1105", 10.0));
        zonaDeCarga.agregarPedido(new PedidoExpress(1234567892, "Froilán Roa #7107", "Alta"));
        zonaDeCarga.agregarPedido(new PedidoEncomienda(1234567893, "Padre Alonso de Ovalle #1586",1.0));
        zonaDeCarga.agregarPedido(new PedidoComida(1234567894, "Padre Alonso de Ovalle #1586", "Tarragona"));
        // Señal de fin de jornada para cada repartidor (evita busy-wait en la cola)
        for (int i = 0; i < 3; i++) {
            zonaDeCarga.agregarPedidoCierre();
        }

        // Creación del pool de hilos
        ExecutorService executor = Executors.newFixedThreadPool(3);
        executor.submit(repartidorGG);
        executor.submit(repartidorJP);
        executor.submit(repartidorCL);
        
        // Cierre del pool de hilos
        executor.shutdown();
        try {
            if (!executor.awaitTermination(60, TimeUnit.SECONDS)) {
                System.err.println("[Alerta] Hubo un retraso en los repartos del día.");
                executor.shutdownNow();
                if (!executor.awaitTermination(5, TimeUnit.SECONDS)) {
                    System.err.println("[Alerta] Algunos repartidores no finalizaron a tiempo.");
                }
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
            Thread.currentThread().interrupt();
        }

        System.out.println("==================== Cierre de operaciones de SpeedFast. Hasta mañana! ====================");

        gestorPedidos.verHistorial();

    }
}
