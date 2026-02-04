package com.speedfast.contract;

import com.speedfast.model.Pedido;

public interface Cancelable {
    void cancelar(Pedido pedido);
}
