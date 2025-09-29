package com.hersac.backend.modules.users.roles.models.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hersac.backend.modules.users.roles.models.Roles;

@Repository
public interface RolesRepository extends JpaRepository<Roles, Long> {

}
