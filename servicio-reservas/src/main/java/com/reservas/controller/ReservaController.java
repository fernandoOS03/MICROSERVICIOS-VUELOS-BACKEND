package com.reservas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reservas.dto.ReservaDTO;
import com.reservas.model.Reserva;
import com.reservas.service.ReservaService;

@RestController
@RequestMapping("api/reservar")
public class ReservaController {
	
	@Autowired
	public ReservaService reservaService;
	
	@PostMapping
	public ResponseEntity<?> reservarVuelo(@RequestBody ReservaDTO reservaDTO){
		try {
			Reserva reserva = reservaService.crearReserva(reservaDTO);
			return ResponseEntity.status(HttpStatus.CREATED).body(reserva);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}
	
	@GetMapping
	public List<Reserva> listarReservas(){
		return reservaService.listarReservas();
	}



}
