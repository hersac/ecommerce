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

import com.hersac.backend.modules.users.permisos.models.Permiso;
import com.hersac.backend.modules.users.permisos.services.PermisosService;

@RestController
@RequestMapping("/api/permisos")
public class PermisosController {

	private final PermisosService permisosService;

	public PermisosController(PermisosService permisosService) {
		this.permisosService = permisosService;
	}

	@GetMapping
	public List<Permiso> buscarTodos() {
		return permisosService.buscarTodos();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Permiso> buscarPorId(@PathVariable Long id) {
		return permisosService.buscarPorId(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
	}

	@PostMapping
	public Permiso crear(@RequestBody Permiso nuevoPermiso) {
		return permisosService.crear(nuevoPermiso).get();
	}

	@PutMapping("/{id}")
	public ResponseEntity<Permiso> actualizar(@PathVariable Long id, @RequestBody Permiso nuevaData) {
		return permisosService.actualizar(id, nuevaData)
			.map(ResponseEntity::ok)
			.orElse(ResponseEntity.notFound().build());
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminar(@PathVariable Long id) {
		return permisosService.eliminar(id).get() ? ResponseEntity.noContent().build()
				: ResponseEntity.notFound().build();
	}

	@GetMapping("/nombre/{nombre}")
	public ResponseEntity<Permiso> buscarPorNombre(@PathVariable String nombre) {
		return ResponseEntity.ok().body(permisosService.buscarPorNombre(nombre).get());
	}

}
