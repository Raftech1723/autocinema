package com.funciones.controller;

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

import com.funciones.cliente.PeliculaCliente;
import com.funciones.cliente.SalaCliente;
import com.funciones.entity.Funciones;
import com.funciones.repository.FuncionesRepository;
import com.funciones.service.FuncionesService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/funciones")
public class FuncionesController {
	
	@Autowired
    private FuncionesService funcionesService;

	@Autowired
    private PeliculaCliente peliculaCliente;

    @Autowired
    private SalaCliente salaCliente;
    
    @Autowired
    private FuncionesRepository funcionesRepository;
    
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
    public String mostrarFormulario(Model model, HttpServletRequest request) {
        model.addAttribute("funciones", new Funciones());
        model.addAttribute("baseUrl", obtenerBaseUrl(request)); // ✅ Agregado
        return "funciones";
    }
    
    @GetMapping("/buscar")
    public String buscarFuncionesPorId(@RequestParam(name = "id", required = false) Long id,
                                    Model model, HttpServletRequest request) {
        List<Funciones> funciones;

        if (id != null) {
            Optional<Funciones> funcion = funcionesRepository.findById(id);
            funciones = funcion.map(Collections::singletonList).orElse(Collections.emptyList());
        } else {
            funciones = funcionesRepository.findAll();
        }

        model.addAttribute("funciones", new Funciones());
        model.addAttribute("listaFunciones", funciones);
        model.addAttribute("baseUrl", obtenerBaseUrl(request)); // ✅ Agregado
        return "funciones";
    }

    @PostMapping("/guardar")
    public String guardarFunciones(@ModelAttribute Funciones funciones) {
        funcionesService.crearActualizarFunciones(funciones);
        return "redirect:/funciones";
    }

    @GetMapping("/editar/{id}")
    public String editarFunciones(@PathVariable Long id, Model model, HttpServletRequest request) {
        model.addAttribute("funciones", funcionesService.getIdFunciones(id));
        model.addAttribute("listaFunciones", funcionesService.listarFunciones());
        model.addAttribute("listaPelicula", peliculaCliente.listarPeliculas());
        model.addAttribute("listaSala", salaCliente.listarSalas());
        model.addAttribute("baseUrl", obtenerBaseUrl(request)); // ✅ Agregado
        return "funciones";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarFunciones(@PathVariable Long id) {
        funcionesService.eliminarFunciones(id);
        return "redirect:/funciones";
    }

}
