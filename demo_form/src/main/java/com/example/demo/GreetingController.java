package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class GreetingController {

    @GetMapping("/index")
	public String muestraIndice(Model model) {
		return "index";
	}

	@GetMapping("/adduser")
	public String muestraFormulario(Model model) {
		model.addAttribute("newUser", new Usuario());
		return "form";
	}

	@PostMapping("/resultado")
	public String muestraResultados(@ModelAttribute Usuario nuevoUsuario, Model model) {
		model.addAttribute("usuario", nuevoUsuario);
		return "result";
	}

    @GetMapping("/resultado")
	public String muestraResultadosConGet(@ModelAttribute Usuario nuevoUsuario, Model model) {
		model.addAttribute("usuario", nuevoUsuario);
		return "result";
	}

}
