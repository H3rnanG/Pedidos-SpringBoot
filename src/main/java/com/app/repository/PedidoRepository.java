package com.app.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.app.model.Pedido;

@Repository
public interface PedidoRepository extends MongoRepository<Pedido, String>{

}
