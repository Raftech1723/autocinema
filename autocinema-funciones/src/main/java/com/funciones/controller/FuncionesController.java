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

import com.funciones.entity.Funciones;
import com.funciones.repository.FuncionesRepository;
import com.funciones.service.FuncionesService;

@Controller
@RequestMapping("/funciones")
public class FuncionesController {
	
	@Autowired
    private FuncionesService funcionesService;

    @Autowired
    private PeliculaService peliculaService;

    @Autowired
    private SalaService salaService;
    
    @Autowired
    private FuncionesRepository funcionesRepository;
    
    @GetMapping
    public String mostrarFormulario(Model model) {
        model.addAttribute("funciones", new Funciones());
        return "funciones";
    }
    
    @GetMapping("/buscar")
    public String buscarFuncionesPorId(@RequestParam(name = "id", required = false) Long id,
                                    Model model) {
        List<Funciones> funciones;

        if (id != null) {
            Optional<Funciones> funcion = funcionesRepository.findById(id);
            funciones = funcion.map(Collections::singletonList).orElse(Collections.emptyList());
        } else {
            funciones = funcionesRepository.findAll();
        }

        model.addAttribute("funciones", new Funciones());
        model.addAttribute("listaFunciones", funciones);
        return "funciones";
    }

    @PostMapping("/guardar")
    public String guardarFunciones(@ModelAttribute Funciones funciones) {
        funcionesService.crearActualizarFunciones(funciones);
        return "redirect:/funciones";
    }

    @GetMapping("/editar/{id}")
    public String editarFunciones(@PathVariable Long id, Model model) {
        model.addAttribute("funciones", funcionesService.getIdFunciones(id));
        model.addAttribute("listaFunciones", funcionesService.listarFunciones());
        model.addAttribute("listaPelicula", peliculaService.listarPelicula());
        model.addAttribute("listaSala", salaService.listarSala());
        return "funciones";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarFunciones(@PathVariable Long id) {
        funcionesService.eliminarFunciones(id);
        return "redirect:/funciones";
    }

}
