package com.utn.ejer01.entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
//Anotaciones
@Entity //para que sea manejada por el motor de persistencia
@Data //la utilizo para crear getters and setters
@NoArgsConstructor //me va a generar el constructor sin argumentos
@AllArgsConstructor //me genera los constructores sobrecargados
@Builder //me va a permitir armar los constructores como yo quiera puedo permutar los contructores con diferentes parametros

public class Persona implements Serializable {

    @Id //la proxima instruccion se comporta como id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String apellido;
    private int edad;
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)//para indicar la relación uno a uno con domicilio
    //CascadeType.ALL cascadea para todas las operaciones de base de datos
    @JoinColumn(name = "domicilio_id")//para ingresar la nueva columna de la clave foránea
    private Domicilio domicilio;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public Domicilio getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(Domicilio domicilio) {
        this.domicilio = domicilio;
    }

}
