package com.hersac.backend.modules.comercial.productos.services;

import java.util.List;
import java.util.Optional;

import com.hersac.backend.modules.comercial.productos.models.Producto;

public interface ProductosService {

	public Optional<List<Producto>> buscarTodos();

	public Optional<Producto> buscarPorId(Long id);

	public Optional<String> crear(Producto nuevoProducto);

	public Optional<String> actualizar(Long id, Producto nuevaData);

	public Optional<String> eliminar(Long id);

}
