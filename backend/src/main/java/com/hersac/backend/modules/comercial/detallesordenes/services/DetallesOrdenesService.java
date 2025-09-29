package com.hersac.backend.modules.comercial.detallesordenes.services;

import java.util.List;
import java.util.Optional;

import com.hersac.backend.modules.comercial.detallesordenes.models.DetalleOrden;

public interface DetallesOrdenesService {

	public Optional<List<DetalleOrden>> buscarTodos();

	public Optional<DetalleOrden> buscarPorId(Long id);

	public Optional<String> crear(DetalleOrden nuevoDetalleOrden);

	public Optional<String> actualizar(Long id, DetalleOrden nuevaData);

	public Optional<String> eliminar(Long id);

}
