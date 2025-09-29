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

import com.hersac.backend.models.Clientes;
import com.hersac.backend.services.ClientesService;

@RestController
@RequestMapping("/api/clientes")
public class ClientesController {

	@Autowired
	private ClientesService clientesService;

	@GetMapping
	public Optional<List<Clientes>> getClientes() {
		return clientesService.getClientes();
	}

	@GetMapping("/{id}")
	public Optional<Clientes> getClientesById(@PathVariable Long id) {
		return clientesService.getClientesById(id);
	}

	@PostMapping
	public Optional<String> addClientes(@RequestBody Clientes newClientes) {
		return clientesService.addClientes(newClientes);
	}

	@PutMapping("/{id}")
	public Optional<String> updateClientes(@PathVariable Long id, @RequestBody Clientes newData) {
		return clientesService.updateClientes(id, newData);
	}

	@DeleteMapping("/{id}")
	public Optional<String> deleteClientes(@PathVariable Long id) {
		return clientesService.deleteClientesById(id);
	}

}
