package com.tuempresa.facturacion.validadores;

import com.tuempresa.facturacion.modelo.*;
import org.openxava.util.*;
import org.openxava.validators.*;
import lombok.*;

@Getter @Setter
public class ValidadorEntregadoParaEstarEnFactura implements IValidator {

    int anyo;            // Estos valores se copian desde el Pedido
    int numero;          // antes de validar
    boolean entregado;
    Factura factura;

    public void validate(Messages errores) throws Exception {
        if (factura == null) return;          // Sin factura: no hay nada que validar
        if (!entregado) {
            errores.add("pedido_debe_estar_entregado", anyo, numero);  // Falla la validación
        }
    }

}