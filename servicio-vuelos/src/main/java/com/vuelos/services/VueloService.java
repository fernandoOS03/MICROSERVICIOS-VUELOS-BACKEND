package com.vuelos.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vuelos.model.Vuelo;
import com.vuelos.repository.IvuelosRepository;
import com.vuelos.seguridad.crearVueloDTO;

@Service
public class VueloService {

	@Autowired
	private IvuelosRepository repo;

	public Vuelo crearVuelo(crearVueloDTO dto) {
		Vuelo vuelo = new Vuelo();
		vuelo.setOrigen(dto.origen);
		vuelo.setDestino(dto.destino);
		vuelo.setPrecio(dto.precio);
		vuelo.setAsientosDisponibles(dto.asientosDisponibles);

		return repo.save(vuelo);
	}

	public Vuelo reservarVuelo(Integer idVuelo) {
		Vuelo vuelo = repo.findById(idVuelo)
				.orElseThrow(() -> new RuntimeException("Error: Vuelo no encontrado"));
		
		if(vuelo.getAsientosDisponibles() <= 0) {		
			throw new RuntimeException("No hay asientos disponibles");
		}
		
		vuelo.setAsientosDisponibles(vuelo.getAsientosDisponibles() - 1) ;
		
		return repo.save(vuelo);
	}
	
	public List<Vuelo> listarVuelo(){
		List<Vuelo> vuelo = repo.findAll();
		return vuelo;
	}
}
