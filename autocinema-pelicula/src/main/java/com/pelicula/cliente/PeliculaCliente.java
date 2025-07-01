package com.pelicula.cliente;

import com.pelicula.dto.PeliculaDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;

@FeignClient(name = "autocinema-pelicula", url = "http://localhost:8003")
public interface PeliculaCliente {

    @GetMapping("/peliculas")
    List<PeliculaDTO> listarPeliculas();
}
