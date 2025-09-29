package com.hersac.backend.modules.comercial.carritocompras.services;

import java.util.List;
import java.util.Optional;

import com.hersac.backend.modules.comercial.carritocompras.models.CarritoCompras;

public interface CarritosComprasService {

	public Optional<List<CarritoCompras>> buscarTodos();

	public Optional<CarritoCompras> buscarPorId(Long id);

	public Optional<String> crear(CarritoCompras nuevoCarritoCompra);

	public Optional<String> actualizar(Long id, CarritoCompras nuevaData);

	public Optional<String> eliminar(Long id);

}
