package com.hersac.backend.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hersac.backend.models.Usuarios;
import com.hersac.backend.services.UsuariosService;

@RestController
@RequestMapping("/api/usuarios")
public class UsuariosController {

	private final UsuariosService usuariosServ;

	public UsuariosController(UsuariosService usuariosServ) {
		this.usuariosServ = usuariosServ;
	}

	@GetMapping
	public Optional<List<Usuarios>> getUsuarios() {
		return usuariosServ.getUsuarios();
	}

	@GetMapping("/{id}")
	public Optional<Usuarios> getUsuarioById(@PathVariable Long id) {
		return usuariosServ.getUsuarioById(id);
	}

	@PostMapping
	public Optional<String> addUsuarios(@RequestBody Usuarios newUser) {
		return usuariosServ.addUsuario(newUser);
	}

	@PutMapping("/{id}")
	public Optional<String> updateUsuario(@PathVariable Long id, @RequestBody Usuarios newData) {
		return usuariosServ.updateUsuario(id, newData);
	}

	@DeleteMapping("/{id}")
	public Optional<String> deleteUsuario(@PathVariable Long id) {
		return usuariosServ.deleteUsuarioById(id);
	}

}
