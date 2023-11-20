package com.app.interfaces;

import com.app.model.Pedido;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PedidoDao {

    List<Pedido> getAllPedidos();

    Pedido getPedido(String id);

    void addPedido(Pedido pedido);

    void updatePedido(Pedido pedido);

    void deletePedido(String id);
}