package com.hersac.backend.modules.comercial.detallescarritoscompras.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.hersac.backend.globals.exceptions.ItemNotFoundException;
import com.hersac.backend.modules.comercial.detallescarritoscompras.models.DetallesCC;
import com.hersac.backend.modules.comercial.detallescarritoscompras.models.repositories.DetallesCCRepository;
import com.hersac.backend.modules.comercial.detallescarritoscompras.services.DetallesCCService;

@Service
public class DetallesCCServiceImple implements DetallesCCService {

	private final DetallesCCRepository detallesCCRepo;

	public DetallesCCServiceImple(DetallesCCRepository detallesCCRepo) {
		this.detallesCCRepo = detallesCCRepo;
	}

	@Override
	public Optional<List<DetallesCC>> getDetallesCC() {
		return Optional.of(detallesCCRepo.findAll());
	}

	@Override
	public Optional<DetallesCC> getDetallesCCById(Long id) {
		Optional<DetallesCC> detallesCC = detallesCCRepo.findById(id);
		if (!detallesCC.isPresent())
			throw new ItemNotFoundException("Detalles de carrito de compras no encontrados");
		return detallesCC;
	}

	@Override
	public Optional<String> addDetallesCC(DetallesCC detallesCC) {
		detallesCCRepo.save(detallesCC);
		return Optional.of("Detalles de carrito de compra creados correctamente");
	}

	@Override
	public Optional<String> updateDetallesCC(Long id, DetallesCC detallesCC) {
		Optional<DetallesCC> detallesCCAnterior = detallesCCRepo.findById(id);
		if (!detallesCCAnterior.isPresent())
			throw new ItemNotFoundException("Detalles de carrito de compras no encontrados");

		detallesCCAnterior.get().setIdentificacion(detallesCC.getIdentificacion());
		detallesCCAnterior.get().setProdId(detallesCC.getProdId());
		detallesCCAnterior.get().setCantidad(detallesCC.getCantidad());
		detallesCCAnterior.get().setPrecioUnitario(detallesCC.getPrecioUnitario());
		detallesCCAnterior.get().setSubtotal(detallesCC.getSubtotal());
		detallesCCRepo.save(detallesCCAnterior.get());
		return Optional.of("Detalles de carrito de compras actualizados correctamente");
	}

	@Override
	public Optional<String> deleteDetallesCCById(Long id) {
		Optional<DetallesCC> detallesCC = detallesCCRepo.findById(id);
		if (!detallesCC.isPresent())
			throw new ItemNotFoundException("Detalles de carrito de compras no encontrados");
		detallesCCRepo.deleteById(id);
		return Optional.of("Detalles de carrito de compras eliminados correctamente");
	}

}
