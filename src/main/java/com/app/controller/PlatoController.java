package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.interfaces.PlatoDao;
import com.app.model.Plato;

import com.app.services.JsonResponseComponent;
import com.fasterxml.jackson.databind.JsonNode;

@RestController
@RequestMapping("/plato")
public class PlatoController {

    @Autowired
    private JsonResponseComponent jsonResponseComponent;

    @Autowired
    private PlatoDao platoDao;

    @GetMapping
    public List<Plato> getAllPlatos() {
        return platoDao.getAllPlatos();
    }

    @GetMapping("/")
    public Plato getPlato(@RequestParam("id") String id) {
        return platoDao.getPlato(id);
    }

    @PostMapping("/")
    public ResponseEntity<JsonNode> addPlato(@RequestBody Plato plato) {
        jsonResponseComponent.clearJsonResponse();
        try {
            platoDao.addPlato(plato);
            jsonResponseComponent.addProperty("message", "Plato Creado Correctamente.");
        } catch (Exception e) {
            jsonResponseComponent.addProperty("message", e.getMessage());
        }
        return ResponseEntity.ok(jsonResponseComponent.getJsonResponse());
    }

    @PutMapping("/")
    public ResponseEntity<JsonNode> updatePlato(@RequestBody Plato plato) {
        jsonResponseComponent.clearJsonResponse();
        try {
            platoDao.updatePlato(plato);
            jsonResponseComponent.addProperty("message", "Plato Actualizado Correctamente.");
        } catch (Exception e) {
            jsonResponseComponent.addProperty("message", e.getMessage());
        }
        return ResponseEntity.ok(jsonResponseComponent.getJsonResponse());
    }

    @DeleteMapping("/")
    public ResponseEntity<JsonNode> deletePlato(@RequestParam("id") String id) {
        jsonResponseComponent.clearJsonResponse();
        try {
            platoDao.deletePlato(id);
            jsonResponseComponent.addProperty("message", "Plato Eliminado Correctamente.");
        } catch (Exception e) {
            jsonResponseComponent.addProperty("message", e.getMessage());
        }
        return ResponseEntity.ok(jsonResponseComponent.getJsonResponse());
    }
}