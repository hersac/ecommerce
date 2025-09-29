package com.hersac.backend.modules.users.rolespermisos.services;

import java.util.List;
import java.util.Optional;

import com.hersac.backend.modules.users.rolespermisos.models.RolPermiso;
import com.hersac.backend.modules.users.rolespermisos.models.RolPermisoId;

public interface RolesPermisosService {

	List<RolPermiso> buscarTodos();

	Optional<RolPermiso> buscarPorId(RolPermisoId id);

	RolPermiso crear(RolPermiso rolPermiso);

	boolean eliminar(RolPermisoId id);

}
