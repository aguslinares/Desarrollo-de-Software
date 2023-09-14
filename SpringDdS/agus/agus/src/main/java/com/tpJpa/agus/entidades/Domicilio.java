package com.tpJpa.agus.entidades;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;



@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Domicilio  extends BaseEntidad {

    private String calle;
    private String numero;
    private String localidad;
}
