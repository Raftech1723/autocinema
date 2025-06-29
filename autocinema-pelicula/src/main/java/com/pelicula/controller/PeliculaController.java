package com.pelicula.controller;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pelicula.entity.Pelicula;
import com.pelicula.repository.PeliculaRepository;
import com.pelicula.service.PeliculaService;

@Controller
@RequestMapping("/peliculas")
public class PeliculaController {
	
	@Autowired
    private PeliculaService peliculaService;
	
	@Autowired
    private CategoriaService categoriaService;
	
	@Autowired
    private PeliculaRepository peliculaRepository;

	@GetMapping
    public String listarPeliculas(Model model) {
        List<Pelicula> lista = peliculaService.listarPelicula();
        model.addAttribute("listaPeliculas", lista);
        model.addAttribute("pelicula", new Pelicula());
        model.addAttribute("categorias", categoriaService.listarCategorias());
        return "peliculas";
    }

    
    @GetMapping("/genero/{id}")
    public String listarPeliculasPorGenero(@PathVariable("id") Integer id, Model model) {
        List<Pelicula> peliculasPorGenero = peliculaService.buscarPorCategoria(id);
        model.addAttribute("listaPeliculas", peliculaService.listarPelicula()); // para la tabla
        model.addAttribute("listaPeliculasPorGenero", peliculasPorGenero);      // para el cuadro de películas del género
        model.addAttribute("categorias", categoriaService.listarCategorias());  // para el panel de géneros
        model.addAttribute("pelicula", new Pelicula());                         // para el formulario
        return "peliculas";
    }
    
    @GetMapping("/buscar")
    public String buscarPeliculaPorId(@RequestParam(name = "id", required = false) Long id, Model model) {
        List<Pelicula> pelicula;

        if (id != null) {
            Optional<Pelicula> peliculas = peliculaRepository.findById(id);
            pelicula = peliculas.map(Collections::singletonList).orElse(Collections.emptyList());
        } else {
            pelicula = peliculaRepository.findAll();
        }

        model.addAttribute("pelicula", new Pelicula());
        model.addAttribute("listaPeliculas", pelicula);
        model.addAttribute("categorias", categoriaService.listarCategorias());
        
        return "peliculas";
    }

    @PostMapping("/guardar")
    public String guardarPelicula(@ModelAttribute Pelicula pelicula) {
        peliculaService.crearActualizarPelicula(pelicula);
        return "peliculas";
    }

    @GetMapping("/editar/{id}")
    public String editarPelicula(@PathVariable Long id, Model model) {
        Pelicula pelicula = peliculaService.getIdPelicula(id);
        model.addAttribute("pelicula", pelicula);
        model.addAttribute("listaPeliculas", peliculaService.listarPelicula());
        model.addAttribute("categorias", categoriaService.listarCategorias());
        return "peliculas";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarPelicula(@PathVariable Long id) {
        peliculaService.eliminarPelicula(id);
        return "redirect:/peliculas";
    }

}
