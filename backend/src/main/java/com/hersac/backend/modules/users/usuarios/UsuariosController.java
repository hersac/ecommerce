package com.hersac.backend.modules.users.usuarios;

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

import com.hersac.backend.modules.users.usuarios.models.Usuario;
import com.hersac.backend.modules.users.usuarios.services.UsuariosService;

@RestController
@RequestMapping("/api/usuarios")
public class UsuariosController {

	private final UsuariosService usuariosServ;

	public UsuariosController(UsuariosService usuariosServ) {
		this.usuariosServ = usuariosServ;
	}

	@GetMapping
	public Optional<List<Usuario>> buscarTodos() {
		return usuariosServ.buscarTodos();
	}

	@GetMapping("/{id}")
	public Optional<Usuario> buscarPorId(@PathVariable Long id) {
		return usuariosServ.buscarPorId(id);
	}

	@PostMapping
	public Optional<String> crear(@RequestBody Usuario nuevoUsuario) {
		return usuariosServ.crear(nuevoUsuario);
	}

	@PutMapping("/{id}")
	public Optional<String> actualizar(@PathVariable Long id, @RequestBody Usuario nuevaData) {
		return usuariosServ.actualizar(id, nuevaData);
	}

	@DeleteMapping("/{id}")
	public Optional<String> eliminar(@PathVariable Long id) {
		return usuariosServ.eliminar(id);
	}

}
