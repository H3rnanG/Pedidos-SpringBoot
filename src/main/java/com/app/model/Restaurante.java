package com.app.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Document(collection = "restaurante")
public class Restaurante {

    @Id
    private String idRestaurante;

    @Field("nombre")
    private String nombre;

    @Field("categoria")
    private String categoria;

    @Field("direccion")
    private String direccion;

    @Field("menu")
    private List<Plato> menu;

    public Restaurante() {
    }
}
