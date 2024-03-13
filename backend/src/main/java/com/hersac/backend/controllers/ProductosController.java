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

import com.hersac.backend.models.Productos;
import com.hersac.backend.services.ProductosService;

@RestController
@RequestMapping("/api/productos")
public class ProductosController {

    @Autowired
    private ProductosService productosServ;

    @GetMapping
    public Optional<List<Productos>> getProductos(){
        return productosServ.getProductos();
    }

    @GetMapping("/{id}")
    public Optional<Productos> getProductoById(@PathVariable Long id){
        return productosServ.getProductoById(id);
    }

    @PostMapping
    public Optional<String> addProductos(@RequestBody Productos newProducto ){
        return productosServ.addProducto(newProducto);
    }

    @PutMapping("/{id}")
    public Optional<String> updateProducto(@PathVariable Long id, @RequestBody Productos newData){
        return productosServ.updateProducto(id, newData);
    }

    @DeleteMapping("/{id}")
    public Optional<String> deleteProducto(@PathVariable Long id){
        return productosServ.deleteProductoById(id);
    }
}
