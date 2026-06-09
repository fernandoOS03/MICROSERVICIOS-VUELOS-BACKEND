package com.vuelos.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "vuelos")
@AllArgsConstructor
@NoArgsConstructor
public class Vuelo {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idVuelo;
    private String origen;
    private String destino;
    private Double precio;
    private Integer asientosDisponibles;

}
