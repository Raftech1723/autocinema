package com.metodopago.controller;

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

import com.metodopago.entity.MetodoPago;
import com.metodopago.repository.MetodoPagoRepository;
import com.metodopago.service.MetodoPagoService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/metodos_pago")
public class MetodoPagoController {
	
	@Autowired
    private MetodoPagoService metodoPagoService;
    
    @Autowired
    private MetodoPagoRepository metodopagoRepository;
    
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
    public String listarMetodosPago(Model model, HttpServletRequest request) {
        model.addAttribute("listaMetodos", metodoPagoService.listarMetodoPago());
        model.addAttribute("nuevoMetodo", new MetodoPago());
        model.addAttribute("baseUrl", obtenerBaseUrl(request)); // ✅ Agregado
        return "metodos_pago";
    }
    
    @GetMapping("/buscar")
    public String buscarMetodoPagoPorId(@RequestParam(name = "id", required = false) Long id, Model model, HttpServletRequest request) {
        List<MetodoPago> nuevoMetodo;

        if (id != null) {
            Optional<MetodoPago> metodopagos = metodopagoRepository.findById(id);
            nuevoMetodo = metodopagos.map(Collections::singletonList).orElse(Collections.emptyList());
        } else {
            nuevoMetodo = metodopagoRepository.findAll();
        }

        model.addAttribute("nuevoMetodo", new MetodoPago());
        model.addAttribute("listaMetodos", nuevoMetodo);
        model.addAttribute("baseUrl", obtenerBaseUrl(request)); // ✅ Agregado
        return "metodos_pago";
    }

    @PostMapping("/guardar")
    public String guardarMetodoPago(@ModelAttribute("nuevoMetodo") MetodoPago metodo) {
        metodoPagoService.crearActualizarMetodoPago(metodo);
        return "redirect:/metodos_pago";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarMetodo(@PathVariable Long id) {
        metodoPagoService.eliminarMetodoPago(id);
        return "redirect:/metodos_pago";
    }

    @GetMapping("/editar/{id}")
    public String editarMetodo(@PathVariable Long id, Model model, HttpServletRequest request) {
        MetodoPago metodo = metodoPagoService.getIdMetodoPago(id);
        model.addAttribute("nuevoMetodo", metodo);
        model.addAttribute("listaMetodos", metodoPagoService.listarMetodoPago());
        model.addAttribute("baseUrl", obtenerBaseUrl(request)); // ✅ Agregado
        return "metodos_pago";
    }

}
