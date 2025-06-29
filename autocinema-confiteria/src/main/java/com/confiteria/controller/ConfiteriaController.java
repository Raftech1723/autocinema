package com.confiteria.controller;

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

import com.confiteria.entity.Confiteria;
import com.confiteria.repository.ConfiteriaRepository;
import com.confiteria.service.ConfiteriaService;

@Controller
@RequestMapping("/confiterias")
public class ConfiteriaController {
	
	@Autowired
    private ConfiteriaService confiteriaService;
	@Autowired
    private ConfiteriaRepository confiteriaRepository;

    @GetMapping
    public String mostrarFormulario(Model model) {
        model.addAttribute("confiteria", new Confiteria());
        return "confiterias";
    }
    
    @GetMapping("/buscar")
    public String buscarConfiteriaPorId(@RequestParam(name = "id", required = false) Long id,
                                    Model model) {
        List<Confiteria> confiteria;

        if (id != null) {
            Optional<Confiteria> confiterias = confiteriaRepository.findById(id);
            confiteria = confiterias.map(Collections::singletonList).orElse(Collections.emptyList());
        } else {
        	confiteria = confiteriaRepository.findAll();
        }

        model.addAttribute("confiteria", new Confiteria());
        model.addAttribute("listaConfiterias", confiteria);
        return "confiterias";
    }

        
    @PostMapping("/guardar")
    public String guardarConfiteria(@ModelAttribute Confiteria confiteria) {
        confiteriaService.crearActualizarConfiteria(confiteria);
        return "redirect:/confiterias";
    }

    @GetMapping("/editar/{id}")
    public String editarConfiteria(@PathVariable Long id, Model model) {
        Confiteria confiteria = confiteriaService.getIdConfiteria(id);
        model.addAttribute("confiteria", confiteria);
        model.addAttribute("listaConfiterias", confiteriaService.listarConfiteria());
        return "confiterias";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarConfiteria(@PathVariable Long id) {
        confiteriaService.eliminarConfiteria(id);
        return "redirect:/confiterias";
    }


}
