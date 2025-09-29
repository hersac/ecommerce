package com.hersac.backend.modules.users.roles.services;

import java.util.List;
import java.util.Optional;

import com.hersac.backend.modules.users.roles.models.Rol;

public interface RolesService {

	public Optional<List<Rol>> buscarTodos();

	public Optional<Rol> buscarPorId(Long id);

	public Optional<String> crear(Rol nuevoRol);

	public Optional<String> actualizar(Long id, Rol nuevaData);

	public Optional<String> eliminar(Long id);

}
