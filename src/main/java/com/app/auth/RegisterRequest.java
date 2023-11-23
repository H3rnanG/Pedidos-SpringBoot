package com.app.auth;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {

    String nombre;
    String correoElectronico;
    String password;
    String direccion;
    String numeroTelefono;
    String rol;
	
}
