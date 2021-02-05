package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import java.math.BigDecimal;
import org.springframework.ui.Model;

import java.util.List;
import java.util.Map;

@RestController
public class PaisController {

    @Autowired

    private PaisRepository repository;

    // Find
    @GetMapping("/api/v1/paises")
    List<Pais> findAll() {
        return repository.findAll();
    }

    // Save
    @PostMapping("/api/v1/paises")
    // return 201 instead of 200
    @ResponseStatus(HttpStatus.CREATED)
    Pais newPais(@RequestBody Pais newPais) {
        return repository.save(newPais);
    }

    // Find
    @GetMapping("/api/v1/paises/{id}")
    Pais findOne(@PathVariable Long id) {
        return repository.findById(id).orElseThrow(() -> new PaisNotFoundException(id));
    }

    // Save or update
    // @PutMapping("/api/v1/paises/{id}")
    // Pais saveOrUpdate(@RequestBody Pais newPais, @PathVariable Long id) {

    //     return repository.findById(id).map(x -> {
    //         x.setName(newPais.getName());
    //         x.setAuthor(newPais.getAuthor());
    //         x.setPrice(newPais.getPrice());
    //         return repository.save(x);
    //     }).orElseGet(() -> {
    //         newPais.setId(id);
    //         return repository.save(newPais);
    //     });
    // }

    // update author only
    @PatchMapping("/api/v1/paises/{id}")
    Pais patch(@RequestBody Map<String, String> update, @PathVariable Long id) {

        return repository.findById(id).map(x -> {

            String poblacion = update.get("poblacion");
            if(!StringUtils.isEmpty(poblacion)){
                x.setPoblacion(new Integer(poblacion));
                return repository.save(x);
            }
            else {
                throw new PaisUnSupportedFieldPatchException(update.keySet());
            }

        }).orElseGet(() -> {
            throw new PaisNotFoundException(id);
        });

    }

    @DeleteMapping("/api/v1/paises/{id}")
    void deletePais(@PathVariable Long id) {
        repository.deleteById(id);
    }

}

