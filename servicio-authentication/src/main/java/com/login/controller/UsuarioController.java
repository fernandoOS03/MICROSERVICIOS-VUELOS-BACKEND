package com.login.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.login.model.Usuario;
import com.login.security.JwtUtil;
import com.login.security.LoginDTO;
import com.login.security.RegistroUsuarioDTO;
import com.login.service.UsuarioService;

@RestController	
@RequestMapping("/api/usuarios")
public class UsuarioController {

	@Autowired
	private UsuarioService servicio;

	@Autowired
	private JwtUtil jwtUtil;

	@PostMapping("/registrar")
	public ResponseEntity<?> registarUsuario(@RequestBody RegistroUsuarioDTO dto) {
		try {
			Usuario nuevo = servicio.registrar(dto);
			System.out.println("Llegue aqui");
			return ResponseEntity.status(HttpStatus.CREATED).body(nuevo);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody  LoginDTO dto) {
		try {
			Usuario usuario = servicio.login(dto);

			String token = jwtUtil.generateToken(usuario.getUserName());
			return ResponseEntity.ok(Map.of("token", token, "usuario", usuario));

		} catch (Exception e) {
			System.out.println("Estoy en login");
		return	ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
		}

	}
}
