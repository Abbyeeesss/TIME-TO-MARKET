package com.tuempresa.facturacion.validadores;

import javax.validation.*;
import com.tuempresa.facturacion.anotaciones.*;
import org.openxava.util.*;

public class ValidadorISBN implements ConstraintValidator<ISBN, Object> {

    private static final org.apache.commons.validator.routines.ISBNValidator
            validador = new org.apache.commons.validator.routines.ISBNValidator();  // De Commons Validator

    public void initialize(ISBN isbn) {
    }

    public boolean isValid(Object valor, ConstraintValidatorContext contexto) {
        if (Is.empty(valor)) return true;               // Vacío es válido (no es obligatorio)
        return validador.isValid(valor.toString());     // Revisa el dígito de control del ISBN
    }

}