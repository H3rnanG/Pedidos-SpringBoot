package com.app.interfaces;

import com.app.model.DetallePedido;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DetallePedidoDao {

    List<DetallePedido> getAllPlatosPedidos();

    DetallePedido getPlatoPedido(String id);

    void addPlatoPedido(DetallePedido platoPedido);

    void updatePlatoPedido(DetallePedido platoPedido);

    void deletePlatoPedido(String id);
}
