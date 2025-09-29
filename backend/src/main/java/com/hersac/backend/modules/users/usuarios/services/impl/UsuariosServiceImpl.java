package com.hersac.backend.modules.users.usuarios.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.hersac.backend.globals.exceptions.ItemNotFoundException;
import com.hersac.backend.modules.users.usuarios.models.Usuario;
import com.hersac.backend.modules.users.usuarios.models.repositories.UsuarioRepository;
import com.hersac.backend.modules.users.usuarios.services.UsuariosService;

@Service
public class UsuariosServiceImpl implements UsuariosService {

	private final UsuarioRepository usuarioRepo;

	public UsuariosServiceImpl(UsuarioRepository usuarioRepo) {
		this.usuarioRepo = usuarioRepo;
	}

	@Override
	public Optional<List<Usuario>> buscarTodos() {
		return Optional.of(usuarioRepo.findAll());
	}

	@Override
	public Optional<Usuario> buscarPorId(Long id) {
		Optional<Usuario> usuario = usuarioRepo.findById(id);
		if (!usuario.isPresent())
			throw new ItemNotFoundException("Usuario no encontrado");
		return usuario;
	}

	@Override
	public Optional<String> crear(Usuario usuario) {
		usuarioRepo.save(usuario);
		return Optional.of("Usuario creado correctamente");
	}

	@Override
	public Optional<String> actualizar(Long id, Usuario usuario) {
		Optional<Usuario> usuarioAnterior = usuarioRepo.findById(id);
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
	public Optional<String> eliminar(Long id) {
		Optional<Usuario> usuario = usuarioRepo.findById(id);
		if (!usuario.isPresent())
			throw new ItemNotFoundException("Usuario no encontrado");
		usuarioRepo.deleteById(id);
		return Optional.of("Usuario eliminado correctamente");
	}

}
