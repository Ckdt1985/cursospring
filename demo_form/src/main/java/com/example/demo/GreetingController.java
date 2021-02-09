package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class GreetingController {

	@GetMapping("/adduser")
	public String greetingForm(Model model) {
		model.addAttribute("newUser", new Usuario());
		return "form";
	}

	@PostMapping("/resultado")
	public String greetingSubmit(@ModelAttribute Usuario nuevoUsuario, Model model) {
		model.addAttribute("usuario", nuevoUsuario);
		return "result";
	}

}
