package com.funciones.cliente;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "autocinema-pelicula", url = "http://localhost:8003")
public interface PeliculaCliente {
	
	@GetMapping("/peliculas/{id}")
    PeliculaDTO getPeliculaById(@PathVariable Long id);

}
