package com.tpJpa.agus.repositorios;

import com.tpJpa.agus.entidades.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepositroy extends JpaRepository<Cliente, Long> {



}
