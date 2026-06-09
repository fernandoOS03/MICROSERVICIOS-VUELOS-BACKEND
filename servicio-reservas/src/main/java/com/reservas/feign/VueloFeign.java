package com.reservas.feign;


import lombok.Data;


@Data
public class VueloFeign {
    private Integer idVuelo;
    private String origen;
    private String destino;
    private Double precio;
    private Integer asientosDisponibles;
}
