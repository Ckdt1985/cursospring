package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.Date;
import java.text.SimpleDateFormat;
@Controller
public class ViewController {

    @Autowired
    private PaisRepository repository;

    @GetMapping("/paises")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("paises", repository.findAll());

        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        String strDate = formatter.format(new Date());
        model.addAttribute("serverTime", strDate);
        model.addAttribute("role", "admin");

        return "paises";
    }
}
