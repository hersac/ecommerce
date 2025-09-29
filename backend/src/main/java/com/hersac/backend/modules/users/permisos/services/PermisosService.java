package com.hersac.backend.modules.users.permisos.services;

import java.util.List;
import java.util.Optional;

import com.hersac.backend.modules.users.permisos.models.Permisos;

public interface PermisosService {

	List<Permisos> getPermisos();

	Optional<Permisos> getPermisoById(Long id);

	Optional<Permisos> getPermisoByNombre(String name);

	Permisos createPermiso(Permisos permiso);

	Optional<Permisos> updatePermiso(Long id, Permisos permiso);

	boolean deletePermiso(Long id);

}
