package com.pelicula.cliente;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "autocinema-categoria", url = "http://localhost:8011")
public interface CategoriaCliente {
	
	@GetMapping("/api/categorias")
    List<CategoriaDTO> listarCategorias();

}
