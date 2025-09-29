package com.hersac.backend.modules.comercial.detallesordenes.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.hersac.backend.globals.exceptions.ItemNotFoundException;
import com.hersac.backend.modules.comercial.detallesordenes.models.DetalleOrden;
import com.hersac.backend.modules.comercial.detallesordenes.models.repositories.DetalleOrdenRepository;
import com.hersac.backend.modules.comercial.detallesordenes.services.DetallesOrdenesService;

@Service
public class DetallesOrdenesServiceImpl implements DetallesOrdenesService {

	private final DetalleOrdenRepository detalleOrdenRepo;

	public DetallesOrdenesServiceImpl(DetalleOrdenRepository detalleOrdenRepo) {
		this.detalleOrdenRepo = detalleOrdenRepo;
	}

	@Override
	public Optional<List<DetalleOrden>> buscarTodos() {
		return Optional.of(detalleOrdenRepo.findAll());
	}

	@Override
	public Optional<DetalleOrden> buscarPorId(Long id) {
		Optional<DetalleOrden> detallesOrdenes = detalleOrdenRepo.findById(id);
		if (!detallesOrdenes.isPresent())
			throw new ItemNotFoundException("Detalles de orden no encontrados");
		return detallesOrdenes;
	}

	@Override
	public Optional<String> crear(DetalleOrden nuevoDetalleOrden) {
		detalleOrdenRepo.save(nuevoDetalleOrden);
		return Optional.of("Detalles de orden creados correctamente");
	}

	@Override
	public Optional<String> actualizar(Long id, DetalleOrden nuevaData) {
		Optional<DetalleOrden> detallesOrdenesAnterior = detalleOrdenRepo.findById(id);
		if (!detallesOrdenesAnterior.isPresent())
			throw new ItemNotFoundException("Detalles de orden no encontrados");
		detallesOrdenesAnterior.get().setOrdenId(nuevaData.getOrdenId());
		detallesOrdenesAnterior.get().setProdId(nuevaData.getProdId());
		detallesOrdenesAnterior.get().setCantidad(nuevaData.getCantidad());
		detalleOrdenRepo.save(detallesOrdenesAnterior.get());
		return Optional.of("Detalles de orden actualizados correctamente");
	}

	@Override
	public Optional<String> eliminar(Long id) {
		Optional<DetalleOrden> detallesOrdenes = detalleOrdenRepo.findById(id);
		if (!detallesOrdenes.isPresent())
			throw new ItemNotFoundException("Detalles de orden no encontrados");
		detalleOrdenRepo.deleteById(id);
		return Optional.of("Detalles de orden eliminados correctamente");
	}

}
