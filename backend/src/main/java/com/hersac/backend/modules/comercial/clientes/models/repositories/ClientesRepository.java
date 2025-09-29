package com.hersac.backend.modules.comercial.clientes.models.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hersac.backend.modules.comercial.clientes.models.Clientes;

@Repository
public interface ClientesRepository extends JpaRepository<Clientes, Long> {

}
