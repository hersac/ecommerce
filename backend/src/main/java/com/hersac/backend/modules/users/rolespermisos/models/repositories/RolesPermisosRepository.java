package com.hersac.backend.modules.users.rolespermisos.models.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hersac.backend.modules.users.rolespermisos.models.RolPermiso;
import com.hersac.backend.modules.users.rolespermisos.models.RolPermisoId;

@Repository
public interface RolesPermisosRepository extends JpaRepository<RolPermiso, RolPermisoId> {

}
