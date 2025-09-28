package com.hersac.backend.services.servicesImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hersac.backend.controllers.exceptions.ItemNotFoundException;
import com.hersac.backend.models.DetallesOrdenes;
import com.hersac.backend.repositories.DetallesOrdenesRepository;
import com.hersac.backend.services.DetallesOrdenesService;

@Service
public class DetallesOrdenesServiceImpl implements DetallesOrdenesService {
    @Autowired
    private DetallesOrdenesRepository detallesOrdenesRepo;

    @Override
    public Optional<List<DetallesOrdenes>> getDetallesOrdenes() {
        return Optional.of(detallesOrdenesRepo.findAll());
    }

    @Override
    public Optional<DetallesOrdenes> getDetallesOrdenesById(Long id){
        Optional<DetallesOrdenes> detallesOrdenes = detallesOrdenesRepo.findById(id);
        if (!detallesOrdenes.isPresent())
            throw new ItemNotFoundException("Detalles de orden no encontrados");
        return detallesOrdenes;
    }

    @Override
    public Optional<String> addDetallesOrdenes(DetallesOrdenes detallesOrdenes) {
        detallesOrdenesRepo.save(detallesOrdenes);
        return Optional.of("Detalles de orden creados correctamente");
    }

    @Override
    public Optional<String> updateDetallesOrdenes(Long id, DetallesOrdenes detallesOrdenes) {
        Optional<DetallesOrdenes> detallesOrdenesAnterior = detallesOrdenesRepo.findById(id);
        if (!detallesOrdenesAnterior.isPresent())
            throw new ItemNotFoundException("Detalles de orden no encontrados");
        detallesOrdenesAnterior.get().setOrdenId(detallesOrdenes.getOrdenId());
        detallesOrdenesAnterior.get().setProdId(detallesOrdenes.getProdId());
        detallesOrdenesAnterior.get().setCantidad(detallesOrdenes.getCantidad());
        detallesOrdenesRepo.save(detallesOrdenesAnterior.get());
        return Optional.of("Detalles de orden actualizados correctamente");
    }

    @Override
    public Optional<String> deleteDetallesOrdenesById(Long id) {
        Optional<DetallesOrdenes> detallesOrdenes = detallesOrdenesRepo.findById(id);
        if (!detallesOrdenes.isPresent())
            throw new ItemNotFoundException("Detalles de orden no encontrados");
        detallesOrdenesRepo.deleteById(id);
        return Optional.of("Detalles de orden eliminados correctamente");
    }
}
