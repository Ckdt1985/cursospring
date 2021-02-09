package com.example.demo;

import org.springframework.stereotype.Controller;
import javax.validation.Valid;
import org.springframework.validation.BindingResult;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class ViewController {

	@Autowired
    private UserRepository repository;

    @GetMapping("/index")
	public String muestraIndice(Model model) {
		return "index";
	}

	@GetMapping("/adduser")
	public String muestraFormulario(Model model) {
		model.addAttribute("newUser", new User());
		return "form.html";
	}

	@PostMapping("/resultado")
	public String muestraResultados(@Valid @ModelAttribute User nuevoUsuario, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			return "error.html";
		}else {
			repository.save(nuevoUsuario);
			model.addAttribute("usuarios", repository.findAll());
			return "result.html";
		}
	}

    @GetMapping("/resultado")
	public String muestraResultadosConGet(Model model) {
		model.addAttribute("usuarios", repository.findAll());
		return "result.html";
	}

}
