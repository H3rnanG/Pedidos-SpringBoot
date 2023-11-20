package com.app.interfaces;

import java.util.List;

import org.springframework.stereotype.Service;

import com.app.model.Restaurante;

@Service
public interface RestauranteDao {

    List<Restaurante> getAllRestaurantes();
    Restaurante getRestaurante(String id);
    void addRestaurante(Restaurante restaurante);
    void updateRestaurante(Restaurante restaurante);
    void deleteRestaurante(String id);
    
}
