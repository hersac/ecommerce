package com.hersac.backend.modules.users.usuarios.services;

import java.util.List;
import java.util.Optional;

import com.hersac.backend.modules.users.usuarios.models.Usuario;

public interface UsuariosService {

	public Optional<List<Usuario>> buscarTodos();

	public Optional<Usuario> buscarPorId(Long id);

	public Optional<String> crear(Usuario nuevoUsuario);

	public Optional<String> actualizar(Long id, Usuario nuevaData);

	public Optional<String> eliminar(Long id);

}