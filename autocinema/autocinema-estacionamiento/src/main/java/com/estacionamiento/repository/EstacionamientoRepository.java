package com.estacionamiento.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.estacionamiento.entity.Estacionamiento;

public interface EstacionamientoRepository extends JpaRepository<Estacionamiento, Long> {

}
