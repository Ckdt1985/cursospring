package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import java.math.BigDecimal;

import java.util.List;
import java.util.Map;

@RestController
public class UserController {

    @Autowired

    private UserRepository repository;

    // Find
    @GetMapping("/api/v1/users")
    List<User> findAll() {
        return repository.findAll();
    }

    // Save
    @PostMapping("/api/v1/users")
    // return 201 instead of 200
    @ResponseStatus(HttpStatus.CREATED)
    User newUser(@RequestBody User newUser) {
        return repository.save(newUser);
    }

    // Find
    @GetMapping("/api/v1/users/{id}")
    User findOne(@PathVariable Long id) {
        return repository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
    }

    // Save or update
    @PutMapping("/api/v1/users/{id}")
    User saveOrUpdate(@RequestBody User newUser, @PathVariable Long id) {

        return repository.findById(id).map(x -> {
            x.setFirstName(newUser.getFirstName());
            x.setLastName(newUser.getLastName());
            x.setCarnetNumber(newUser.getCarnetNumber());
            return repository.save(x);
        }).orElseGet(() -> {
            newUser.setId(id);
            return repository.save(newUser);
        });
    }


    @DeleteMapping("/api/v1/users/{id}")
    void deleteUser(@PathVariable Long id) {
        repository.deleteById(id);
    }

}
