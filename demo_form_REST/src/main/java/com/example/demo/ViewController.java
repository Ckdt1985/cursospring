package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ViewController {

    @Autowired
    private BookRepository repository;

	@GetMapping("/nuevolibro")
	public String greetingForm(Model model) {
		model.addAttribute("libro", new Book());
		return "formlibro";
	}

	@PostMapping("/newlibro")
	public String greetingSubmit(@ModelAttribute Book book, Model model) {
        repository.save(book);
		model.addAttribute("libros", repository.findAll());
		return "result";
	}

}
