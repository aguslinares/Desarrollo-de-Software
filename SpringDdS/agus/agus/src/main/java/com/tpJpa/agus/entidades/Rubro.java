package com.tpJpa.agus.entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;
import java.util.ArrayList;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Rubro extends BaseEntidad{

    private String denominacion;

    //Realción con la clase Producto
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "rubro-id")
    @Builder.Default
    private List<Producto> productos = new ArrayList<>();

    //Creo un método para agregar productos pertenecientes a un tipo de rubro a la lista
    public void agregarProductos (Producto producto) {

        productos.add(producto);
    }




}
