package com.hersac.backend.modules.comercial.clientes.services;

import java.util.List;
import java.util.Optional;

import com.hersac.backend.modules.comercial.clientes.models.Cliente;

public interface ClientesService {

	public Optional<List<Cliente>> buscarTodos();

	public Optional<Cliente> buscarPorId(Long id);

	public Optional<String> crear(Cliente nuevoCliente);

	public Optional<String> actualizar(Long id, Cliente nuevaData);

	public Optional<String> eliminar(Long id);

}
