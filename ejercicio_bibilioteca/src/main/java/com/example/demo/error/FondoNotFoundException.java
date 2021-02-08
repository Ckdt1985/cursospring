package com.example.demo;


public class FondoNotFoundException extends RuntimeException {

    public FondoNotFoundException(Long id) {
        super("Fondo id not found : " + id);
    }

}
