package com.app.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.interfaces.DetallePedidoDao;
import com.app.model.DetallePedido;
import com.app.repository.DetallePedidoRepository;

@Service
public class DetallePedidoDaoImpl implements DetallePedidoDao {

    @Autowired
    private DetallePedidoRepository platoPedidoRepository;

    @Override
    public List<DetallePedido> getAllPlatosPedidos() {
        return platoPedidoRepository.findAll();
    }

    @Override
    public DetallePedido getPlatoPedido(String id) {
        return platoPedidoRepository.findById(id).orElse(null);
    }

    @Override
    public void addPlatoPedido(DetallePedido platoPedido) {
        platoPedidoRepository.save(platoPedido);
    }

    @Override
    public void updatePlatoPedido(DetallePedido platoPedido) {
        platoPedidoRepository.save(platoPedido);
    }

    @Override
    public void deletePlatoPedido(String id) {
        platoPedidoRepository.deleteById(id);
    }
}

