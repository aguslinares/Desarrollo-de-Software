package com.utn.ejer01.repositorios;

import com.utn.ejer01.entidades.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;




@Repository //para q se comporte como un repositorio de Spring
public interface PersonaRepository extends JpaRepository<Persona, Long> {

}
