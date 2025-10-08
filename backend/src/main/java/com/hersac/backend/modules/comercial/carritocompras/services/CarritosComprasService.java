package com.hersac.backend.modules.comercial.carritocompras.services;

import java.util.List;

import com.hersac.backend.modules.comercial.carritocompras.dto.ActualizarCarritoCompras;
import com.hersac.backend.modules.comercial.carritocompras.dto.CrearCarritoCompras;
import com.hersac.backend.modules.comercial.carritocompras.dto.ResponseCarritoCompras;

public interface CarritosComprasService {

	public List<ResponseCarritoCompras> buscarTodos();

	public ResponseCarritoCompras buscarPorId(Long id);

	public ResponseCarritoCompras crear(CrearCarritoCompras nuevoCarritoCompra);

	public ResponseCarritoCompras actualizar(Long id, ActualizarCarritoCompras nuevaData);

	public void eliminar(Long id);

}
