package com.example.demo;

import java.util.Set;

public class PaisUnSupportedFieldPatchException extends RuntimeException {

    public PaisUnSupportedFieldPatchException(Set<String> keys) {
        super("Field " + keys.toString() + " update is not allowed.");
    }

}
