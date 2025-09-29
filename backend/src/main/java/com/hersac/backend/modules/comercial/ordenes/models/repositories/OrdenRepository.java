package com.hersac.backend.modules.comercial.ordenes.models.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hersac.backend.modules.comercial.ordenes.models.Orden;

@Repository
public interface OrdenRepository extends JpaRepository<Orden, Long> {

}
