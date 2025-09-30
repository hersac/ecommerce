package com.hersac.backend.modules.comercial.carritocompras.services;

import java.util.List;

import com.hersac.backend.modules.comercial.carritocompras.models.CarritoCompras;

public interface CarritosComprasService {

	public List<CarritoCompras> buscarTodos();

	public CarritoCompras buscarPorId(Long id);

	public CarritoCompras crear(CarritoCompras nuevoCarritoCompra);

	public CarritoCompras actualizar(Long id, CarritoCompras nuevaData);

	public void eliminar(Long id);

}
