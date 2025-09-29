package com.hersac.backend.modules.users.roles.models.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hersac.backend.modules.users.roles.models.Rol;

@Repository
public interface RolRepository extends JpaRepository<Rol, Long> {

}
