package com.hersac.backend.modules.users.permisos.services;

import java.util.List;
import java.util.Optional;

import com.hersac.backend.modules.users.permisos.models.Permiso;

public interface PermisosService {

	List<Permiso> buscarTodos();

	Optional<Permiso> buscarPorId(Long id);

	Optional<Permiso> crear(Permiso nuevoPermiso);

	Optional<Permiso> actualizar(Long id, Permiso nuevaData);

	Optional<Boolean> eliminar(Long id);

	Optional<Permiso> buscarPorNombre(String name);

}
