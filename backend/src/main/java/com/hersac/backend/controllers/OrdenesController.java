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

import com.hersac.backend.models.Ordenes;
import com.hersac.backend.services.OrdenesService;

@RestController
@RequestMapping("/api/ordenes")
public class OrdenesController {

	private final OrdenesService servicioOrdenes;

	public OrdenesController(OrdenesService servicioOrdenes) {
		this.servicioOrdenes = servicioOrdenes;
	}

	@GetMapping
	public Optional<List<Ordenes>> getOrdenes() {
		return servicioOrdenes.getOrdenes();
	}

	@GetMapping("/{id}")
	public Optional<Ordenes> getOrdenById(@PathVariable Long id) {
		return servicioOrdenes.getOrdenById(id);
	}

	@PostMapping
	public Optional<String> addOrden(@RequestBody Ordenes newOrden) {
		return servicioOrdenes.addOrden(newOrden);
	}

	@PutMapping("/{id}")
	public Optional<String> updateOrden(@PathVariable Long id, @RequestBody Ordenes newData) {
		return servicioOrdenes.updateOrden(id, newData);
	}

	@DeleteMapping("/{id}")
	public Optional<String> deleteOrden(@PathVariable Long id) {
		return servicioOrdenes.deleteOrdenById(id);
	}

}
