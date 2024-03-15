package com.hersac.backend.services.servicesImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hersac.backend.controllers.exceptions.ItemNotFoundException;
import com.hersac.backend.models.Ordenes;
import com.hersac.backend.repositories.OrdenesRepository;
import com.hersac.backend.services.OrdenesService;

@Service
public class OrdenesServiceImpl implements OrdenesService {

    @Autowired
    private OrdenesRepository ordenRepo;

    @Override
    public Optional<List<Ordenes>> getOrdenes() {
        return Optional.of(ordenRepo.findAll());
    }

    @Override
    public Optional<Ordenes> getOrdenById(Long id) {
        Optional<Ordenes> orden = ordenRepo.findById(id);
        if (!orden.isPresent())
            throw new ItemNotFoundException("Orden no encontrada");
        return orden;
    }

    @Override
    public Optional<String> addOrden(Ordenes orden) {
        ordenRepo.save(orden);
        return Optional.of("Orden creada correctamente");
    }

    @Override
    public Optional<String> updateOrden(Long id, Ordenes orden) {
        Optional<Ordenes> ordenAnterior = ordenRepo.findById(id);
        if (!ordenAnterior.isPresent())
            throw new ItemNotFoundException("Orden no encontrada");
        ordenAnterior.get().setFechaOrden(orden.getFechaOrden());
        ordenAnterior.get().setUserId(orden.getUserId());
        ordenAnterior.get().setFechaOrden(orden.getFechaOrden());
        ordenAnterior.get().setDireccionEnvio(orden.getDireccionEnvio());
        ordenAnterior.get().setEstadoOrden(orden.getEstadoOrden());

        ordenRepo.save(ordenAnterior.get());
        return Optional.of("Orden actualizada correctamente");
    }

    @Override
    public Optional<String> deleteOrdenById(Long id) {
        Optional<Ordenes> orden = ordenRepo.findById(id);
        if (!orden.isPresent())
            throw new ItemNotFoundException("Orden no encontrada");
        ordenRepo.deleteById(id);
        return Optional.of("Orden eliminada correctamente");
    }
}
