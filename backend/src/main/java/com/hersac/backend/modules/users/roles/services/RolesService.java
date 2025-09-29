package com.hersac.backend.modules.users.roles.services;

import java.util.List;
import java.util.Optional;

import com.hersac.backend.modules.users.roles.models.Rol;

public interface RolesService {

	public Optional<List<Rol>> getRoles();

	public Optional<Rol> getRolById(Long id);

	public Optional<String> addRol(Rol rol);

	public Optional<String> updateRol(Long id, Rol rol);

	public Optional<String> deleteRolById(Long id);

}
