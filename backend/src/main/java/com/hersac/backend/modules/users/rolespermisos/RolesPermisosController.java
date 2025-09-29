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
	public List<RolPermiso> buscarTodos() {
		return rolesPermisosService.buscarTodos();
	}

	@GetMapping("/rol/{rolId}/permiso/{permisoId}")
	public ResponseEntity<RolPermiso> buscarPorId(@PathVariable Long rolId, @PathVariable Long permisoId) {
		RolPermisoId id = new RolPermisoId(rolId, permisoId);
		return rolesPermisosService.buscarPorId(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
	}

	@PostMapping
	public RolPermiso crear(@RequestBody RolPermiso rolPermiso) {
		return rolesPermisosService.crear(rolPermiso);
	}

	@DeleteMapping("/rol/{rolId}/permiso/{permisoId}")
	public ResponseEntity<Void> eliminar(@PathVariable Long rolId, @PathVariable Long permisoId) {
		RolPermisoId id = new RolPermisoId(rolId, permisoId);
		return rolesPermisosService.eliminar(id) ? ResponseEntity.noContent().build()
				: ResponseEntity.notFound().build();
	}

}
