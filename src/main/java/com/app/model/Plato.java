package com.app.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Document(collection = "plato")
public class Plato {

	@Id
    private String idPlato;

	@Field("idRestaurante")
    private String idRestaurante;

	@Field("nombre")
    private String nombre;

	@Field("descripción")
    private String descripción;

	@Field("precio")
    private double precio;

	@Field("tipo")
    private String tipo;

	@Field("disponibilidad")
    private boolean disponibilidad;

    public Plato() {
    }
	
}
