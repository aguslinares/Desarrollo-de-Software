package com.tpJpa.agus.entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DetallePedido  extends BaseEntidad{

    private int cantidad;
    private double subtotal;

    //Relación con la clase Producto
    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinColumn(name = "producto-id")
    private Producto producto;


}
