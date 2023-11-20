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

import com.app.interfaces.RestauranteDao;
import com.app.model.Restaurante;

import com.app.services.JsonResponseComponent;
import com.fasterxml.jackson.databind.JsonNode;

@RestController
@RequestMapping("/restaurante")
public class RestauranteController {

    @Autowired
    private JsonResponseComponent jsonResponseComponent;

    @Autowired
    private RestauranteDao restauranteDao;

    @GetMapping
    public List<Restaurante> getAllRestaurantes() {
        return restauranteDao.getAllRestaurantes();
    }

    @GetMapping("/")
    public Restaurante getRestaurante(@RequestParam("id") String id) {
        return restauranteDao.getRestaurante(id);
    }

    @PostMapping("/")
    public ResponseEntity<JsonNode> addRestaurante(@RequestBody Restaurante restaurante) {
        jsonResponseComponent.clearJsonResponse();
        try {
            restauranteDao.addRestaurante(restaurante);
            jsonResponseComponent.addProperty("message", "Restaurante Creado Correctamente.");
        } catch (Exception e) {
            jsonResponseComponent.addProperty("message", e.getMessage());
        }
        return ResponseEntity.ok(jsonResponseComponent.getJsonResponse());
    }

    @PutMapping("/")
    public ResponseEntity<JsonNode> updateRestaurante(@RequestBody Restaurante restaurante) {
        jsonResponseComponent.clearJsonResponse();
        try {
            restauranteDao.updateRestaurante(restaurante);
            jsonResponseComponent.addProperty("message", "Restaurante Actualizado Correctamente.");
        } catch (Exception e) {
            jsonResponseComponent.addProperty("message", e.getMessage());
        }
        return ResponseEntity.ok(jsonResponseComponent.getJsonResponse());
    }

    @DeleteMapping("/")
    public ResponseEntity<JsonNode> deleteRestaurante(@RequestParam("id") String id) {
        jsonResponseComponent.clearJsonResponse();
        try {
            restauranteDao.deleteRestaurante(id);
            jsonResponseComponent.addProperty("message", "Restaurante Eliminado Correctamente.");
        } catch (Exception e) {
            jsonResponseComponent.addProperty("message", e.getMessage());
        }
        return ResponseEntity.ok(jsonResponseComponent.getJsonResponse());
    }
}

