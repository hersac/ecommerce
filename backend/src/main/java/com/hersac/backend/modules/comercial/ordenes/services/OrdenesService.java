package com.hersac.backend.modules.comercial.ordenes.services;

import java.util.List;
import java.util.Optional;

import com.hersac.backend.modules.comercial.ordenes.models.Ordenes;

public interface OrdenesService {

	public Optional<List<Ordenes>> getOrdenes();

	public Optional<Ordenes> getOrdenById(Long id);

	public Optional<String> addOrden(Ordenes orden);

	public Optional<String> updateOrden(Long id, Ordenes orden);

	public Optional<String> deleteOrdenById(Long id);

}
