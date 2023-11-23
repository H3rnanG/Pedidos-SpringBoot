package com.app.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.interfaces.RolDao;
import com.app.model.Rol;
import com.app.repository.RolRespository;

@Service
public class RolDaoImpl implements RolDao{

	@Autowired
    private RolRespository rolRepository;
	
	@Override
	public void addRol(Rol rol) {	
		rolRepository.save(rol);
	}

}
