package com.app.dao;

import com.app.interfaces.UsuarioDao;
import com.app.model.Usuario;
import com.app.repository.UsuarioRepository;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioDaoImpl implements UsuarioDao{

    @Autowired
    private UsuarioRepository usuarioRepository;
    
   @Override
    public List<Usuario> getAllUsuarios() {
        return usuarioRepository.findAll();
    }

    @Override
    public Usuario getUsuario(String id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    @Override
    public void addUsuario(Usuario usuario) {	
    	usuario.setRol("Usuario");
    	usuarioRepository.save(usuario);
    }

    @Override
    public void updateUsuario(Usuario usuario) {
    	usuarioRepository.save(usuario);
    }

    @Override
    public void deleteUsuario(String id) {
    	usuarioRepository.deleteById(id);
    }

	@Override
	public Optional<Usuario> findByCorreoElectronico(String correo) {
		return usuarioRepository.findByCorreoElectronico(correo);
	}
    
}
