package com.hersac.backend.modules.comercial.carritocompras;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hersac.backend.modules.comercial.carritocompras.models.CarritoCompras;
import com.hersac.backend.modules.comercial.carritocompras.services.CarritosComprasService;

@RestController
@RequestMapping("/api/carritoCompras")
public class CarritoComprasController {

	private final CarritosComprasService carritoComprasService;

	public CarritoComprasController(CarritosComprasService carritoComprasService) {
		this.carritoComprasService = carritoComprasService;
	}

	@GetMapping
	public ResponseEntity<List<CarritoCompras>> buscarTodos() {
		List<CarritoCompras> carritoCompras = carritoComprasService.buscarTodos();
		return ResponseEntity.ok().body(carritoCompras);
	}

	@GetMapping("/{id}")
	public ResponseEntity<CarritoCompras> buscarPorId(@PathVariable Long id) {
		CarritoCompras carritoCompras = carritoComprasService.buscarPorId(id);
		return ResponseEntity.ok().body(carritoCompras);

	}

	@PostMapping
	public ResponseEntity<CarritoCompras> crear(@RequestBody CarritoCompras newCarritoCompras) {
		CarritoCompras carritoCompras = carritoComprasService.crear(newCarritoCompras);
		return ResponseEntity.status(HttpStatus.CREATED).body(carritoCompras);

	}

	@PutMapping("/{id}")
	public ResponseEntity<Void> actualizar(@PathVariable Long id, @RequestBody CarritoCompras newData) {
		carritoComprasService.actualizar(id, newData);
		return ResponseEntity.noContent().build();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminar(@PathVariable Long id) {
		carritoComprasService.eliminar(id);
		return ResponseEntity.noContent().build();
	}

}
