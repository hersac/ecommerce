package com.hersac.backend.services;

import java.util.List;
import java.util.Optional;

import com.hersac.backend.models.Clientes;

public interface ClientesService {
    public Optional<List<Clientes>> getClientes();
    public Optional<Clientes> getClientesById(Long id);
    public Optional<String> addClientes(Clientes newClientes);
    public Optional<String> updateClientes(Long id, Clientes newData);
    public Optional<String> deleteClientesById(Long id);
}
