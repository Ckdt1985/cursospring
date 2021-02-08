package com.example.demo;

import java.util.Set;

public class TransactionUnSupportedFieldPatchException extends RuntimeException {

    public TransactionUnSupportedFieldPatchException(Set<String> keys) {
        super("Field " + keys.toString() + " update is not allowed.");
    }

}
