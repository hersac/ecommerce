package com.hersac.backend.modules.comercial.ordenes.models.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hersac.backend.modules.comercial.ordenes.models.Ordenes;

@Repository
public interface OrdenesRepository extends JpaRepository<Ordenes, Long> {

}
