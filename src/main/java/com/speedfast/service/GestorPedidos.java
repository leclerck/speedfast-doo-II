package com.speedfast.service;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import com.speedfast.contract.Cancelable;
import com.speedfast.contract.Despachable;
import com.speedfast.contract.Rastreable;
import com.speedfast.model.EstadoPedido;
import com.speedfast.model.EventoPedido;
import com.speedfast.model.Pedido;

public class GestorPedidos implements Rastreable, Despachable, Cancelable, RegistroEventos {
    private List<EventoPedido> eventos = new ArrayList<>();

    /** Registra un cambio de estado y lo agrega al historial. Usado por el gestor y por Repartidor. */
    @Override
    public void registrarEvento(Pedido pedido, EstadoPedido estado) {
        pedido.setEstado(estado);
        eventos.add(new EventoPedido(pedido, estado));
    }

    @Override
    public void verHistorial() {
        System.out.println("==============Historial de pedidos==============");
        for (EventoPedido e : eventos) {
            System.out.println("Pedido #" + e.getPedido().getIdPedido());
            System.out.println(e.getFechaHora().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")) + " - Estado: " + e.getEstado().getNombre());
            System.out.println("--------------------------------");
        }
        System.out.println("==============Fin del historial==============");
    }

    @Override
    public void despachar(Pedido pedido) {
        registrarEvento(pedido, EstadoPedido.EN_REPARTO);
        System.out.println("\nDespachando pedido #" + pedido.getIdPedido() + " ...");
        System.out.println("Pedido despachado correctamente.");
        System.out.println("Tiempo de entrega estimado: " + pedido.calcularTiempoEntrega() + " minutos");
    }

    @Override
    public void cancelar(Pedido pedido) {
        registrarEvento(pedido, EstadoPedido.CANCELADO);
        System.out.println("\nCancelando pedido #" + pedido.getIdPedido() + " ...");
        System.out.println("Pedido cancelado correctamente.");
    }

}
