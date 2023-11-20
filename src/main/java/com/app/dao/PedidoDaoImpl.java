package com.app.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.interfaces.PedidoDao;
import com.app.model.Pedido;
import com.app.repository.PedidoRepository;

@Service
public class PedidoDaoImpl implements PedidoDao {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Override
    public List<Pedido> getAllPedidos() {
        return pedidoRepository.findAll();
    }

    @Override
    public Pedido getPedido(String id) {
        return pedidoRepository.findById(id).orElse(null);
    }

    @Override
    public void addPedido(Pedido pedido) {
        pedidoRepository.save(pedido);
    }

    @Override
    public void updatePedido(Pedido pedido) {
        pedidoRepository.save(pedido);
    }

    @Override
    public void deletePedido(String id) {
        pedidoRepository.deleteById(id);
    }
}

