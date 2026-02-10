package com.speedfast.model;

import java.util.ArrayList;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import com.speedfast.service.RegistroEventos;

/**
 * Zona de carga de los repartidores.
 * Usa una cola bloqueante: los repartidores bloquean en retirarPedido(String)
 * cuando no hay pedidos, y se desbloquean cuando llega uno o una señal de fin de jornada (PedidoCierre).
 */
public class ZonaDeCarga {

    private final BlockingQueue<Pedido> pedidos;
    private final RegistroEventos registroEventos;

    public ZonaDeCarga(RegistroEventos registroEventos) {
        this.pedidos = new LinkedBlockingQueue<>();
        this.registroEventos = registroEventos;
        System.out.println("[Zona de carga] Habilitada.");
    }

    /**
     * Agrega un pedido a la zona y registra el evento PENDIENTE.
     * Los repartidores que estén bloqueados en retirarPedido recibirán este pedido.
     */
    public void agregarPedido(Pedido pedido) {
        if (!(pedido instanceof PedidoCierre)) {
            registroEventos.registrarEvento(pedido, EstadoPedido.PENDIENTE);
            System.out.println("[Pedido #" + pedido.getIdPedido() + "] agregado a la zona de carga.");
        }
        pedidos.add(pedido);
    }

    /**
     * Señal de cierre de jornada: un repartidor que reciba este "pedido" debe finalizar su jornada.
     * Llamar una vez por cada repartidor tras haber agregado todos los pedidos reales.
     */
    public void agregarPedidoCierre() {
        pedidos.add(new PedidoCierre());
    }

    /**
     * Retira el siguiente pedido de la zona. Bloquea hasta que haya uno disponible.
     * Cuando el pedido es una instancia de PedidoCierre el repartidor debe finalizar su jornada.
     *
     * @throws InterruptedException si el hilo es interrumpido mientras espera
     */
    public Pedido retirarPedido(String nombreRepartidor) throws InterruptedException {
        Pedido pedido = pedidos.take();
        if (!(pedido instanceof PedidoCierre)) {
            System.out.println("[Pedido #" + pedido.getIdPedido() + "] retirado de la zona de carga por " + nombreRepartidor + ".");
        }
        return pedido;
    }

    public boolean estaVacia() {
        boolean vacia = pedidos.isEmpty();
        if (vacia) {
            System.out.println("[Zona de carga vacía] No hay pedidos por retirar.");
        }
        return vacia;
    }

    public void mostrarPedidos() {
        System.out.println("[Pedidos en la zona de carga]");
        for (Pedido pedido : new ArrayList<>(pedidos)) {
            if (!(pedido instanceof PedidoCierre)) {
                System.out.println("[Pedido #" + pedido.getIdPedido() + "] - Destino: " + pedido.getDireccionEntrega());
            }
        }
    }
}
