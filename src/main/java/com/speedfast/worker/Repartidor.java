package com.speedfast.worker;

import java.util.ArrayList;
import java.util.List;

import com.speedfast.model.Estado;
import com.speedfast.model.Pedido;
import com.speedfast.service.RegistroEventos;

public class Repartidor implements Runnable {
    private String nombre;
    private List<Pedido> pedidos;
    private RegistroEventos registroEventos;

    public Repartidor(String nombre, RegistroEventos registroEventos) {
        this.nombre = nombre;
        this.pedidos = new ArrayList<>();
        this.registroEventos = registroEventos;
    }

    @Override
    public void run() {
        for (Pedido pedido : pedidos) {
            System.out.println("Repartidor " + nombre + " está recogiendo pedido " + pedido.getIdPedido() + "...");
            registroEventos.registrarEvento(pedido, Estado.EN_CAMINO);
            try {
                Thread.sleep(pedido.calcularTiempoEntrega() * 1000);
                System.out.println("Pedido #" + pedido.getIdPedido() + " entregado exitosamente!");
                registroEventos.registrarEvento(pedido, Estado.ENTREGADO);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public List<Pedido> getPedidos() {
        return pedidos;
    }
    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }
    public void agregarPedido(Pedido pedido) {
        this.pedidos.add(pedido);
    }
    public void eliminarPedido(Pedido pedido) {
        this.pedidos.remove(pedido);
    }
}
