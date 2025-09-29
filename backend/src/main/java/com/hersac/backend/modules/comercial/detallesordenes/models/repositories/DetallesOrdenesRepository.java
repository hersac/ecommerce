package com.hersac.backend.modules.comercial.detallesordenes.models.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hersac.backend.modules.comercial.detallesordenes.models.DetallesOrdenes;

@Repository
public interface DetallesOrdenesRepository extends JpaRepository<DetallesOrdenes, Long> {

}
