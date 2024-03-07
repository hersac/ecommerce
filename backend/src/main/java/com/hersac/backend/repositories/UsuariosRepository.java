package com.hersac.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hersac.backend.models.Usuarios;

@Repository
public interface UsuariosRepository extends JpaRepository<Usuarios, Long> {

}
