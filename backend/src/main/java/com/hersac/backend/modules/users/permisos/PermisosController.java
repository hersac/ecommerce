package com.hersac.backend.modules.users.permisos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hersac.backend.modules.users.permisos.models.Permisos;
import com.hersac.backend.modules.users.permisos.services.PermisosService;

@RestController
@RequestMapping("/api/permisos")
public class PermisosController {

	@Autowired
	private PermisosService service;

	@GetMapping
	public List<Permisos> getPermisos() {
		return service.getPermisos();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Permisos> getPermisoById(@PathVariable Long id) {
		return service.getPermisoById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
	}

	@PostMapping
	public Permisos createPermiso(@RequestBody Permisos permiso) {
		return service.createPermiso(permiso);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Permisos> updatePermiso(@PathVariable Long id, @RequestBody Permisos permiso) {
		return service.updatePermiso(id, permiso).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletePermiso(@PathVariable Long id) {
		return service.deletePermiso(id) ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
	}

}
