package com.hersac.backend.modules.comercial.carritocompras.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.hersac.backend.modules.comercial.carritocompras.models.CarritoCompras;
import com.hersac.backend.modules.comercial.carritocompras.models.repositories.CarritoComprasRepository;
import com.hersac.backend.modules.comercial.carritocompras.services.CarritosComprasService;

@Service
public class CarritosComprasServiceImpl implements CarritosComprasService {

	private final CarritoComprasRepository carritoComprasRepo;

	public CarritosComprasServiceImpl(CarritoComprasRepository carritoComprasRepo) {
		this.carritoComprasRepo = carritoComprasRepo;
	}

	@Override
	public Optional<List<CarritoCompras>> buscarTodos() {
		return Optional.ofNullable(carritoComprasRepo.findAll());
	}

	@Override
	public Optional<CarritoCompras> buscarPorId(Long id) {
		Optional<CarritoCompras> carritoCompras = carritoComprasRepo.findById(id);
		if (!carritoCompras.isPresent())
			throw new RuntimeException("Carrito de compras no encontrado");
		return carritoCompras;
	}

	@Override
	public Optional<String> crear(CarritoCompras nuevoCarritoCompra) {
		carritoComprasRepo.save(nuevoCarritoCompra);
		return Optional.of("Carrito de compras agregado");
	}

	@Override
	public Optional<String> actualizar(Long id, CarritoCompras nuevaData) {
		Optional<CarritoCompras> carritoCompras = carritoComprasRepo.findById(id);
		if (!carritoCompras.isPresent())
			throw new RuntimeException("Carrito de compras no encontrado");
		carritoCompras.get().setUserId(nuevaData.getUserId());
		carritoCompras.get().setIdentificacion(nuevaData.getIdentificacion());
		carritoCompras.get().setFecha(nuevaData.getFecha());
		carritoCompras.get().setEstadoCarrito(nuevaData.getEstadoCarrito());
		carritoComprasRepo.save(carritoCompras.get());
		return Optional.of("Carrito de compras actualizado");
	}

	@Override
	public Optional<String> eliminar(Long id) {
		Optional<CarritoCompras> carritoCompras = carritoComprasRepo.findById(id);
		if (!carritoCompras.isPresent())
			throw new RuntimeException("Carrito de compras no encontrado");
		carritoComprasRepo.deleteById(id);
		return Optional.of("Carrito de compras eliminado");
	}

}
