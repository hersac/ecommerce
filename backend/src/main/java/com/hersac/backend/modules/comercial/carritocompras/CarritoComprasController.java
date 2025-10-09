package com.hersac.backend.modules.comercial.carritocompras;

import java.util.List;

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
import com.hersac.backend.modules.comercial.carritocompras.dto.ActualizarCarritoComprasDTO;
import com.hersac.backend.modules.comercial.carritocompras.dto.CrearCarritoComprasDTO;
import com.hersac.backend.modules.comercial.carritocompras.dto.ResponseCarritoComprasDTO;
import com.hersac.backend.modules.comercial.carritocompras.services.CarritosComprasService;

@RestController
@RequestMapping("/api/carritos-compras")
public class CarritoComprasController {

	private final CarritosComprasService carritoComprasService;

	public CarritoComprasController(CarritosComprasService carritoComprasService) {
		this.carritoComprasService = carritoComprasService;
	}

	@GetMapping
	public ResponseEntity<List<ResponseCarritoComprasDTO>> buscarTodos() {
		List<ResponseCarritoComprasDTO> carritoCompras = carritoComprasService.buscarTodos();

		return ResponseEntity.ok().body(carritoCompras);
	}

	@GetMapping("/{id}")
	public ResponseEntity<ResponseCarritoComprasDTO> buscarPorId(@PathVariable Long id) {
		ResponseCarritoComprasDTO carritoCompras = carritoComprasService.buscarPorId(id);
		return ResponseEntity.ok().body(carritoCompras);

	}

	@PostMapping
	public ResponseEntity<ResponseCarritoComprasDTO> crear(
			@Validated(OnCreate.class) @RequestBody CrearCarritoComprasDTO nuevoCarritoCompras) {
		ResponseCarritoComprasDTO carritoCompras = carritoComprasService.crear(nuevoCarritoCompras);
		return ResponseEntity.status(HttpStatus.CREATED).body(carritoCompras);

	}

	@PutMapping("/{id}")
	public ResponseEntity<Void> actualizar(@PathVariable Long id,
			@Validated(OnUpdate.class) @RequestBody ActualizarCarritoComprasDTO nuevaData) {
		carritoComprasService.actualizar(id, nuevaData);
		return ResponseEntity.noContent().build();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminar(@PathVariable Long id) {
		carritoComprasService.eliminar(id);
		return ResponseEntity.noContent().build();
	}

}
