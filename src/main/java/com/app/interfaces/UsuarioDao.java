package com.app.interfaces;

import com.app.model.Usuario;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public interface UsuarioDao {

    List<Usuario> getAllUsuarios();
    Usuario getUsuario(String id);
    void addUsuario(Usuario cliente);
    void updateUsuario(Usuario cliente);
    void deleteUsuario(String id);
    Optional<Usuario> findByCorreoElectronico(String correo);
    
}
