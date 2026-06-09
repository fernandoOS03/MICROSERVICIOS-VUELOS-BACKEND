package com.vuelos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vuelos.model.Vuelo;
import com.vuelos.seguridad.crearVueloDTO;
import com.vuelos.services.VueloService;

@RestController
@RequestMapping("/api/vuelos")
public class VueloController {
	
	@Autowired
	private VueloService service;
	
	@PostMapping("/crearVuelo")
	public ResponseEntity<?> crearVuelo(@RequestBody crearVueloDTO dto){
		try {
			Vuelo vuelo = service.crearVuelo(dto);
			return ResponseEntity.status(HttpStatus.CREATED).body(vuelo);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
	@PostMapping("/reservar/{idVuelo}")
	public ResponseEntity<?> reservarVuelo(@PathVariable("idVuelo")  Integer idVuelo){
		try {
			Vuelo vuelo = service.reservarVuelo(idVuelo);
			return ResponseEntity.status(HttpStatus.CREATED).body(vuelo);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
	@GetMapping
	public List<Vuelo> listarVuelos(){
		return service.listarVuelo();
		
	}
	


}
