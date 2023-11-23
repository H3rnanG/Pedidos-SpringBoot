package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.interfaces.RolDao;
import com.app.model.Rol;
import com.app.services.JsonResponseComponent;
import com.fasterxml.jackson.databind.JsonNode;

@RestController
@RequestMapping("/rol")
public class RolController {

	@Autowired
	private JsonResponseComponent jsonResponseComponent;
	
	@Autowired
	private RolDao rolDao;
	
	@PostMapping("/")
	public ResponseEntity<JsonNode> addRol(@RequestBody Rol rol) {
        jsonResponseComponent.clearJsonResponse();
        try {
        	rolDao.addRol(rol);
            jsonResponseComponent.addProperty("message", "Rol Creado Correctamente.");
        } catch (Exception e) {
            jsonResponseComponent.addProperty("message", e.getMessage());
        }
        return ResponseEntity.ok(jsonResponseComponent.getJsonResponse());
    }
	
}
