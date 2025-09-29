package com.hersac.backend.modules.comercial.detallescarritoscompras.models.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hersac.backend.modules.comercial.detallescarritoscompras.models.DetallesCC;

@Repository
public interface DetallesCCRepository extends JpaRepository<DetallesCC, Long> {

}
