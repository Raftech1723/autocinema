package com.boletos.controller;

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

import com.boletos.entity.Boletos;
import com.boletos.repository.BoletosRepository;
import com.boletos.service.BoletosService;

@Controller
@RequestMapping("/boletos")
public class BoletosController {
	
	@Autowired
    private BoletosService boletosService;
    
    @Autowired
    private BoletosRepository boletosRepository;
    
    @GetMapping
    public String mostrarFormulario(Model model) {
        model.addAttribute("boleto", new Boletos());
        return "boletos";
    }
    
    @GetMapping("/buscar")
    public String buscarBoletoPorId(@RequestParam(name = "id", required = false) Long id,
                                    Model model) {
        List<Boletos> boletos;

        if (id != null) {
            Optional<Boletos> boleto = boletosRepository.findById(id);
            boletos = boleto.map(Collections::singletonList).orElse(Collections.emptyList());
        } else {
            boletos = boletosRepository.findAll();
        }

        model.addAttribute("boleto", new Boletos());
        model.addAttribute("listaBoletos", boletos);
        return "boletos";
    }

    @PostMapping("/guardar")
    public String guardarBoleto(@ModelAttribute Boletos boleto) {
        boletosService.guardar(boleto);
        return "redirect:/boletos";
    }

    @GetMapping("/editar/{id}")
    public String editarBoleto(@PathVariable("id") Long id, Model model) {
        model.addAttribute("boleto", boletosService.buscarPorId(id));
        model.addAttribute("listaBoletos", boletosService.listarBoletos());
        return "boletos";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarBoleto(@PathVariable("id") Long id) {
        boletosService.eliminarBoletos(id);
        return "redirect:/boletos";
    }

}
