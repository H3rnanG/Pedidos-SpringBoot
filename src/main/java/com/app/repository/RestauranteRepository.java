package com.app.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.app.model.Restaurante;

@Repository
public interface RestauranteRepository extends MongoRepository<Restaurante,String>{

}
