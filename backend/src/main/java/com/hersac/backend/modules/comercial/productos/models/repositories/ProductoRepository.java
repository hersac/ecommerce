package com.hersac.backend.modules.comercial.productos.models.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hersac.backend.modules.comercial.productos.models.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {

}
