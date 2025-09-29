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
	public Optional<List<Rol>> getRoles() {
		return rolesServ.getRoles();
	}

	@GetMapping("/{id}")
	public Optional<Rol> getRoleById(@PathVariable Long id) {
		return rolesServ.getRolById(id);
	}

	@PostMapping
	public Optional<String> addRoles(@RequestBody Rol newRole) {
		return rolesServ.addRol(newRole);
	}

	@PutMapping("/{id}")
	public Optional<String> updateRole(@PathVariable Long id, @RequestBody Rol newData) {
		return rolesServ.updateRol(id, newData);
	}

	@DeleteMapping("/{id}")
	public Optional<String> deleteRole(@PathVariable Long id) {
		return rolesServ.deleteRolById(id);
	}

}
