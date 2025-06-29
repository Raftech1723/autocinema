package com.pelicula.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pelicula.entity.Pelicula;
import com.pelicula.repository.PeliculaRepository;

@Service
public class PeliculaServiceImpl implements PeliculaService {
	
	@Autowired
    private PeliculaRepository peliculaRepository;

    @Override
    public List<Pelicula> listarPelicula() {
        return peliculaRepository.findAll();
    }

    @Override
    public Pelicula getIdPelicula(Long id) {
        return peliculaRepository.findById(id).orElse(null);
    }

    @Override
    public void crearActualizarPelicula(Pelicula pelicula) {
        peliculaRepository.save(pelicula);
    }

    @Override
    public void eliminarPelicula(Long id) {
        peliculaRepository.deleteById(id);
    }

    @Override
    public List<Pelicula> buscarPorCategoria(Integer categoriaId) {
        return peliculaRepository.findByCategoriaId(categoriaId);
    }

}
