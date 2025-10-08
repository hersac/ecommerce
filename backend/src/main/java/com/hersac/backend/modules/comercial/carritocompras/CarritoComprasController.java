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
import com.hersac.backend.modules.comercial.carritocompras.dto.ActualizarCarritoCompras;
import com.hersac.backend.modules.comercial.carritocompras.dto.CrearCarritoCompras;
import com.hersac.backend.modules.comercial.carritocompras.dto.ResponseCarritoCompras;
import com.hersac.backend.modules.comercial.carritocompras.services.CarritosComprasService;

@RestController
@RequestMapping("/api/carritos-compras")
public class CarritoComprasController {

	private final CarritosComprasService carritoComprasService;

	public CarritoComprasController(CarritosComprasService carritoComprasService) {
		this.carritoComprasService = carritoComprasService;
	}

	@GetMapping
	public ResponseEntity<List<ResponseCarritoCompras>> buscarTodos() {
		List<ResponseCarritoCompras> carritoCompras = carritoComprasService.buscarTodos();

		return ResponseEntity.ok().body(carritoCompras);
	}

	@GetMapping("/{id}")
	public ResponseEntity<ResponseCarritoCompras> buscarPorId(@PathVariable Long id) {
		ResponseCarritoCompras carritoCompras = carritoComprasService.buscarPorId(id);
		return ResponseEntity.ok().body(carritoCompras);

	}

	@PostMapping
	public ResponseEntity<ResponseCarritoCompras> crear(
			@Validated(OnCreate.class) @RequestBody CrearCarritoCompras newCarritoCompras) {
		ResponseCarritoCompras carritoCompras = carritoComprasService.crear(newCarritoCompras);
		return ResponseEntity.status(HttpStatus.CREATED).body(carritoCompras);

	}

	@PutMapping("/{id}")
	public ResponseEntity<Void> actualizar(@PathVariable Long id, @RequestBody ActualizarCarritoCompras newData) {
		carritoComprasService.actualizar(id, newData);
		return ResponseEntity.noContent().build();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminar(@PathVariable Long id) {
		carritoComprasService.eliminar(id);
		return ResponseEntity.noContent().build();
	}

}
