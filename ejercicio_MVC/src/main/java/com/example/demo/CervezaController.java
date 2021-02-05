package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.text.SimpleDateFormat;
@Controller
public class CervezaController {

    // @Autowired
    // private PaisRepository paisRepository;

    @Autowired
    private CervezaRepository cervezaRepository;

    // @GetMapping("/paises")
    // public String paises(Model model) {
    //     model.addAttribute("paises", paisRepository.findAll());

    //     SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
    //     String strDate = formatter.format(new Date());
    //     model.addAttribute("serverTime", strDate);
    //     model.addAttribute("role", "admin");

    //     return "paises";
    // }

    @GetMapping("/cervezas")
    public String greeting(Model model) {
        model.addAttribute("misCervezas", cervezaRepository.findAll());
        return "cervezas";
    }
}
