package com.tpJpa.agus.entidades;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "cliente")//se llama igual que la clase
public class Cliente  extends BaseEntidad{

    private String nombre;
    private String apellido;
    private String telefono;
    private String email;

    //Relación con la clase Domicilio

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "cliente-id")
    @Builder.Default
    private List<Domicilio> domicilios = new ArrayList<>();

    //Relación con la clase Pedido

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "cliente-id")
    @Builder.Default
    private List<Pedido> pedidos = new ArrayList<>();

    //Creo el método para poder agregar domicilios del cliente a la lista
    public void agregarDomicilio (Domicilio domicilio) {

        domicilios.add(domicilio);
    }

    //Creo el método para poder mostrar que domicilios le corresponden a un determinado cliente
    public void mostrarDomicilios () {
        System.out.println("Domicilios de "+nombre+""+apellido+":");
        for (Domicilio domicilio : domicilios){
            System.out.println("Calle: "+domicilio.getCalle()+", Número: "+domicilio.getNumero());
        }
    }

    //Creo el método para poder agregar pedidos que realiza un cliente a la lista
    public void agregarPedidos (Pedido pedido) {
         pedidos.add(pedido);
    }

    //Creo el método para poder mostrar los peiddos que realizó un cliente
    public void mostrarPedidos () {
        System.out.println("Pedidos de "+nombre+""+apellido+":");
        for(Pedido pedido : pedidos) {

            System.out.println("Fecha: "+pedido.getFecha()+", Total: "+pedido.getTotal()+", Estado del pedido: "+pedido.getEstado()+", Factura: "+pedido.getFactura());
        int counter = 0;
        for(DetallePedido detalle : pedido.getDetallePedidos()) {
            counter += 1;
            System.out.println("Producto " + counter + ": " + detalle.getProducto().getDenominacion() + ", Cantidad: " + detalle.getCantidad() + ", Subtotal: " + detalle.getSubtotal());

        }
        }
    }

}
