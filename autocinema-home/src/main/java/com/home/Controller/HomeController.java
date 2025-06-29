package com.home.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
	@GetMapping({"/home"})
    public String mostrarHome(Model model) {
        model.addAttribute("mensaje", "¡Disfruta de la experiencia del Autocine!");
        return "home";
    }

}
