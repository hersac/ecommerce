package com.hersac.backend.modules.users.rolespermisos.services;

import java.util.List;
import java.util.Optional;

import com.hersac.backend.modules.users.rolespermisos.models.RolPermiso;
import com.hersac.backend.modules.users.rolespermisos.models.RolPermisoId;

public interface RolesPermisosService {

	List<RolPermiso> getRolesPermisos();

	Optional<RolPermiso> getRolesPermisosById(RolPermisoId id);

	RolPermiso createRolesPermisos(RolPermiso rolPermiso);

	boolean deleteRolesPermisos(RolPermisoId id);

}
