package com.hersac.backend.services;

import java.util.List;
import java.util.Optional;

import com.hersac.backend.models.Roles;

public interface RolesService {
    public Optional<List<Roles>> getRoles();
    public Optional<Roles> getRolById(Long id);
    public Optional<String> addRol(Roles rol);
    public Optional<String> updateRol(Long id, Roles rol);
    public Optional<String> deleteRolById(Long id);
}
