package com.hersac.backend.modules.users.permisos.models.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hersac.backend.modules.users.permisos.models.Permisos;

@Repository
public interface PermisosRepository extends JpaRepository<Permisos, Long> {

	Optional<Permisos> findByNombre(String nombre);

}
