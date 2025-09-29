package com.hersac.backend.modules.comercial.detallescarritoscompras.services;

import java.util.List;
import java.util.Optional;

import com.hersac.backend.modules.comercial.detallescarritoscompras.models.DetalleCC;

public interface DetallesCCService {

	public Optional<List<DetalleCC>> buscarTodos();

	public Optional<DetalleCC> buscarPorId(Long id);

	public Optional<String> crear(DetalleCC nuevoDetalleCC);

	public Optional<String> actualizar(Long id, DetalleCC nuevaData);

	public Optional<String> eliminar(Long id);

}
