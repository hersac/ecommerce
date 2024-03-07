package com.hersac.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hersac.backend.models.Clientes;

@Repository
public interface ClientesRepository extends JpaRepository<Clientes, Long> {

}
