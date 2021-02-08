package com.example.demo;


public class TransactionNotFoundException extends RuntimeException {

    public TransactionNotFoundException(Long id) {
        super("Fondo id not found : " + id);
    }

}
