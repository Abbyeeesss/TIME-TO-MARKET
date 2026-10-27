package com.tuempresa.facturacion.modelo;

import javax.persistence.*;
import org.openxava.annotations.*;
import com.tuempresa.facturacion.validadores.*;
import lombok.*;

@Entity
@Getter @Setter
@View(extendsView = "super.DEFAULT",
        members = "entregado;" +                 // Nuevo campo 'entregado'
                "factura { factura }"
)
@View(name = "SinClienteNiFactura",
        members = "anyo, numero, fecha;" +
                "detalles;" +
                "observaciones"
)
@EntityValidator(
        value = ValidadorEntregadoParaEstarEnFactura.class,  // Clase con la lógica
        properties = {
                @PropertyValue(name = "anyo"),         // Valores que se pasan
                @PropertyValue(name = "numero"),       // del Pedido al validador
                @PropertyValue(name = "factura"),
                @PropertyValue(name = "entregado")
        }
)
public class Pedido extends DocumentoComercial {

    @Column(nullable = false)
    @org.hibernate.annotations.ColumnDefault("false")
    boolean entregado;                          // ¿El pedido ya fue entregado?

    @ManyToOne
    @ReferenceView("SinClienteNiPedidos")
    Factura factura;

}