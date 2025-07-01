   package com.categoria.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.categoria.entity.Categoria;
import com.categoria.service.CategoriaService;

@RestController
@RequestMapping("/api/categorias")
public class CategoriaRestController {
	
	@Autowired
    private CategoriaService categoriaService;

    @GetMapping
    public List<Categoria> listarCategorias() {
        return categoriaService.listarCategorias();
    }

}
