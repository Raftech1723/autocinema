package com.pelicula.service;

import java.util.List;

import com.pelicula.entity.Pelicula;

public interface PeliculaService {
	
	List<Pelicula> listarPelicula();
    Pelicula getIdPelicula(Long id);
    void crearActualizarPelicula(Pelicula pelicula);
    void eliminarPelicula(Long id);
    List<Pelicula> buscarPorCategoria(Integer categoriaId);

}
