package com.hersac.backend.modules.comercial.carritocompras.models.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hersac.backend.modules.comercial.carritocompras.models.CarritoCompras;

@Repository
public interface CarritoComprasRepository extends JpaRepository<CarritoCompras, Long> {

}
