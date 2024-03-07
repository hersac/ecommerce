package com.hersac.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hersac.backend.models.Productos;

@Repository
public interface ProductosRepository extends JpaRepository<Productos, Long> {

}
