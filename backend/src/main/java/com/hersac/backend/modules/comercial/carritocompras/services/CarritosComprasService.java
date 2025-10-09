package com.hersac.backend.modules.comercial.carritocompras.services;

import java.util.List;

import com.hersac.backend.modules.comercial.carritocompras.dto.ActualizarCarritoComprasDTO;
import com.hersac.backend.modules.comercial.carritocompras.dto.CrearCarritoComprasDTO;
import com.hersac.backend.modules.comercial.carritocompras.dto.ResponseCarritoComprasDTO;

public interface CarritosComprasService {

	public List<ResponseCarritoComprasDTO> buscarTodos();

	public ResponseCarritoComprasDTO buscarPorId(Long id);

	public ResponseCarritoComprasDTO crear(CrearCarritoComprasDTO nuevoCarritoCompra);

	public ResponseCarritoComprasDTO actualizar(Long id, ActualizarCarritoComprasDTO nuevaData);

	public void eliminar(Long id);

}
