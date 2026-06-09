package com.reservas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reservas.dto.ReservaDTO;
import com.reservas.feign.VueloFeign;
import com.reservas.feign.VueloReservaFeing;
import com.reservas.model.Reserva;
import com.reservas.repository.IReservaRepository;


@Service
public class ReservaService {
	
	@Autowired
	private IReservaRepository reservaRepository;
	
	@Autowired
	private VueloReservaFeing vueloReservaFeing;
	
	public Reserva crearReserva(ReservaDTO dto) {
		
		VueloFeign vuelo = vueloReservaFeing.reservarVuelo(dto.getIdVuelo());
		
		Reserva reserva = new Reserva();
		reserva.setIdVuelo(dto.getIdVuelo());
		reserva.setPasajeroEmail(dto.getPasajeroEmail());
		reserva.setEstado("RESERVA EXITOSA");
		
		return reservaRepository.save(reserva);			
	}
	
	public List<Reserva> listarReservas(){
	 List<Reserva> reserva = reservaRepository.findAll();
	 return reserva;
	}
	

}
