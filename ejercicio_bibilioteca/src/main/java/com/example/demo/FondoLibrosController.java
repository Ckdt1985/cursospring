package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import java.math.BigDecimal;

import java.util.List;
import java.util.Map;

@RestController
public class FondoLibrosController {

    @Autowired

    private FondoLibroRepository repository;

    // Find
    @GetMapping("/api/v1/fondo")
    List<FondoLibro> findAll() {
        return repository.findAll();
    }

    // Save
    @PostMapping("/api/v1/fondo")
    // return 201 instead of 200
    @ResponseStatus(HttpStatus.CREATED)
    FondoLibro newFondoLibro(@RequestBody FondoLibro newFondoLibro) {
        return repository.save(newFondoLibro);
    }

    // Find
    @GetMapping("/api/v1/fondo/{id}")
    FondoLibro findOne(@PathVariable Long id) {
        return repository.findById(id).orElseThrow(() -> new FondoNotFoundException(id));
    }

    // Save or update
    @PutMapping("/api/v1/fondo/{id}")
    FondoLibro saveOrUpdate(@RequestBody FondoLibro nuevoLibro, @PathVariable Long id) {

        return repository.findById(id).map(x -> {
            x.setIdLibro(nuevoLibro.getIdLibro());
            x.setEstado(nuevoLibro.getEstado());
            return repository.save(x);
        }).orElseThrow(() ->  new FondoNotFoundException(id));
    }


    @DeleteMapping("/api/v1/fondo/{id}")
    void deleteUser(@PathVariable Long id) {
        repository.deleteById(id);
    }

}
