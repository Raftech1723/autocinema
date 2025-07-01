package com.categoria.service;

import java.util.List;

import com.categoria.entity.Categoria;

public interface CategoriaService {
	
	List<Categoria> listarCategorias();
    Categoria getIdCategoria(Long id);
    void crearActualizarCategoria(Categoria categoria);
    void eliminarCategoria(Long id);

}
