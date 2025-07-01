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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.pelicula.cliente.CategoriaCliente;
import com.pelicula.entity.Pelicula;
import com.pelicula.repository.PeliculaRepository;
import com.pelicula.service.PeliculaService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/peliculas")
public class PeliculaController {
	
	@Autowired
    private PeliculaService peliculaService;
	
	@Autowired
    private CategoriaCliente categoriaCliente;
	
	@Autowired
    private PeliculaRepository peliculaRepository;
	
	// ✅ Método para construir dinámicamente el baseUrl
    private String obtenerBaseUrl(HttpServletRequest request) {
        String url = request.getRequestURL().toString();
        if (url.contains("9090")) {
            return "http://localhost:9090";
        } else {
            return "http://localhost:" + request.getServerPort();
        }
    }


	@GetMapping
    public String listarPeliculas(Model model, HttpServletRequest request) {
        List<Pelicula> lista = peliculaService.listarPelicula();
        model.addAttribute("listaPeliculas", lista);
        model.addAttribute("pelicula", new Pelicula());
        model.addAttribute("categorias", categoriaCliente.listarCategorias());
        model.addAttribute("baseUrl", obtenerBaseUrl(request)); // ✅ Agregado
        return "peliculas";
    }

    
    @GetMapping("/genero/{id}")
    public String listarPeliculasPorGenero(@PathVariable("id") Integer id, Model model, HttpServletRequest request) {
        List<Pelicula> peliculasPorGenero = peliculaService.buscarPorCategoria(id);
        model.addAttribute("listaPeliculas", peliculaService.listarPelicula()); // para la tabla
        model.addAttribute("listaPeliculasPorGenero", peliculasPorGenero);      // para el cuadro de películas del género
        model.addAttribute("categorias", categoriaCliente.listarCategorias());  // para el panel de géneros
        model.addAttribute("pelicula", new Pelicula());                         // para el formulario
        model.addAttribute("baseUrl", obtenerBaseUrl(request)); // ✅ Agregado
        return "peliculas";
    }
    
    @GetMapping("/buscar")
    public String buscarPeliculaPorId(@RequestParam(name = "id", required = false) Long id, Model model, HttpServletRequest request) {
        List<Pelicula> pelicula;

        if (id != null) {
            Optional<Pelicula> peliculas = peliculaRepository.findById(id);
            pelicula = peliculas.map(Collections::singletonList).orElse(Collections.emptyList());
        } else {
            pelicula = peliculaRepository.findAll();
        }

        model.addAttribute("pelicula", new Pelicula());
        model.addAttribute("listaPeliculas", pelicula);
        model.addAttribute("categorias", categoriaCliente.listarCategorias());
        model.addAttribute("baseUrl", obtenerBaseUrl(request)); // ✅ Agregado 
        return "peliculas";
    }

    @PostMapping("/guardar")
    public String guardarPelicula(@ModelAttribute Pelicula pelicula) {
        peliculaService.crearActualizarPelicula(pelicula);
        return "peliculas";
    }

    @GetMapping("/editar/{id}")
    public String editarPelicula(@PathVariable Long id, Model model, HttpServletRequest request) {
        Pelicula pelicula = peliculaService.getIdPelicula(id);
        model.addAttribute("pelicula", pelicula);
        model.addAttribute("listaPeliculas", peliculaService.listarPelicula());
        model.addAttribute("categorias", categoriaCliente.listarCategorias());
        model.addAttribute("baseUrl", obtenerBaseUrl(request)); // ✅ Agregado
        return "peliculas";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarPelicula(@PathVariable Long id) {
        peliculaService.eliminarPelicula(id);
        return "redirect:/peliculas";
    }

}
