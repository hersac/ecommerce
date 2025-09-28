package com.hersac.backend.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hersac.backend.models.CarritoCompras;
import com.hersac.backend.services.CarritoComprasService;

@RestController
@RequestMapping("/api/carritoCompras")
public class CarritoComprasController {

    @Autowired
    private CarritoComprasService carritoComprasService;

    @GetMapping
    public Optional<List<CarritoCompras>> getCarritoCompras() {
        return carritoComprasService.getCarritoCompras();
    }

    @GetMapping("/{id}")
    public Optional<CarritoCompras> getCarritoComprasById(
            @PathVariable Long id) {
        return carritoComprasService.getCarritoComprasById(id);
    }

    @PostMapping
    public Optional<String> addCarritoCompras(
            @RequestBody CarritoCompras newCarritoCompras) {
        return carritoComprasService.addCarritoCompras(newCarritoCompras);
    }

    @PutMapping("/{id}")
    public Optional<String> updateCarritoCompras(@PathVariable Long id,
            @RequestBody CarritoCompras newData) {
        return carritoComprasService.updateCarritoCompras(id, newData);
    }

    @DeleteMapping("/{id}")
    public Optional<String> deleteCarritoCompras(@PathVariable Long id) {
        return carritoComprasService.deleteCarritoComprasById(id);
    }
}
