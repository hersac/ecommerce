package com.hersac.backend.modules.comercial.clientes.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.hersac.backend.modules.comercial.clientes.models.Cliente;
import com.hersac.backend.modules.comercial.clientes.models.repositories.ClienteRepository;
import com.hersac.backend.modules.comercial.clientes.services.ClientesService;

@Service
public class ClientesServiceImpl implements ClientesService {

	private final ClienteRepository clienteRepo;

	public ClientesServiceImpl(ClienteRepository clienteRepo) {
		this.clienteRepo = clienteRepo;
	}

	@Override
	public Optional<List<Cliente>> buscarTodos() {
		return Optional.ofNullable(clienteRepo.findAll());
	}

	@Override
	public Optional<Cliente> buscarPorId(Long id) {
		Optional<Cliente> cliente = clienteRepo.findById(id);
		if (!cliente.isPresent())
			throw new RuntimeException("Cliente no encontrado");
		return clienteRepo.findById(id);
	}

	@Override
	public Optional<String> crear(Cliente nuevoCliente) {
		clienteRepo.save(nuevoCliente);
		return Optional.of("Cliente agregado");
	}

	@Override
	public Optional<String> actualizar(Long id, Cliente nuevaData) {
		Optional<Cliente> cliente = clienteRepo.findById(id);
		if (!cliente.isPresent())
			throw new RuntimeException("Cliente no encontrado");
		cliente.get().setPrimerNombre(nuevaData.getPrimerNombre());
		cliente.get().setSegundoNombre(nuevaData.getSegundoNombre());
		cliente.get().setPrimerApellido(nuevaData.getPrimerApellido());
		cliente.get().setSegundoApellido(nuevaData.getSegundoApellido());
		cliente.get().setTipoDocumento(nuevaData.getTipoDocumento());
		cliente.get().setIdentificacion(nuevaData.getIdentificacion());
		clienteRepo.save(cliente.get());
		return Optional.of("Cliente actualizado");
	}

	@Override
	public Optional<String> eliminar(Long id) {
		Optional<Cliente> cliente = clienteRepo.findById(id);
		if (!cliente.isPresent())
			throw new RuntimeException("Cliente no encontrado");
		clienteRepo.deleteById(id);
		return Optional.of("Cliente eliminado");
	}

}
