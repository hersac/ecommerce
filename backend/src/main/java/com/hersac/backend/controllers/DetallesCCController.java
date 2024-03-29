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

import com.hersac.backend.models.DetallesCC;
import com.hersac.backend.services.DetallesCCService;

@RestController
@RequestMapping("/api/detallesCC")
public class DetallesCCController {

    @Autowired
    private DetallesCCService detallesCCService;

    @GetMapping
    public Optional<List<DetallesCC>> getDetallesOrdenes(){
        return detallesCCService.getDetallesCC();
    }

    @GetMapping("/{id}")
    public Optional<DetallesCC> getDetallesOrdenesById(@PathVariable Long id){
        return detallesCCService.getDetallesCCById(id);
    }

    @PostMapping
    public Optional<String> addDetallesOrdenes(@RequestBody DetallesCC newDetallesOrdenes){
        return detallesCCService.addDetallesCC(newDetallesOrdenes);
    }

    @PutMapping("/{id}")
    public Optional<String> updateDetallesOrdenes(@PathVariable Long id, @RequestBody DetallesCC newData){
        return detallesCCService.updateDetallesCC(id, newData);
    }

    @DeleteMapping("/{id}")
    public Optional<String> deleteDetallesOrdenes(@PathVariable Long id){
        return detallesCCService.deleteDetallesCCById(id);
    }

}
