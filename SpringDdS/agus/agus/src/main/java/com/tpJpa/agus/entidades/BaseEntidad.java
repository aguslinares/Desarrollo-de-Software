package com.tpJpa.agus.entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;



@Data
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass //para que no cree tabla en la base de datos pero sea una superclase
public class BaseEntidad implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;


}
