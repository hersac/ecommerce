package com.hersac.backend.modules.comercial.detallescarritoscompras;

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

import com.hersac.backend.modules.comercial.detallescarritoscompras.models.DetalleCC;
import com.hersac.backend.modules.comercial.detallescarritoscompras.services.DetallesCCService;

@RestController
@RequestMapping("/api/detallesCC")
public class DetallesCCController {

	private final DetallesCCService detallesCCService;

	public DetallesCCController(DetallesCCService detallesCCService) {
		this.detallesCCService = detallesCCService;
	}

	@GetMapping
	public Optional<List<DetalleCC>> buscarTodos() {
		return detallesCCService.buscarTodos();
	}

	@GetMapping("/{id}")
	public Optional<DetalleCC> buscarPorId(@PathVariable Long id) {
		return detallesCCService.buscarPorId(id);
	}

	@PostMapping
	public Optional<String> crear(@RequestBody DetalleCC newDetallesOrdenes) {
		return detallesCCService.crear(newDetallesOrdenes);
	}

	@PutMapping("/{id}")
	public Optional<String> actualizar(@PathVariable Long id, @RequestBody DetalleCC newData) {
		return detallesCCService.actualizar(id, newData);
	}

	@DeleteMapping("/{id}")
	public Optional<String> eliminar(@PathVariable Long id) {
		return detallesCCService.eliminar(id);
	}

}
