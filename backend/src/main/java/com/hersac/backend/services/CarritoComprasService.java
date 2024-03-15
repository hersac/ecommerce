package com.hersac.backend.services;

import java.util.List;
import java.util.Optional;

import com.hersac.backend.models.CarritoCompras;

public interface CarritoComprasService {
    public Optional<List<CarritoCompras>> getCarritoCompras();
    public Optional<CarritoCompras> getCarritoComprasById(Long id);
    public Optional<String> addCarritoCompras(CarritoCompras newCarritoCompras);
    public Optional<String> updateCarritoCompras(Long id, CarritoCompras newData);
    public Optional<String> deleteCarritoComprasById(Long id);
}
