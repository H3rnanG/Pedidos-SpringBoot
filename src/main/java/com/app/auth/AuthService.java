package com.app.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.app.Jwt.JwtService;
import com.app.interfaces.UsuarioDao;
import com.app.model.Usuario;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {
	
	@Autowired
	private UsuarioDao usuarioDao;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private JwtService jwtService;

	@Autowired
	private AuthenticationManager authenticationManager;
	
	public AuthResponse login(LoginRequest request) {
		authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getCorreoElectronico(), request.getPassword()));
		UserDetails user = usuarioDao.findByCorreoElectronico(request.getCorreoElectronico()).orElseThrow();
		
		String token = jwtService.getToken(user);
		
		return AuthResponse.builder()
				.token(token)
				.build();
	}

	public AuthResponse register(RegisterRequest request) {
		Usuario usuario = Usuario.builder()
				.nombre(request.getNombre())
				.correoElectronico(request.getCorreoElectronico())
				.password(passwordEncoder.encode(request.getPassword()))
				.direccion(request.getDireccion())
				.numeroTelefono(request.getNumeroTelefono())
				.rol(request.getRol())
				.build();
		
		usuarioDao.addUsuario(usuario);
		
		return AuthResponse.builder()
				.token(jwtService.getToken(usuario))
				.build();
		
	}
	
}
