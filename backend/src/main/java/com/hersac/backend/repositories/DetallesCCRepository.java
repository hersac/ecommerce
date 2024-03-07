package com.hersac.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hersac.backend.models.DetallesCC;

@Repository
public interface DetallesCCRepository extends JpaRepository<DetallesCC, Long> {

}
