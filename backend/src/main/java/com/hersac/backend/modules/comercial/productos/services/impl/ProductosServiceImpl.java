package com.hersac.backend.modules.comercial.productos.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.hersac.backend.modules.comercial.productos.models.Producto;
import com.hersac.backend.modules.comercial.productos.models.repositories.ProductoRepository;
import com.hersac.backend.modules.comercial.productos.services.ProductosService;

@Service
public class ProductosServiceImpl implements ProductosService {

	private final ProductoRepository productosRepo;

	public ProductosServiceImpl(ProductoRepository productosRepo) {
		this.productosRepo = productosRepo;
	}

	@Override
	public Optional<List<Producto>> buscarTodos() {
		return Optional.ofNullable(productosRepo.findAll());
	}

	@Override
	public Optional<Producto> buscarPorId(Long id) {
		Optional<Producto> producto = productosRepo.findById(id);
		if (!producto.isPresent())
			throw new RuntimeException("Producto no encontrado");
		return producto;
	}

	@Override
	public Optional<String> crear(Producto nuevoProducto) {
		productosRepo.save(nuevoProducto);
		return Optional.of("Producto agregado");
	}

	@Override
	public Optional<String> actualizar(Long id, Producto nuevaData) {
		Optional<Producto> producto = productosRepo.findById(id);
		if (!producto.isPresent())
			throw new RuntimeException("Producto no encontrado");
		producto.get().setNombre(nuevaData.getNombre());
		producto.get().setDescCorta(nuevaData.getDescCorta());
		producto.get().setDescripcion(nuevaData.getDescripcion());
		producto.get().setPrecio(nuevaData.getPrecio());
		producto.get().setReferencia(nuevaData.getReferencia());
		producto.get().setCategoria(nuevaData.getCategoria());
		producto.get().setDisponible(nuevaData.getDisponible());
		productosRepo.save(producto.get());
		return Optional.of("Producto actualizado");
	}

	@Override
	public Optional<String> eliminar(Long id) {
		Optional<Producto> producto = productosRepo.findById(id);
		if (!producto.isPresent())
			throw new RuntimeException("Producto no encontrado");
		return Optional.of("Producto eliminado");
	}

}
