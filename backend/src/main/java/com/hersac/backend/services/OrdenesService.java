package com.hersac.backend.services;

import java.util.List;
import java.util.Optional;

import com.hersac.backend.models.Ordenes;

public interface OrdenesService {

	public Optional<List<Ordenes>> getOrdenes();

	public Optional<Ordenes> getOrdenById(Long id);

	public Optional<String> addOrden(Ordenes orden);

	public Optional<String> updateOrden(Long id, Ordenes orden);

	public Optional<String> deleteOrdenById(Long id);

}
