package com.hersac.backend.services;

import java.util.List;
import java.util.Optional;

import com.hersac.backend.models.Usuarios;

public interface UsuariosService {

	public Optional<List<Usuarios>> getUsuarios();

	public Optional<Usuarios> getUsuarioById(Long id);

	public Optional<String> addUsuario(Usuarios usuario);

	public Optional<String> updateUsuario(Long id, Usuarios usuario);

	public Optional<String> deleteUsuarioById(Long id);

}