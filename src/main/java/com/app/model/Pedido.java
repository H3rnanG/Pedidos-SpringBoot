package com.app.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Document(collection = "pedidos")
public class Pedido {

    @Id
    private String idPedido;

    @Field("idUsuario")
    private String idUsuario;

    @Field("idRestaurante")
    private String idRestaurante;

    @Field("productos")
    private List<DetallePedido> productos;

    @Field("total")
    private double total;

    @Field("estado")
    private String estado;

    public Pedido() {
    }
}
