package com.hersac.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hersac.backend.models.Ordenes;

@Repository
public interface OrdenesRepository extends JpaRepository<Ordenes, Long> {

}
