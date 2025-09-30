package com.hersac.backend.modules.users.permisos.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.hersac.backend.modules.users.permisos.models.Permiso;
import com.hersac.backend.modules.users.permisos.models.repositories.PermisoRepository;
import com.hersac.backend.modules.users.permisos.services.PermisosService;

@Service
public class PermisosServiceImpl implements PermisosService {

	private final PermisoRepository permisoRepo;

	public PermisosServiceImpl(PermisoRepository permisoRepo) {
		this.permisoRepo = permisoRepo;
	}

	@Override
	public List<Permiso> buscarTodos() {
		return permisoRepo.findAll();
	}

	@Override
	public Optional<Permiso> buscarPorId(Long id) {
		return permisoRepo.findById(id);
	}

	@Override
	public Optional<Permiso> crear(Permiso nuevoPermiso) {
		return Optional.of(permisoRepo.save(nuevoPermiso));
	}

	@Override
	public Optional<Permiso> actualizar(Long id, Permiso nuevaData) {
		return permisoRepo.findById(id).map(p -> {
			p.setNombre(nuevaData.getNombre());
			return permisoRepo.save(p);
		});
	}

	@Override
	public Optional<Boolean> eliminar(Long id) {
		return Optional.of(permisoRepo.findById(id).map(p -> {
			permisoRepo.delete(p);
			return true;
		}).orElse(false));
	}

	@Override
	public Optional<Permiso> buscarPorNombre(String name) {
		return permisoRepo.findByNombre(name);
	}

}
