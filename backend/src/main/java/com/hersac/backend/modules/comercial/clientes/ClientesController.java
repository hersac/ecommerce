package com.hersac.backend.modules.comercial.clientes;

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

import com.hersac.backend.modules.comercial.clientes.models.Cliente;
import com.hersac.backend.modules.comercial.clientes.services.ClientesService;

@RestController
@RequestMapping("/api/clientes")
public class ClientesController {

	private final ClientesService clientesService;

	public ClientesController(ClientesService clientesService) {
		this.clientesService = clientesService;
	}

	@GetMapping
	public Optional<List<Cliente>> buscarTodos() {
		return clientesService.buscarTodos();
	}

	@GetMapping("/{id}")
	public Optional<Cliente> buscarPorId(@PathVariable Long id) {
		return clientesService.buscarPorId(id);
	}

	@PostMapping
	public Optional<String> crear(@RequestBody Cliente nuevoCliente) {
		return clientesService.crear(nuevoCliente);
	}

	@PutMapping("/{id}")
	public Optional<String> actualizar(@PathVariable Long id, @RequestBody Cliente nuevaData) {
		return clientesService.actualizar(id, nuevaData);
	}

	@DeleteMapping("/{id}")
	public Optional<String> eliminar(@PathVariable Long id) {
		return clientesService.eliminar(id);
	}

}
