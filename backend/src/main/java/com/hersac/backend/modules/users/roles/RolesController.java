package com.hersac.backend.modules.users.roles;

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

import com.hersac.backend.modules.users.roles.models.Rol;
import com.hersac.backend.modules.users.roles.services.RolesService;

@RestController
@RequestMapping("/api/roles")
public class RolesController {

	private final RolesService rolesServ;

	public RolesController(RolesService rolesServ) {
		this.rolesServ = rolesServ;
	}

	@GetMapping
	public Optional<List<Rol>> buscarTodos() {
		return rolesServ.buscarTodos();
	}

	@GetMapping("/{id}")
	public Optional<Rol> buscarPorId(@PathVariable Long id) {
		return rolesServ.buscarPorId(id);
	}

	@PostMapping
	public Optional<String> crear(@RequestBody Rol nuevoRol) {
		return rolesServ.crear(nuevoRol);
	}

	@PutMapping("/{id}")
	public Optional<String> actualizar(@PathVariable Long id, @RequestBody Rol nuevaData) {
		return rolesServ.actualizar(id, nuevaData);
	}

	@DeleteMapping("/{id}")
	public Optional<String> eliminar(@PathVariable Long id) {
		return rolesServ.eliminar(id);
	}

}
