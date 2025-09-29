package com.hersac.backend.modules.comercial.detallescarritoscompras.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.hersac.backend.globals.exceptions.ItemNotFoundException;
import com.hersac.backend.modules.comercial.detallescarritoscompras.models.DetalleCC;
import com.hersac.backend.modules.comercial.detallescarritoscompras.models.repositories.DetalleCCRepository;
import com.hersac.backend.modules.comercial.detallescarritoscompras.services.DetallesCCService;

@Service
public class DetallesCCServiceImple implements DetallesCCService {

	private final DetalleCCRepository detalleCCRepo;

	public DetallesCCServiceImple(DetalleCCRepository detalleCCRepo) {
		this.detalleCCRepo = detalleCCRepo;
	}

	@Override
	public Optional<List<DetalleCC>> buscarTodos() {
		return Optional.of(detalleCCRepo.findAll());
	}

	@Override
	public Optional<DetalleCC> buscarPorId(Long id) {
		Optional<DetalleCC> detallesCC = detalleCCRepo.findById(id);
		if (!detallesCC.isPresent())
			throw new ItemNotFoundException("Detalles de carrito de compras no encontrados");
		return detallesCC;
	}

	@Override
	public Optional<String> crear(DetalleCC nuevoDetalleCC) {
		detalleCCRepo.save(nuevoDetalleCC);
		return Optional.of("Detalles de carrito de compra creados correctamente");
	}

	@Override
	public Optional<String> actualizar(Long id, DetalleCC nuevaData) {
		Optional<DetalleCC> detallesCCAnterior = detalleCCRepo.findById(id);
		if (!detallesCCAnterior.isPresent())
			throw new ItemNotFoundException("Detalles de carrito de compras no encontrados");

		detallesCCAnterior.get().setIdentificacion(nuevaData.getIdentificacion());
		detallesCCAnterior.get().setProdId(nuevaData.getProdId());
		detallesCCAnterior.get().setCantidad(nuevaData.getCantidad());
		detallesCCAnterior.get().setPrecioUnitario(nuevaData.getPrecioUnitario());
		detallesCCAnterior.get().setSubtotal(nuevaData.getSubtotal());
		detalleCCRepo.save(detallesCCAnterior.get());
		return Optional.of("Detalles de carrito de compras actualizados correctamente");
	}

	@Override
	public Optional<String> eliminar(Long id) {
		Optional<DetalleCC> detallesCC = detalleCCRepo.findById(id);
		if (!detallesCC.isPresent())
			throw new ItemNotFoundException("Detalles de carrito de compras no encontrados");
		detalleCCRepo.deleteById(id);
		return Optional.of("Detalles de carrito de compras eliminados correctamente");
	}

}
