package com.hersac.backend.services;

import java.util.List;
import java.util.Optional;

import com.hersac.backend.models.DetallesOrdenes;

public interface DetallesOrdenesService {
    public Optional<List<DetallesOrdenes>> getDetallesOrdenes();
    public Optional<DetallesOrdenes> getDetallesOrdenesById(Long id);
    public Optional<String> addDetallesOrdenes(DetallesOrdenes detalleOrden);
    public Optional<String> updateDetallesOrdenes(Long id, DetallesOrdenes detalleOrden);
    public Optional<String> deleteDetallesOrdenesById(Long id);
}
