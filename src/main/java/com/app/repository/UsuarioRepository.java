package com.app.repository;

import com.app.model.Usuario;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends MongoRepository<Usuario, String>{
	
	Optional<Usuario> findByCorreoElectronico(String correoElectronico);

}