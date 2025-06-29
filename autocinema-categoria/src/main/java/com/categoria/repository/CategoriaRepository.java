package com.categoria.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.categoria.entity.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

}
