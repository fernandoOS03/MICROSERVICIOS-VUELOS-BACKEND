	package com.reservas.feign;
	
	import org.springframework.cloud.openfeign.FeignClient;
	import org.springframework.web.bind.annotation.PathVariable;
	import org.springframework.web.bind.annotation.PostMapping;
	
	//@FeignClient(name = "servicio-vuelos", url = "http://localhost:8092/api/vuelos")
	@FeignClient(name = "servicio-vuelos", path = "/api/vuelos")
	public interface VueloReservaFeing {
		
		@PostMapping("/reservar/{idVuelo}")
		VueloFeign reservarVuelo(@PathVariable Integer idVuelo);
		
	
	}
