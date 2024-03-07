package com.hersac.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hersac.backend.models.Roles;

@Repository
public interface RolesRepository extends JpaRepository<Roles, Long> {

}
