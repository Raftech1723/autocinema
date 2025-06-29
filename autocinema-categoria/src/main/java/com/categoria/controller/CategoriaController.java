package com.categoria.controller;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.categoria.entity.Categoria;
import com.categoria.repository.CategoriaRepository;
import com.categoria.service.CategoriaService;

@Controller
@RequestMapping("/categorias")
public class CategoriaController {
	
	@Autowired
    private CategoriaService categoriaService;
    @Autowired
    private CategoriaRepository categoriaRepository;

    @GetMapping
    public String mostrarFormulario(Model model) {
        model.addAttribute("categoria", new Categoria());
        return "categorias";
    }
    
    @GetMapping("/buscar")
    public String buscarCategoriaPorId(@RequestParam(name = "id", required = false) Long id, Model model) {
        List<Categoria> categoria;

        if (id != null) {
            Optional<Categoria> categorias = categoriaRepository.findById(id);
            categoria = categorias.map(Collections::singletonList).orElse(Collections.emptyList());
        } else {
            categoria = categoriaRepository.findAll();
        }

        model.addAttribute("categoria", new Categoria());
        model.addAttribute("listaCategoria", categoria);
        return "categorias";
    }

    // Guarda o actualiza la categoría
    @PostMapping("/guardar")
    public String guardarCategoria(@ModelAttribute Categoria categoria) {
        categoriaService.crearActualizarCategoria(categoria);
        return "redirect:/categorias";
    }

    // Editar: carga la categoría en el formulario
    @GetMapping("/editar/{id}")
    public String editarCategoria(@PathVariable Long id, Model model) {
        Categoria categoria = categoriaService.getIdCategoria(id);
        model.addAttribute("categoria", categoria);
        model.addAttribute("listaCategoria", categoriaService.listarCategorias());
        return "categorias";
    }

    // Eliminar categoría
    @GetMapping("/eliminar/{id}")
    public String eliminarCategoria(@PathVariable Long id) {
        categoriaService.eliminarCategoria(id);
        return "redirect:/categorias";
    }

}
