package com.hersac.backend.modules.comercial.productos;

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

import com.hersac.backend.modules.comercial.productos.models.Producto;
import com.hersac.backend.modules.comercial.productos.services.ProductosService;

@RestController
@RequestMapping("/api/productos")
public class ProductosController {

	private final ProductosService productosServ;

	public ProductosController(ProductosService productosServ) {
		this.productosServ = productosServ;
	}

	@GetMapping
	public Optional<List<Producto>> buscarTodos() {
		return productosServ.buscarTodos();
	}

	@GetMapping("/{id}")
	public Optional<Producto> buscarPorId(@PathVariable Long id) {
		return productosServ.buscarPorId(id);
	}

	@PostMapping
	public Optional<String> crear(@RequestBody Producto nuevoProducto) {
		return productosServ.crear(nuevoProducto);
	}

	@PutMapping("/{id}")
	public Optional<String> actualizar(@PathVariable Long id, @RequestBody Producto nuevaData) {
		return productosServ.actualizar(id, nuevaData);
	}

	@DeleteMapping("/{id}")
	public Optional<String> eliminar(@PathVariable Long id) {
		return productosServ.eliminar(id);
	}

}
