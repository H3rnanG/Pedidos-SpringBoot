package com.app.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.interfaces.RestauranteDao;
import com.app.model.Restaurante;
import com.app.repository.RestauranteRepository;

@Service
public class RestauranteDaoImpl implements RestauranteDao {

    @Autowired
    private RestauranteRepository restauranteRepository;

    @Override
    public List<Restaurante> getAllRestaurantes() {
        return restauranteRepository.findAll();
    }

    @Override
    public Restaurante getRestaurante(String id) {
        return restauranteRepository.findById(id).orElse(null);
    }

    @Override
    public void addRestaurante(Restaurante restaurante) {
        restauranteRepository.save(restaurante);
    }

    @Override
    public void updateRestaurante(Restaurante restaurante) {
        restauranteRepository.save(restaurante);
    }

    @Override
    public void deleteRestaurante(String id) {
        restauranteRepository.deleteById(id);
    }
}

