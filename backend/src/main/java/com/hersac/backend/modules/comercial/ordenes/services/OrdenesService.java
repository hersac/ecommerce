package com.hersac.backend.modules.comercial.ordenes.services;

import java.util.List;
import java.util.Optional;

import com.hersac.backend.modules.comercial.ordenes.models.Orden;

public interface OrdenesService {

	public Optional<List<Orden>> buscarTodos();

	public Optional<Orden> buscarPorId(Long id);

	public Optional<String> crear(Orden nuevaOrden);

	public Optional<String> actualizar(Long id, Orden nuevaData);

	public Optional<String> eliminar(Long id);

}
