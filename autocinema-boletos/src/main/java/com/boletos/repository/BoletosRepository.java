package com.boletos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.boletos.entity.Boletos;

public interface BoletosRepository extends JpaRepository<Boletos, Long> {

}
