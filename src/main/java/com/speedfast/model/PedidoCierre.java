package com.speedfast.model;

/**
 * Pedido sentinela que indica a los repartidores que no hay más pedidos
 * y pueden finalizar su jornada (evita busy-wait en la cola).
 */
public class PedidoCierre extends Pedido {

    public PedidoCierre() {
        super();
    }

    @Override
    public Integer calcularTiempoEntrega() {
        return 0;
    }

    @Override
    public void imprimirDetallesAsignacion() {
        // No-op: no es un pedido real, no se imprime nada.
    }
}
