package com.categoria.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.categoria.entity.ImagenCategoria;

@Repository
public interface ImagenCategoriaRepository extends JpaRepository<ImagenCategoria, Long> {
	List<ImagenCategoria> findByCategoriaId(Long categoriaId);
}