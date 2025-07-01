package com.pelicula.cliente;

import com.pelicula.dto.CategoriaDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;

@FeignClient(name = "autocinema-categoria", url = "http://localhost:8011")
public interface CategoriaCliente {

    @GetMapping("/categorias")
    List<CategoriaDTO> listarCategorias();
}
