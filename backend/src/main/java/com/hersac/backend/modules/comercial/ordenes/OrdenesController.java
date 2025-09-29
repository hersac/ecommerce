package com.hersac.backend.modules.comercial.ordenes;

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

import com.hersac.backend.modules.comercial.ordenes.models.Orden;
import com.hersac.backend.modules.comercial.ordenes.services.OrdenesService;

@RestController
@RequestMapping("/api/ordenes")
public class OrdenesController {

	private final OrdenesService servicioOrdenes;

	public OrdenesController(OrdenesService servicioOrdenes) {
		this.servicioOrdenes = servicioOrdenes;
	}

	@GetMapping
	public Optional<List<Orden>> buscarTodos() {
		return servicioOrdenes.buscarTodos();
	}

	@GetMapping("/{id}")
	public Optional<Orden> buscarPorId(@PathVariable Long id) {
		return servicioOrdenes.buscarPorId(id);
	}

	@PostMapping
	public Optional<String> crear(@RequestBody Orden nuevaOrden) {
		return servicioOrdenes.crear(nuevaOrden);
	}

	@PutMapping("/{id}")
	public Optional<String> actualizar(@PathVariable Long id, @RequestBody Orden nuevaData) {
		return servicioOrdenes.actualizar(id, nuevaData);
	}

	@DeleteMapping("/{id}")
	public Optional<String> eliminar(@PathVariable Long id) {
		return servicioOrdenes.eliminar(id);
	}

}
