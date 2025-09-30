package com.hersac.backend.modules.users.usuarios.models.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hersac.backend.modules.users.usuarios.models.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	Optional<Usuario> findByEmail(String email);

}
