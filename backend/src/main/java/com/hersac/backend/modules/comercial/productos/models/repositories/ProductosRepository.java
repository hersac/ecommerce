package com.hersac.backend.modules.comercial.productos.models.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hersac.backend.modules.comercial.productos.models.Productos;

@Repository
public interface ProductosRepository extends JpaRepository<Productos, Long> {

}
