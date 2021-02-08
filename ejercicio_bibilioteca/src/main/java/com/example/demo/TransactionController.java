package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import java.math.BigDecimal;

import java.util.List;
import java.util.Map;

@RestController
public class TransactionController {

    @Autowired

    private TransactionRepository repository;

    // Find
    @GetMapping("/api/v1/transacciones")
    List<Transaction> findAll() {
        return repository.findAll();
    }

    // Save
    @PostMapping("/api/v1/transacciones")
    // return 201 instead of 200
    @ResponseStatus(HttpStatus.CREATED)
    Transaction newFondoLibro(@RequestBody Transaction newFondoLibro) {
        return repository.save(newFondoLibro);
    }

    // Find
    @GetMapping("/api/v1/transacciones/{id}")
    Transaction findOne(@PathVariable Long id) {
        return repository.findById(id).orElseThrow(() -> new TransactionNotFoundException(id));
    }

    // Save or update
    @PatchMapping("/api/v1/transacciones/{id}")
    Transaction patch(@RequestBody Map<String, String> update, @PathVariable Long id) {

        return repository.findById(id).map(x -> {

            String fecha = update.get("fechaDevolucion");
            if(!StringUtils.isEmpty(fecha)){
                x.setFechaDevolucion(new String(fecha));
                return repository.save(x);
            }
            else {
                throw new TransactionUnSupportedFieldPatchException(update.keySet());
            }

        }).orElseGet(() -> {
            throw new TransactionNotFoundException(id);
        });

    }


    @DeleteMapping("/api/v1/transacciones/{id}")
    void deleteUser(@PathVariable Long id) {
        repository.deleteById(id);
    }

}
