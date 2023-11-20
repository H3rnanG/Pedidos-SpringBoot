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

import com.app.interfaces.PedidoDao;
import com.app.model.Pedido;

import com.app.services.JsonResponseComponent;
import com.fasterxml.jackson.databind.JsonNode;

@RestController
@RequestMapping("/pedido")
public class PedidoController {

    @Autowired
    private JsonResponseComponent jsonResponseComponent;

    @Autowired
    private PedidoDao pedidoDao;

    @GetMapping
    public List<Pedido> getAllPedidos() {
        return pedidoDao.getAllPedidos();
    }

    @GetMapping("/")
    public Pedido getPedido(@RequestParam("id") String id) {
        return pedidoDao.getPedido(id);
    }

    @PostMapping("/")
    public ResponseEntity<JsonNode> addPedido(@RequestBody Pedido pedido) {
        jsonResponseComponent.clearJsonResponse();
        try {
            pedidoDao.addPedido(pedido);
            jsonResponseComponent.addProperty("message", "Pedido Creado Correctamente.");
        } catch (Exception e) {
            jsonResponseComponent.addProperty("message", e.getMessage());
        }
        return ResponseEntity.ok(jsonResponseComponent.getJsonResponse());
    }

    @PutMapping("/")
    public ResponseEntity<JsonNode> updatePedido(@RequestBody Pedido pedido) {
        jsonResponseComponent.clearJsonResponse();
        try {
            pedidoDao.updatePedido(pedido);
            jsonResponseComponent.addProperty("message", "Pedido Actualizado Correctamente.");
        } catch (Exception e) {
            jsonResponseComponent.addProperty("message", e.getMessage());
        }
        return ResponseEntity.ok(jsonResponseComponent.getJsonResponse());
    }

    @DeleteMapping("/")
    public ResponseEntity<JsonNode> deletePedido(@RequestParam("id") String id) {
        jsonResponseComponent.clearJsonResponse();
        try {
            pedidoDao.deletePedido(id);
            jsonResponseComponent.addProperty("message", "Pedido Eliminado Correctamente.");
        } catch (Exception e) {
            jsonResponseComponent.addProperty("message", e.getMessage());
        }
        return ResponseEntity.ok(jsonResponseComponent.getJsonResponse());
    }
}
