package com.tpJpa.agus.entidades;

import com.tpJpa.agus.enumeraciones.EstadoPedido;
import com.tpJpa.agus.enumeraciones.TipoEnvio;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Pedido  extends BaseEntidad {

    private EstadoPedido estado;
    private LocalDate fecha;
    private TipoEnvio tipoEnvio;
    private double total;

    //Relación con la clase DetallePedido
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "pedido-id")
    @Builder.Default
    private List<DetallePedido> detallePedidos= new ArrayList<>();

    //Relación con la clase Factura
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "factura-id")
    private Factura factura;

    //Creo un método para añadir agregar los detalles de pedidos a la lista
    public void agregarDetPedidos (DetallePedido detPedido) {

        detallePedidos.add(detPedido);
    }




}
