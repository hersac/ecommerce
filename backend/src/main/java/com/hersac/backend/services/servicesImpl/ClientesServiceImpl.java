package com.hersac.backend.services.servicesImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hersac.backend.models.Clientes;
import com.hersac.backend.repositories.ClientesRepository;
import com.hersac.backend.services.ClientesService;

@Service
public class ClientesServiceImpl implements ClientesService{
    @Autowired
    private ClientesRepository clientesRepo;

    @Override
    public Optional<List<Clientes>> getClientes() {
        return Optional.ofNullable(clientesRepo.findAll());
    }

    @Override
    public Optional<Clientes> getClientesById(Long id) {
        Optional<Clientes> cliente = clientesRepo.findById(id);
        if(!cliente.isPresent())
            throw new RuntimeException("Cliente no encontrado");
        return clientesRepo.findById(id);
    }

    @Override
    public Optional<String> addClientes(Clientes newClientes) {
        clientesRepo.save(newClientes);
        return Optional.of("Cliente agregado");
    }

    @Override
    public Optional<String> updateClientes(Long id, Clientes newData) {
        Optional<Clientes> cliente = clientesRepo.findById(id);
        if(!cliente.isPresent())
            throw new RuntimeException("Cliente no encontrado");
        cliente.setPrimerNombre(newData.getPrimerNombre());
        cliente.setSegundoNombre(newData.getSegundoNombre());
        cliente.setPrimerApellido(newData.getPrimerApellido());
        cliente.setSegundoApellido(newData.getSegundoApellido());
        cliente.setTipoDocumento(newData.getTipoDocumento());
        cliente.setIdentificacion(newData.getIdentificacion());
        clientesRepo.save(newData);
        return Optional.of("Cliente actualizado");
    }

    @Override
    public Optional<String> deleteClientesById(Long id) {
        Optional<Clientes> cliente = clientesRepo.findById(id);
        if(!cliente.isPresent())
            throw new RuntimeException("Cliente no encontrado");
        clientesRepo.deleteById(id);
        return Optional.of("Cliente eliminado");
    }
}
