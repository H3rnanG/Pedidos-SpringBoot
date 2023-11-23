package com.app.interfaces;

import org.springframework.stereotype.Service;

import com.app.model.Rol;

@Service
public interface RolDao {

	void addRol(Rol rol);
	
}
