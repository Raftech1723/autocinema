package com.pelicula.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.pelicula.cliente.CategoriaDTO;

@FeignClient(name = "categoria-service", url = "http://localhost:8011")
public interface CategoriaClient {
    @GetMapping("/api/categorias/{id}/imagen")
    String imagenPorCategoriaId(@PathVariable("id") Long id);

    @GetMapping("/api/categorias")
    List<CategoriaDTO> listarCategorias();
}