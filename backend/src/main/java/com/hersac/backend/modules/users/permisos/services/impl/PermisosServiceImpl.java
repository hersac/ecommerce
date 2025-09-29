package com.hersac.backend.modules.users.permisos.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.hersac.backend.modules.users.permisos.models.Permisos;
import com.hersac.backend.modules.users.permisos.models.repositories.PermisosRepository;
import com.hersac.backend.modules.users.permisos.services.PermisosService;

@Service
public class PermisosServiceImpl implements PermisosService {

	private final PermisosRepository permisoRepo;

	public PermisosServiceImpl(PermisosRepository permisoRepo) {
		this.permisoRepo = permisoRepo;
	}

	@Override
	public List<Permisos> getPermisos() {
		return permisoRepo.findAll();
	}

	@Override
	public Optional<Permisos> getPermisoById(Long id) {
		return permisoRepo.findById(id);
	}

	@Override
	public Optional<Permisos> getPermisoByNombre(String name) {
		return permisoRepo.findByNombre(name);
	}

	@Override
	public Permisos createPermiso(Permisos permiso) {
		return permisoRepo.save(permiso);
	}

	@Override
	public Optional<Permisos> updatePermiso(Long id, Permisos permiso) {
		return permisoRepo.findById(id).map(p -> {
			p.setNombre(permiso.getNombre());
			return permisoRepo.save(p);
		});
	}

	@Override
	public boolean deletePermiso(Long id) {
		return permisoRepo.findById(id).map(p -> {
			permisoRepo.delete(p);
			return true;
		}).orElse(false);
	}

}
