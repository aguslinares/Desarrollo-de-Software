package com.tpJpa.agus.entidades;

import com.tpJpa.agus.enumeraciones.FormaPago;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.LocalDate;




@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Factura  extends BaseEntidad {

    private int numero;
    private LocalDate fecha;
    private double descuento;
    private FormaPago formaPago;
    private int total;

}
