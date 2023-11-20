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

import com.app.interfaces.DetallePedidoDao;
import com.app.model.DetallePedido;

import com.app.services.JsonResponseComponent;
import com.fasterxml.jackson.databind.JsonNode;

@RestController
@RequestMapping("/platoPedido")
public class DetallePedidoController {

    @Autowired
    private JsonResponseComponent jsonResponseComponent;

    @Autowired
    private DetallePedidoDao detallePedidoDao;

    @GetMapping
    public List<DetallePedido> getAllPlatosPedidos() {
        return detallePedidoDao.getAllPlatosPedidos();
    }

    @GetMapping("/")
    public DetallePedido getPlatoPedido(@RequestParam("id") String id) {
        return detallePedidoDao.getPlatoPedido(id);
    }

    @PostMapping("/")
    public ResponseEntity<JsonNode> addPlatoPedido(@RequestBody DetallePedido platoPedido) {
        jsonResponseComponent.clearJsonResponse();
        try {
        	detallePedidoDao.addPlatoPedido(platoPedido);
            jsonResponseComponent.addProperty("message", "Plato Pedido Creado Correctamente.");
        } catch (Exception e) {
            jsonResponseComponent.addProperty("message", e.getMessage());
        }
        return ResponseEntity.ok(jsonResponseComponent.getJsonResponse());
    }

    @PutMapping("/")
    public ResponseEntity<JsonNode> updatePlatoPedido(@RequestBody DetallePedido platoPedido) {
        jsonResponseComponent.clearJsonResponse();
        try {
        	detallePedidoDao.updatePlatoPedido(platoPedido);
            jsonResponseComponent.addProperty("message", "Plato Pedido Actualizado Correctamente.");
        } catch (Exception e) {
            jsonResponseComponent.addProperty("message", e.getMessage());
        }
        return ResponseEntity.ok(jsonResponseComponent.getJsonResponse());
    }

    @DeleteMapping("/")
    public ResponseEntity<JsonNode> deletePlatoPedido(@RequestParam("id") String id) {
        jsonResponseComponent.clearJsonResponse();
        try {
        	detallePedidoDao.deletePlatoPedido(id);
            jsonResponseComponent.addProperty("message", "Plato Pedido Eliminado Correctamente.");
        } catch (Exception e) {
            jsonResponseComponent.addProperty("message", e.getMessage());
        }
        return ResponseEntity.ok(jsonResponseComponent.getJsonResponse());
    }
}
