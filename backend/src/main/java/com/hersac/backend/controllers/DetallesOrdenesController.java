package com.hersac.backend.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hersac.backend.models.DetallesOrdenes;
import com.hersac.backend.services.DetallesOrdenesService;

@RestController
@RequestMapping("/api/detallesOrdenes")
public class DetallesOrdenesController {

	@Autowired
	private DetallesOrdenesService detallesOrdenesServ;

	@GetMapping
	public Optional<List<DetallesOrdenes>> getDetallesOrdenes() {
		return detallesOrdenesServ.getDetallesOrdenes();
	}

	@GetMapping("/{id}")
	public Optional<DetallesOrdenes> getDetallesOrdenesById(@PathVariable Long id) {
		return detallesOrdenesServ.getDetallesOrdenesById(id);
	}

	@PostMapping
	public Optional<String> addDetallesOrdenes(@RequestBody DetallesOrdenes newDetallesOrdenes) {
		return detallesOrdenesServ.addDetallesOrdenes(newDetallesOrdenes);
	}

	@PutMapping("/{id}")
	public Optional<String> updateDetallesOrdenes(@PathVariable Long id, @RequestBody DetallesOrdenes newData) {
		return detallesOrdenesServ.updateDetallesOrdenes(id, newData);
	}

	@DeleteMapping("/{id}")
	public Optional<String> deleteDetallesOrdenes(@PathVariable Long id) {
		return detallesOrdenesServ.deleteDetallesOrdenesById(id);
	}

}
