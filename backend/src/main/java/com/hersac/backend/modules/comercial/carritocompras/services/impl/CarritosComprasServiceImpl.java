package com.hersac.backend.modules.comercial.carritocompras.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.hersac.backend.globals.exceptions.CarritoComprasNotFoundException;
import com.hersac.backend.modules.comercial.carritocompras.dto.ActualizarCarritoComprasDTO;
import com.hersac.backend.modules.comercial.carritocompras.dto.CrearCarritoComprasDTO;
import com.hersac.backend.modules.comercial.carritocompras.dto.ResponseCarritoComprasDTO;
import com.hersac.backend.modules.comercial.carritocompras.mappers.CarritoComprasMappers;
import com.hersac.backend.modules.comercial.carritocompras.models.CarritoCompras;
import com.hersac.backend.modules.comercial.carritocompras.models.repositories.CarritoComprasRepository;
import com.hersac.backend.modules.comercial.carritocompras.services.CarritosComprasService;
import com.hersac.backend.modules.users.usuarios.models.repositories.UsuarioRepository;

@Service
public class CarritosComprasServiceImpl implements CarritosComprasService {

	private final CarritoComprasRepository carritoComprasRepo;

	private final CarritoComprasMappers carritoComprasMapper;

	public CarritosComprasServiceImpl(CarritoComprasRepository carritoComprasRepo,
			CarritoComprasMappers carritoComprasMapper, UsuarioRepository usuarioRepo) {
		this.carritoComprasRepo = carritoComprasRepo;
		this.carritoComprasMapper = carritoComprasMapper;
	}

	@Override
	public List<ResponseCarritoComprasDTO> buscarTodos() {
		return carritoComprasMapper.toDto(carritoComprasRepo.findAll());
	}

	@Override
	public ResponseCarritoComprasDTO buscarPorId(Long id) {
		Optional<CarritoCompras> carrito = carritoComprasRepo.findById(id);
		if (!carrito.isPresent()) {
			throw new CarritoComprasNotFoundException("Carrito de compras no encontrado");
		}
		return carritoComprasMapper.toDto(carrito.get());
	}

	@Override
	public ResponseCarritoComprasDTO crear(CrearCarritoComprasDTO dto) {
		CarritoCompras nuevoCarritoCompra = carritoComprasMapper.toEntity(dto);
		return carritoComprasMapper.toDto(carritoComprasRepo.save(nuevoCarritoCompra));
	}

	@Override
	public ResponseCarritoComprasDTO actualizar(Long id, ActualizarCarritoComprasDTO nuevaData) {

		CarritoCompras carrito = carritoComprasRepo.findById(id)
			.orElseThrow(() -> new CarritoComprasNotFoundException("Carrito de compras no encontrado"));

		carrito.setIdentificacion(nuevaData.getIdentificacion());
		carrito.setEstado(nuevaData.getEstado());
		carrito.setEstaActivo(nuevaData.getEstaActivo());

		return carritoComprasMapper.toDto(carritoComprasRepo.save(carrito));
	}

	@Override
	public void eliminar(Long id) {
		CarritoCompras carrito = carritoComprasRepo.findById(id)
			.orElseThrow(() -> new CarritoComprasNotFoundException("Carrito de compras no encontrado"));
		carritoComprasRepo.delete(carrito);
	}

}
