package com.hersac.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hersac.backend.models.CarritoCompras;

@Repository
public interface CarritoComprasRepository extends JpaRepository<CarritoCompras, Long> {

}
