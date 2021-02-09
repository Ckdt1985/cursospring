package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import java.math.BigDecimal;

import java.util.List;
import java.util.Map;

@RestController
public class BookController {

    @Autowired
    private BookRepository repository;

    // Find
    @GetMapping("/api/v1/books")
    List<Book> findAll() {
        return repository.findAll();
    }

    // Save
    @PostMapping("/api/v1/books")
    // return 201 instead of 200
    @ResponseStatus(HttpStatus.CREATED)
    Book newBook(@RequestBody Book newBook) {
        return repository.save(newBook);
    }

    // Find
    @GetMapping("/api/v1/books/{id}")
    Book findOne(@PathVariable Long id) {
        return repository.findById(id).orElseThrow(() -> new BookNotFoundException(id));
    }

    // Save or update
    @PutMapping("/api/v1/books/{id}")
    Book saveOrUpdate(@RequestBody Book newBook, @PathVariable Long id) {

        return repository.findById(id).map(x -> {
            x.setName(newBook.getName());
            x.setAuthor(newBook.getAuthor());
            x.setPrice(newBook.getPrice());
            return repository.save(x);
        }).orElseGet(() -> {
            newBook.setId(id);
            return repository.save(newBook);
        });
    }

    // update author only
    @PatchMapping("/api/v1/books/{id}")
    Book patch(@RequestBody Map<String, String> update, @PathVariable Long id) {

        return repository.findById(id).map(x -> {

            String author = update.get("author");
            String name = update.get("name");
            String price = update.get("price");
            if (!StringUtils.isEmpty(author)) {
                x.setAuthor(author);
                return repository.save(x);
            } else if(!StringUtils.isEmpty(name)){
                x.setName(name);
                return repository.save(x);
            } else if(!StringUtils.isEmpty(price)){
                x.setPrice(new BigDecimal(price));
                return repository.save(x);
            }
            else {
                throw new BookUnSupportedFieldPatchException(update.keySet());
            }

        }).orElseGet(() -> {
            throw new BookNotFoundException(id);
        });

    }

    @DeleteMapping("/api/v1/books/{id}")
    void deleteBook(@PathVariable Long id) {
        repository.deleteById(id);
    }

}
