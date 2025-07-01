package com.funciones.cliente;

import com.funciones.dto.PeliculaDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;

@FeignClient(name = "autocinema-pelicula", url = "http://localhost:8003")
public interface PeliculaCliente {

    @GetMapping("/peliculas") // Asegúrate que este endpoint exista en el microservicio de películas
    List<PeliculaDTO> listarPeliculas();
}
