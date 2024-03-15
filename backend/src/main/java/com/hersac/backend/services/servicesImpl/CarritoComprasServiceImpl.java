package com.hersac.backend.services.servicesImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hersac.backend.models.CarritoCompras;
import com.hersac.backend.repositories.CarritoComprasRepository;
import com.hersac.backend.services.CarritoComprasService;

@Service
public class CarritoComprasServiceImpl implements CarritoComprasService {
    @Autowired
    private CarritoComprasRepository carritoComprasRepo;

    @Override
    public Optional<List<CarritoCompras>> getCarritoCompras() {
        return Optional.ofNullable(carritoComprasRepo.findAll());
    }

    @Override
    public Optional<CarritoCompras> getCarritoComprasById(Long id) {
        Optional<CarritoCompras> carritoCompras = carritoComprasRepo.findById(id);
        if(!carritoCompras.isPresent())
            throw new RuntimeException("Carrito de compras no encontrado");
        return carritoCompras;
    }

    @Override
    public Optional<String> addCarritoCompras(CarritoCompras newCarritoCompras) {
        carritoComprasRepo.save(newCarritoCompras);
        return Optional.of("Carrito de compras agregado");
    }

    @Override
    public Optional<String> updateCarritoCompras(Long id, CarritoCompras newData) {
        Optional<CarritoCompras> carritoCompras = carritoComprasRepo.findById(id);
        if(!carritoCompras.isPresent())
            throw new RuntimeException("Carrito de compras no encontrado");
        carritoCompras.setUserId(newData.getUserId());
        carritoCompras.setIdentificacion(newData.getIdentificacion());
        carritoCompras.setFecha(newData.getFecha());
        carritoCompras.setEstadoCarrito(newData.getEstadoCarrito());
        carritoComprasRepo.save(newData);
        return Optional.of("Carrito de compras actualizado");
    }

    @Override
    public Optional<String> deleteCarritoComprasById(Long id) {
        Optional<CarritoCompras> carritoCompras = carritoComprasRepo.findById(id);
        if(!carritoCompras.isPresent())
            throw new RuntimeException("Carrito de compras no encontrado");
        carritoComprasRepo.deleteById(id);
        return Optional.of("Carrito de compras eliminado");
    }
}
