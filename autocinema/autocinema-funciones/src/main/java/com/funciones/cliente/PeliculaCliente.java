package com.funciones.cliente;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.funciones.cliente.PeliculaDTO;

@FeignClient(name = "autocinema-pelicula", url = "http://localhost:8003")
public interface PeliculaCliente {
    
    @GetMapping("/api/peliculas")
    List<PeliculaDTO> listarPeliculas();

    @GetMapping("/api/peliculas/{id}")
    PeliculaDTO buscarPorId(@PathVariable("id") Long id);
}
