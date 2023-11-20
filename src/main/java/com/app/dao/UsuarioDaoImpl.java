package com.app.dao;

import com.app.interfaces.UsuarioDao;
import com.app.model.Usuario;
import com.app.repository.UsuarioRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioDaoImpl implements UsuarioDao{

    @Autowired
    private UsuarioRepository clienteRepository;

   @Override
    public List<Usuario> getAllUsuarios() {
        return clienteRepository.findAll();
    }

    @Override
    public Usuario getUsuario(String id) {
        return clienteRepository.findById(id).orElse(null);
    }

    @Override
    public void addUsuario(Usuario cliente) {
        clienteRepository.save(cliente);
    }

    @Override
    public void updateUsuario(Usuario cliente) {
        clienteRepository.save(cliente);
    }

    @Override
    public void deleteUsuario(String id) {
        clienteRepository.deleteById(id);
    }
    
}
