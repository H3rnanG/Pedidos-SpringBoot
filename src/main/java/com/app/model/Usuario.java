package com.app.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@AllArgsConstructor
@Document(collection = "usuario")
public class Usuario {
    
	@Id
    private String idUsuario;

	@Field("nombre")
    private String nombre;

    @Field("correoElectronico")
    private String correoElectronico;

    @Field("contraseña")
    private String contraseña;

    @Field("direccion")
    private String direccion;

    @Field("numeroTelefono")
    private String numeroTelefono;

    public Usuario() {
    }
    
}
