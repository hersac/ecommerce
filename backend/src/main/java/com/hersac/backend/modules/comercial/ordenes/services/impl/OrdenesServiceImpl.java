package com.hersac.backend.modules.comercial.ordenes.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.hersac.backend.globals.exceptions.ItemNotFoundException;
import com.hersac.backend.modules.comercial.ordenes.models.Orden;
import com.hersac.backend.modules.comercial.ordenes.models.repositories.OrdenRepository;
import com.hersac.backend.modules.comercial.ordenes.services.OrdenesService;

@Service
public class OrdenesServiceImpl implements OrdenesService {

	private final OrdenRepository ordenRepo;

	public OrdenesServiceImpl(OrdenRepository ordenRepo) {
		this.ordenRepo = ordenRepo;
	}

	@Override
	public Optional<List<Orden>> buscarTodos() {
		return Optional.of(ordenRepo.findAll());
	}

	@Override
	public Optional<Orden> buscarPorId(Long id) {
		Optional<Orden> orden = ordenRepo.findById(id);
		if (!orden.isPresent())
			throw new ItemNotFoundException("Orden no encontrada");
		return orden;
	}

	@Override
	public Optional<String> crear(Orden nuevaOrden) {
		ordenRepo.save(nuevaOrden);
		return Optional.of("Orden creada correctamente");
	}

	@Override
	public Optional<String> actualizar(Long id, Orden nuevaData) {
		Optional<Orden> ordenAnterior = ordenRepo.findById(id);
		if (!ordenAnterior.isPresent())
			throw new ItemNotFoundException("Orden no encontrada");
		ordenAnterior.get().setFechaOrden(nuevaData.getFechaOrden());
		ordenAnterior.get().setUserId(nuevaData.getUserId());
		ordenAnterior.get().setFechaOrden(nuevaData.getFechaOrden());
		ordenAnterior.get().setDireccionEnvio(nuevaData.getDireccionEnvio());
		ordenAnterior.get().setEstadoOrden(nuevaData.getEstadoOrden());

		ordenRepo.save(ordenAnterior.get());
		return Optional.of("Orden actualizada correctamente");
	}

	@Override
	public Optional<String> eliminar(Long id) {
		Optional<Orden> orden = ordenRepo.findById(id);
		if (!orden.isPresent())
			throw new ItemNotFoundException("Orden no encontrada");
		ordenRepo.deleteById(id);
		return Optional.of("Orden eliminada correctamente");
	}

}
