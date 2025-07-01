package com.sala.controller;

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

import com.sala.entity.Sala;
import com.sala.repository.SalaRepository;
import com.sala.service.SalaService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/salas")
public class SalaController {
	
	@Autowired
    private SalaService salaService;
	
	@Autowired
    private SalaRepository salaRepository;
	
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
    public String listarSala(Model model, HttpServletRequest request) {
        List<Sala> lista = salaService.listarSala();
        model.addAttribute("listaSala", lista);
        model.addAttribute("sala", new Sala());
        model.addAttribute("baseUrl", obtenerBaseUrl(request)); // ✅ Agregado
        return "salas";
    }
    
    @GetMapping("/buscar")
    public String buscarSalaPorId(@RequestParam(name = "id", required = false) Long id, Model model, HttpServletRequest request) {
        List<Sala> sala;

        if (id != null) {
            Optional<Sala> salas = salaRepository.findById(id);
            sala = salas.map(Collections::singletonList).orElse(Collections.emptyList());
        } else {
            sala = salaRepository.findAll();
        }

        model.addAttribute("sala", new Sala());
        model.addAttribute("listaSala", sala);
        model.addAttribute("baseUrl", obtenerBaseUrl(request)); // ✅ Agregado
        return "salas";
    }

    @PostMapping("/guardar")
    public String guardarSala(@ModelAttribute Sala sala) {
        salaService.crearActualizarSala(sala);
        return "redirect:/salas";
    }

    @GetMapping("/editar/{id}")
    public String editarSala(@PathVariable Long id, Model model, HttpServletRequest request) {
        Sala sala = salaService.getIdSala(id);
        model.addAttribute("sala", sala);
        model.addAttribute("listaSala", salaService.listarSala());
        model.addAttribute("baseUrl", obtenerBaseUrl(request)); // ✅ Agregado
        return "salas";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarSala(@PathVariable Long id) {
        salaService.eliminarSala(id);
        return "redirect:/salas";
    }

}
