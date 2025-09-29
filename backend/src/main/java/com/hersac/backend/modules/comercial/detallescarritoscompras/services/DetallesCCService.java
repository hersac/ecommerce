package com.hersac.backend.modules.comercial.detallescarritoscompras.services;

import java.util.List;
import java.util.Optional;

import com.hersac.backend.modules.comercial.detallescarritoscompras.models.DetallesCC;

public interface DetallesCCService {

	public Optional<List<DetallesCC>> getDetallesCC();

	public Optional<DetallesCC> getDetallesCCById(Long id);

	public Optional<String> addDetallesCC(DetallesCC detalleCC);

	public Optional<String> updateDetallesCC(Long id, DetallesCC detalleCC);

	public Optional<String> deleteDetallesCCById(Long id);

}
