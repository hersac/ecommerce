package com.hersac.backend.modules.comercial.carritocompras;

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
	public Optional<List<CarritoCompras>> buscarTodos() {
		return carritoComprasService.buscarTodos();
	}

	@GetMapping("/{id}")
	public Optional<CarritoCompras> buscarPorId(@PathVariable Long id) {
		return carritoComprasService.buscarPorId(id);
	}

	@PostMapping
	public Optional<String> crear(@RequestBody CarritoCompras newCarritoCompras) {
		return carritoComprasService.crear(newCarritoCompras);
	}

	@PutMapping("/{id}")
	public Optional<String> actualizar(@PathVariable Long id, @RequestBody CarritoCompras newData) {
		return carritoComprasService.actualizar(id, newData);
	}

	@DeleteMapping("/{id}")
	public Optional<String> eliminar(@PathVariable Long id) {
		return carritoComprasService.eliminar(id);
	}

}
