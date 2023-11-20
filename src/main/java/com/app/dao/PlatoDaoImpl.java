package com.app.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.interfaces.PlatoDao;
import com.app.model.Plato;
import com.app.repository.PlatoRepository;

@Service
public class PlatoDaoImpl implements PlatoDao {

    @Autowired
    private PlatoRepository platoRepository;

    @Override
    public List<Plato> getAllPlatos() {
        return platoRepository.findAll();
    }

    @Override
    public Plato getPlato(String id) {
        return platoRepository.findById(id).orElse(null);
    }

    @Override
    public void addPlato(Plato plato) {
        platoRepository.save(plato);
    }

    @Override
    public void updatePlato(Plato plato) {
        platoRepository.save(plato);
    }

    @Override
    public void deletePlato(String id) {
        platoRepository.deleteById(id);
    }
}

