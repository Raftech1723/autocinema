package com.pelicula.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pelicula.entity.Pelicula;

public interface PeliculaRepository extends JpaRepository<Pelicula, Long> {
	
	// NUEVO MÉTODO
    List<Pelicula> findByCategoriaId(int categoriaId);

}
