package com.hersac.backend.modules.comercial.clientes.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.hersac.backend.globals.exceptions.ClienteNotFoundException;
import com.hersac.backend.modules.comercial.clientes.dto.ActualizarClienteDTO;
import com.hersac.backend.modules.comercial.clientes.dto.CrearClienteDTO;
import com.hersac.backend.modules.comercial.clientes.dto.ResponseClienteDTO;
import com.hersac.backend.modules.comercial.clientes.mappers.ClienteMappers;
import com.hersac.backend.modules.comercial.clientes.models.Cliente;
import com.hersac.backend.modules.comercial.clientes.models.repositories.ClienteRepository;
import com.hersac.backend.modules.comercial.clientes.services.ClientesService;

@Service
public class ClientesServiceImpl implements ClientesService {

	private final ClienteRepository clienteRepo;

	private final ClienteMappers clienteMappers;

	public ClientesServiceImpl(ClienteRepository clienteRepo, ClienteMappers clienteMappers) {
		this.clienteRepo = clienteRepo;
		this.clienteMappers = clienteMappers;
	}

	@Override
	public List<ResponseClienteDTO> buscarTodos() {
		List<Cliente> clientes = clienteRepo.findAll();
		List<ResponseClienteDTO> response = clienteMappers.toDto(clientes);
		return response;
	}

	@Override
	public ResponseClienteDTO buscarPorId(Long id) {
		Optional<Cliente> cliente = clienteRepo.findById(id);
		if (!cliente.isPresent())
			throw new ClienteNotFoundException("Cliente no encontrado");

		return clienteMappers.toDto(cliente.get());
	}

	@Override
	public ResponseClienteDTO buscarPorIdentificacion(String identificacion) {
		Optional<Cliente> cliente = clienteRepo.findByIdentificacion(identificacion);
		if (!cliente.isPresent())
			throw new ClienteNotFoundException("Cliente no encontrado");
		return clienteMappers.toDto(cliente.get());
	}

	@Override
	public ResponseClienteDTO crear(CrearClienteDTO nuevoCliente) {
		Cliente cliente = clienteMappers.toEntity(nuevoCliente);
		cliente = clienteRepo.save(cliente);
		return clienteMappers.toDto(cliente);
	}

	@Override
	public ResponseClienteDTO actualizar(Long id, ActualizarClienteDTO nuevaData) {
		Optional<Cliente> cliente = clienteRepo.findById(id);
		if (!cliente.isPresent())
			throw new ClienteNotFoundException("Cliente no encontrado");
		cliente.get().setPrimerNombre(nuevaData.getPrimerNombre());
		cliente.get().setSegundoNombre(nuevaData.getSegundoNombre());
		cliente.get().setPrimerApellido(nuevaData.getPrimerApellido());
		cliente.get().setSegundoApellido(nuevaData.getSegundoApellido());
		cliente.get().setTipoDocumento(nuevaData.getTipoDocumento());
		cliente.get().setIdentificacion(nuevaData.getIdentificacion());
		clienteRepo.save(cliente.get());
		return clienteMappers.toDto(cliente.get());
	}

	@Override
	public void eliminar(Long id) {
		Optional<Cliente> cliente = clienteRepo.findById(id);
		if (!cliente.isPresent())
			throw new ClienteNotFoundException("Cliente no encontrado");
		clienteRepo.deleteById(id);
	}

}
