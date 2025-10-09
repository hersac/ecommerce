package com.hersac.backend.modules.comercial.clientes.services;

import java.util.List;

import com.hersac.backend.modules.comercial.clientes.dto.ActualizarClienteDTO;
import com.hersac.backend.modules.comercial.clientes.dto.CrearClienteDTO;
import com.hersac.backend.modules.comercial.clientes.dto.ResponseClienteDTO;

public interface ClientesService {

	public List<ResponseClienteDTO> buscarTodos();

	public ResponseClienteDTO buscarPorId(Long id);

	public ResponseClienteDTO buscarPorIdentificacion(String identificacion);

	public ResponseClienteDTO crear(CrearClienteDTO nuevoCliente);

	public ResponseClienteDTO actualizar(Long id, ActualizarClienteDTO nuevaData);

	public void eliminar(Long id);

}
