package com.vuelos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vuelos.model.Vuelo;

public interface IvuelosRepository extends JpaRepository<Vuelo, Integer> {

}
