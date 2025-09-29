package com.hersac.backend.modules.users.rolespermisos;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hersac.backend.modules.users.rolespermisos.models.RolPermiso;
import com.hersac.backend.modules.users.rolespermisos.models.RolPermisoId;
import com.hersac.backend.modules.users.rolespermisos.services.RolesPermisosService;

@RestController
@RequestMapping("/api/roles-permisos")
public class RolesPermisosController {

	private final RolesPermisosService rolesPermisosService;

	public RolesPermisosController(RolesPermisosService rolesPermisosService) {
		this.rolesPermisosService = rolesPermisosService;
	}

	@GetMapping
	public List<RolPermiso> getRolesPermisos() {
		return rolesPermisosService.getRolesPermisos();
	}

	@GetMapping("/rol/{rolId}/permiso/{permisoId}")
	public ResponseEntity<RolPermiso> getRolesPermisosById(@PathVariable Long rolId, @PathVariable Long permisoId) {
		RolPermisoId id = new RolPermisoId(rolId, permisoId);
		return rolesPermisosService.getRolesPermisosById(id)
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}

	@PostMapping
	public RolPermiso createRolesPermisos(@RequestBody RolPermiso rolPermiso) {
		return rolesPermisosService.createRolesPermisos(rolPermiso);
	}

	@DeleteMapping("/rol/{rolId}/permiso/{permisoId}")
	public ResponseEntity<Void> deleteRolesPermisos(@PathVariable Long rolId, @PathVariable Long permisoId) {
		RolPermisoId id = new RolPermisoId(rolId, permisoId);
		return rolesPermisosService.deleteRolesPermisos(id) ? ResponseEntity.noContent().build()
				: ResponseEntity.notFound().build();
	}

}
