package com.hersac.backend.modules.users.usuarios.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.hersac.backend.globals.exceptions.ItemNotFoundException;
import com.hersac.backend.modules.users.usuarios.models.Usuarios;
import com.hersac.backend.modules.users.usuarios.models.repositories.UsuariosRepository;
import com.hersac.backend.modules.users.usuarios.services.UsuariosService;

@Service
public class UsuariosServiceImpl implements UsuariosService {

	private final UsuariosRepository usuarioRepo;

	public UsuariosServiceImpl(UsuariosRepository usuarioRepo) {
		this.usuarioRepo = usuarioRepo;
	}

	@Override
	public Optional<List<Usuarios>> getUsuarios() {
		return Optional.of(usuarioRepo.findAll());
	}

	@Override
	public Optional<Usuarios> getUsuarioById(Long id) {
		Optional<Usuarios> usuario = usuarioRepo.findById(id);
		if (!usuario.isPresent())
			throw new ItemNotFoundException("Usuario no encontrado");
		return usuario;
	}

	@Override
	public Optional<String> addUsuario(Usuarios usuario) {
		usuarioRepo.save(usuario);
		return Optional.of("Usuario creado correctamente");
	}

	@Override
	public Optional<String> updateUsuario(Long id, Usuarios usuario) {
		Optional<Usuarios> usuarioAnterior = usuarioRepo.findById(id);
		if (!usuarioAnterior.isPresent())
			throw new ItemNotFoundException("Usuario no encontrado");
		usuarioAnterior.get().setEmail(usuario.getEmail());
		usuarioAnterior.get().setPassword(usuario.getPassword());
		usuarioAnterior.get().setPrimerNombre(usuario.getPrimerNombre());
		usuarioAnterior.get().setSegundoNombre(usuario.getSegundoNombre());
		usuarioAnterior.get().setPrimerApellido(usuario.getPrimerApellido());
		usuarioAnterior.get().setSegundoApellido(usuario.getSegundoApellido());
		usuarioAnterior.get().setIdentificacion(usuario.getIdentificacion());
		usuarioAnterior.get().setCumpleaños(usuario.getCumpleaños());
		usuarioAnterior.get().setDireccion(usuario.getDireccion());
		usuarioAnterior.get().setRol(usuario.getRol());

		usuarioRepo.save(usuarioAnterior.get());
		return Optional.of("Usuario actualizado correctamente");
	}

	@Override
	public Optional<String> deleteUsuarioById(Long id) {
		Optional<Usuarios> usuario = usuarioRepo.findById(id);
		if (!usuario.isPresent())
			throw new ItemNotFoundException("Usuario no encontrado");
		usuarioRepo.deleteById(id);
		return Optional.of("Usuario eliminado correctamente");
	}

}
