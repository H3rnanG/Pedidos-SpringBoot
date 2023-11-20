package com.app.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.app.model.DetallePedido;

@Repository
public interface DetallePedidoRepository extends MongoRepository<DetallePedido, String>{

}
