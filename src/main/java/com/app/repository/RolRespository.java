package com.app.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.app.model.Rol;


public interface RolRespository extends MongoRepository<Rol, String>{

	@Query("{ 'nombre' : ?0 }")
	Rol findByNombre(String nombre);
		
}
