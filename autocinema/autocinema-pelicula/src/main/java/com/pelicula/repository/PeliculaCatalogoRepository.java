package com.pelicula.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pelicula.entity.PeliculaCatalogo;

public interface PeliculaCatalogoRepository extends JpaRepository<PeliculaCatalogo, Long> {
	
	List<PeliculaCatalogo> findByCategoriaId(Long categoriaId);
}
