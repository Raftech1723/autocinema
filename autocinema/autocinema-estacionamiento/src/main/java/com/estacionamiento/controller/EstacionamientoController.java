package com.estacionamiento.controller;

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

import com.estacionamiento.entity.Estacionamiento;
import com.estacionamiento.repository.EstacionamientoRepository;
import com.estacionamiento.service.EstacionamientoService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/estacionamientos")
public class EstacionamientoController {
	
	 @Autowired
	    private EstacionamientoService estacionamientoService;

	    @Autowired
	    private EstacionamientoRepository estacionamientoRepository;
	    
	 // ✅ Método para construir dinámicamente el baseUrl
	    private String obtenerBaseUrl(HttpServletRequest request) {
	        String url = request.getRequestURL().toString();
	        if (url.contains("9090")) {
	            return "http://localhost:9090";
	        } else {
	            return "http://localhost:" + request.getServerPort();
	        }
	    }


	    // Mostrar formulario inicial
	    @GetMapping
	    public String mostrarFormulario(Model model, HttpServletRequest request) {
	        model.addAttribute("estacionamiento", new Estacionamiento());
	        model.addAttribute("baseUrl", obtenerBaseUrl(request)); // ✅ Agregado
	        return "estacionamientos";
	    }

	    // Buscar por ID o mostrar todos
	    @GetMapping("/buscar")
	    public String buscarEstacionamientoPorId(@RequestParam(name = "id", required = false) Long id,
	                                             Model model, HttpServletRequest request) {
	        List<Estacionamiento> estacionamientos;

	        if (id != null) {
	            Optional<Estacionamiento> estacionamiento = estacionamientoRepository.findById(id);
	            estacionamientos = estacionamiento.map(Collections::singletonList).orElse(Collections.emptyList());
	        } else {
	            estacionamientos = estacionamientoRepository.findAll();
	        }

	        model.addAttribute("estacionamiento", new Estacionamiento());
	        model.addAttribute("listaEstacionamiento", estacionamientos);
	        model.addAttribute("baseUrl", obtenerBaseUrl(request)); // ✅ Agregado
	        return "estacionamientos";
	    }


	    @PostMapping("/guardar")
	    public String guardarEstacionamiento(@ModelAttribute Estacionamiento estacionamiento) {
	        estacionamientoService.crearActualizarEstacionamiento(estacionamiento);
	        return "redirect:/estacionamientos";
	    }

	    @GetMapping("/editar/{id}")
	    public String editarEstacionamiento(@PathVariable Long id, Model model, HttpServletRequest request) {
	        Estacionamiento estacionamiento = estacionamientoService.getIdEstacionamiento(id);
	        model.addAttribute("estacionamiento", estacionamiento);
	        model.addAttribute("listaEstacionamiento", estacionamientoService.listarEstacionamiento());
	        model.addAttribute("baseUrl", obtenerBaseUrl(request)); // ✅ Agregado
	        return "estacionamientos";
	    }

	    @GetMapping("/eliminar/{id}")
	    public String eliminarEstacionamiento(@PathVariable Long id) {
	        estacionamientoService.eliminarEstacionamiento(id);
	        return "redirect:/estacionamientos";
	    }

}
