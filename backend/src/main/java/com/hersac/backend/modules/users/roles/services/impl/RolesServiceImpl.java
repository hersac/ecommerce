package com.hersac.backend.modules.users.roles.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.hersac.backend.globals.exceptions.ItemNotFoundException;
import com.hersac.backend.modules.users.roles.models.Rol;
import com.hersac.backend.modules.users.roles.models.repositories.RolRepository;
import com.hersac.backend.modules.users.roles.services.RolesService;

@Service
public class RolesServiceImpl implements RolesService {

	private final RolRepository rolesRepo;

	public RolesServiceImpl(RolRepository rolesRepo) {
		this.rolesRepo = rolesRepo;
	}

	@Override
	public Optional<List<Rol>> buscarTodos() {
		return Optional.of(rolesRepo.findAll());
	}

	@Override
	public Optional<Rol> buscarPorId(Long id) {
		Optional<Rol> rol = rolesRepo.findById(id);
		if (!rol.isPresent())
			throw new ItemNotFoundException("Rol no encontrado");
		return rol;
	}

	@Override
	public Optional<String> crear(Rol nuevoRol) {
		rolesRepo.save(nuevoRol);
		return Optional.of("Rol creado correctamente");
	}

	@Override
	public Optional<String> actualizar(Long id, Rol nuevaData) {
		Optional<Rol> rolAnterior = rolesRepo.findById(id);
		if (!rolAnterior.isPresent())
			throw new ItemNotFoundException("Rol no encontrado");
		rolAnterior.get().setNombreRol(nuevaData.getNombreRol());

		rolesRepo.save(rolAnterior.get());
		return Optional.of("Rol actualizado correctamente");
	}

	@Override
	public Optional<String> eliminar(Long id) {
		Optional<Rol> usuario = rolesRepo.findById(id);
		if (!usuario.isPresent())
			throw new ItemNotFoundException("Rol no encontrado");
		rolesRepo.deleteById(id);
		return Optional.of("Rol eliminado correctamente");
	}

}
