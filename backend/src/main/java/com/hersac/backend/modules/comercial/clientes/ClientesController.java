package com.hersac.backend.modules.comercial.clientes;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hersac.backend.common.validation.OnCreate;
import com.hersac.backend.common.validation.OnUpdate;
import com.hersac.backend.modules.comercial.clientes.dto.ActualizarClienteDTO;
import com.hersac.backend.modules.comercial.clientes.dto.CrearClienteDTO;
import com.hersac.backend.modules.comercial.clientes.dto.ResponseClienteDTO;
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
	public ResponseEntity<List<ResponseClienteDTO>> buscarTodos() {
		List<ResponseClienteDTO> clientes = clientesService.buscarTodos();
		return ResponseEntity.ok(clientes);
	}

	@GetMapping("/{id}")
	public ResponseEntity<ResponseClienteDTO> buscarPorId(@PathVariable Long id) {
		ResponseClienteDTO cliente = clientesService.buscarPorId(id);
		return ResponseEntity.ok(cliente);
	}

	@PostMapping
	public ResponseEntity<ResponseClienteDTO> crear(
			@Validated(OnCreate.class) @RequestBody CrearClienteDTO nuevoCliente) {
		ResponseClienteDTO cliente = clientesService.crear(nuevoCliente);
		return ResponseEntity.status(HttpStatus.CREATED).body(cliente);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Void> actualizar(
			@PathVariable Long id,
			@Validated(OnUpdate.class) @RequestBody ActualizarClienteDTO nuevaData) {
		clientesService.actualizar(id, nuevaData);
		return ResponseEntity.noContent().build();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminar(@PathVariable Long id) {
		clientesService.eliminar(id);
		return ResponseEntity.noContent().build();
	}

}
