package com.example.demo;


public class PaisNotFoundException extends RuntimeException {

    public PaisNotFoundException(Long id) {
        super("Pais id not found : " + id);
    }

}
