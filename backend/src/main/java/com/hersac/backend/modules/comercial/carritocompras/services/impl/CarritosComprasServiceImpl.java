package com.hersac.backend.modules.comercial.carritocompras.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hersac.backend.globals.exceptions.CarritoComprasNotFoundException;
import com.hersac.backend.modules.comercial.carritocompras.models.CarritoCompras;
import com.hersac.backend.modules.comercial.carritocompras.models.repositories.CarritoComprasRepository;
import com.hersac.backend.modules.comercial.carritocompras.services.CarritosComprasService;
import com.hersac.backend.modules.users.usuarios.models.Usuario;
import com.hersac.backend.modules.users.usuarios.models.repositories.UsuarioRepository;

@Service
public class CarritosComprasServiceImpl implements CarritosComprasService {

	private final CarritoComprasRepository carritoComprasRepo;

	private final UsuarioRepository usuarioRepo;

	public CarritosComprasServiceImpl(CarritoComprasRepository carritoComprasRepo, UsuarioRepository usuarioRepo) {
		this.carritoComprasRepo = carritoComprasRepo;
		this.usuarioRepo = usuarioRepo;
	}

	@Override
	public List<CarritoCompras> buscarTodos() {
		return carritoComprasRepo.findAll();
	}

	@Override
	public CarritoCompras buscarPorId(Long id) {
		return carritoComprasRepo.findById(id)
			.orElseThrow(() -> new CarritoComprasNotFoundException("Carrito de compras no encontrado"));
	}

	@Override
	public CarritoCompras crear(CarritoCompras nuevoCarritoCompra) {
		return carritoComprasRepo.save(nuevoCarritoCompra);
	}

	@Override
	public CarritoCompras actualizar(Long id, CarritoCompras nuevaData) {
		CarritoCompras carrito = carritoComprasRepo.findById(id)
			.orElseThrow(() -> new CarritoComprasNotFoundException("Carrito de compras no encontrado"));

		Usuario usuario = usuarioRepo.findById(nuevaData.getUsuarioId().getUserId())
			.orElseThrow(() -> new CarritoComprasNotFoundException("Usuario no encontrado"));

		carrito.setIdentificacion(nuevaData.getIdentificacion());
		carrito.setEstado(nuevaData.getEstado());
		carrito.setUsuarioId(usuario);

		return carritoComprasRepo.save(carrito);
	}

	@Override
	public void eliminar(Long id) {
		CarritoCompras carrito = carritoComprasRepo.findById(id)
			.orElseThrow(() -> new CarritoComprasNotFoundException("Carrito de compras no encontrado"));
		carritoComprasRepo.delete(carrito);
	}

}
