package com.app.interfaces;

import com.app.model.Plato;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PlatoDao {

    List<Plato> getAllPlatos();

    Plato getPlato(String id);

    void addPlato(Plato plato);

    void updatePlato(Plato plato);

    void deletePlato(String id);
}
