package com.hersac.backend.modules.users.rolespermisos.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.hersac.backend.modules.users.rolespermisos.models.RolPermiso;
import com.hersac.backend.modules.users.rolespermisos.models.RolPermisoId;
import com.hersac.backend.modules.users.rolespermisos.models.repositories.RolesPermisosRepository;
import com.hersac.backend.modules.users.rolespermisos.services.RolesPermisosService;

@Service
public class RolesPermisosServiceImpl implements RolesPermisosService {

	private final RolesPermisosRepository rolesPermisosRepo;

	public RolesPermisosServiceImpl(RolesPermisosRepository rolesPermisosRepo) {
		this.rolesPermisosRepo = rolesPermisosRepo;
	}

	@Override
	public List<RolPermiso> buscarTodos() {
		return rolesPermisosRepo.findAll();
	}

	@Override
	public Optional<RolPermiso> buscarPorId(RolPermisoId id) {
		return rolesPermisosRepo.findById(id);
	}

	@Override
	public RolPermiso crear(RolPermiso rolPermiso) {
		return rolesPermisosRepo.save(rolPermiso);
	}

	@Override
	public boolean eliminar(RolPermisoId id) {
		return rolesPermisosRepo.findById(id).map(rp -> {
			rolesPermisosRepo.delete(rp);
			return true;
		}).orElse(false);
	}

}
