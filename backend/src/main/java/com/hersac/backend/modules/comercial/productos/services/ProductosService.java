package com.hersac.backend.modules.comercial.productos.services;

import java.util.List;
import java.util.Optional;

import com.hersac.backend.modules.comercial.productos.models.Productos;

public interface ProductosService {

	public Optional<List<Productos>> getProductos();

	public Optional<Productos> getProductoById(Long id);

	public Optional<String> addProducto(Productos newProducto);

	public Optional<String> updateProducto(Long id, Productos newData);

	public Optional<String> deleteProductoById(Long id);

}
