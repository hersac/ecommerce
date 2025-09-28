package com.hersac.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hersac.backend.models.DetallesOrdenes;

@Repository
public interface DetallesOrdenesRepository
        extends
            JpaRepository<DetallesOrdenes, Long> {

}
