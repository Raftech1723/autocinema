package com.reclamo.controller;

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

import com.reclamo.entity.Reclamo;
import com.reclamo.repository.ReclamoRepository;
import com.reclamo.service.ReclamoService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/reclamos")
public class ReclamoController {
	
	@Autowired
    private ReclamoService reclamoService;
 
	@Autowired
    private ReclamoRepository reclamoRepository;
	
	// ✅ Método para construir dinámicamente el baseUrl
    private String obtenerBaseUrl(HttpServletRequest request) {
        String url = request.getRequestURL().toString();
        if (url.contains("9090")) {
            return "http://localhost:9090";
        } else {
            return "http://localhost:" + request.getServerPort();
        }
    }


    // Mostrar lista y formulario
    @GetMapping
    public String listarUsuario(Model model, HttpServletRequest request) {
        List<Reclamo> lista = reclamoService.listarReclamo();
        model.addAttribute("listaReclamo", lista); 
        model.addAttribute("reclamo", new Reclamo());
        model.addAttribute("baseUrl", obtenerBaseUrl(request)); // ✅ Agregado
        return "reclamos"; 
    }
    
    @GetMapping("/buscar")
    public String buscarReclamoPorId(@RequestParam(name = "id", required = false) Long id, Model model, HttpServletRequest request) {
        List<Reclamo> reclamo;

        if (id != null) {
            Optional<Reclamo> reclamos = reclamoRepository.findById(id);
            reclamo = reclamos.map(Collections::singletonList).orElse(Collections.emptyList());
        } else {
            reclamo = reclamoRepository.findAll();
        }

        model.addAttribute("reclamo", new Reclamo());
        model.addAttribute("listaReclamo", reclamo);
        model.addAttribute("baseUrl", obtenerBaseUrl(request)); // ✅ Agregado
        return "reclamos";
    }

    // Guardar o actualizar usuario
    @PostMapping("/guardar")
    public String guardarReclamo(@ModelAttribute("reclamos") Reclamo reclamo) {
        reclamoService.crearActualizarReclamo(reclamo);
        return "redirect:/reclamos";
    }

    // Cargar datos en formulario para editar
    @GetMapping("/editar/{id}")
    public String editarReclamo(@PathVariable Long id, Model model, HttpServletRequest request) {
        Reclamo reclamo = reclamoService.getIdReclamo(id);
        model.addAttribute("reclamo", reclamo);
        model.addAttribute("listaReclamo", reclamoService.listarReclamo());
        model.addAttribute("baseUrl", obtenerBaseUrl(request)); // ✅ Agregado
        return "reclamos";
    }

    // Eliminar usuario
    @GetMapping("/eliminar/{id}")
    public String eliminarReclamo(@PathVariable Long id) {
        reclamoService.eliminarReclamo(id);
        return "redirect:/reclamos";
    }

}
