package com.login.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.login.model.Usuario;
import com.login.repository.IUsuarioRepository;
import com.login.security.LoginDTO;
import com.login.security.RegistroUsuarioDTO;

@Service
public class UsuarioService {

	@Autowired
	public IUsuarioRepository repo;

	@Autowired
	public BCryptPasswordEncoder passwordEncoder;
	
	public Usuario registrar(RegistroUsuarioDTO dto) {
		if(repo.findByEmail(dto.email).isPresent()) {
			throw new RuntimeException("Correo ya esta registrado");
		}
		Usuario user = new Usuario();
		user.setUserName(dto.userName);
		user.setEmail(dto.email);
		user.setPassword(passwordEncoder.encode(dto.password));
		
		return repo.save(user);
	}

	public Usuario login(LoginDTO dto) {
		Usuario user = repo.findByEmail(dto.email)
				.orElseThrow(() -> new RuntimeException("Error: Usuario no encontrado"));
		if (!passwordEncoder.matches(dto.password, user.getPassword())) {
			throw new RuntimeException("Error: contraseña incorrecta");
		}
		return user;

	}

}
