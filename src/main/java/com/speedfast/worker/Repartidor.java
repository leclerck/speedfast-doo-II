package com.speedfast.worker;

import com.speedfast.model.EstadoPedido;
import com.speedfast.model.Pedido;
import com.speedfast.model.PedidoCierre;
import com.speedfast.model.ZonaDeCarga;
import com.speedfast.service.RegistroEventos;

/**
 * Clase que representa un repartidor.
 * Se encarga de retirar los pedidos de la zona de carga y entregarlos.
 */

public class Repartidor implements Runnable {
    private final String nombre;
    private final RegistroEventos registroEventos;
    private final ZonaDeCarga zonaDeCarga;

    public Repartidor(String nombre, RegistroEventos registroEventos, ZonaDeCarga zonaDeCarga) {
        this.nombre = nombre;
        this.registroEventos = registroEventos;
        this.zonaDeCarga = zonaDeCarga;
    }

    /**
     * Método que se ejecuta cuando se inicia el hilo.
     * Se encarga de retirar los pedidos de la zona de carga y entregarlos.
     * Se ejecuta en un bucle hasta que no queden pedidos por retirar o el
     * repartidor se pierda.
     */
    @Override
    public void run() {
        while (true) {
            Pedido pedido;
            try {
                pedido = zonaDeCarga.retirarPedido(nombre);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
            if (pedido instanceof PedidoCierre) {
                System.out.println("[Zona de carga] Repartidor " + nombre + " marcó el fin de su jornada.");
                break;
            }
            registroEventos.registrarEvento(pedido, EstadoPedido.EN_REPARTO);

            try {
                Thread.sleep(pedido.calcularTiempoEntrega() * 1000);
                registroEventos.registrarEvento(pedido, EstadoPedido.ENTREGADO);
                System.out.println(">>> Pedido #" + pedido.getIdPedido() + " entregado exitosamente!");
            } catch (InterruptedException e) {
                System.out.println("[Alerta] Repartidor " + nombre + " se perdió mientras entregaba el pedido "
                        + pedido.getIdPedido() + ". Finalizando su jornada.");
                Thread.currentThread().interrupt();
                break;
            }
        }
    }

    public String getNombre() {
        return nombre;
    }
}
