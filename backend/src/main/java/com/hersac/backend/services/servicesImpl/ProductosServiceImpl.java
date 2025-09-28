package com.hersac.backend.services.servicesImpl;

import java.lang.StackWalker.Option;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hersac.backend.models.Productos;
import com.hersac.backend.repositories.ProductosRepository;
import com.hersac.backend.services.ProductosService;

@Service
public class ProductosServiceImpl implements ProductosService {
    @Autowired
    private ProductosRepository productosRepo;

    @Override
    public Optional<List<Productos>> getProductos() {
        return Optional.ofNullable(productosRepo.findAll());
    }

    @Override
    public Optional<Productos> getProductoById(Long id) {
        Optional<Productos> producto = productosRepo.findById(id);
        if(!producto.isPresent())
            throw new RuntimeException("Producto no encontrado");
        return producto;
    }

    @Override
    public Optional<String> addProducto(Productos newProducto) {
        productosRepo.save(newProducto);
        return Optional.of("Producto agregado");
    }

    @Override
    public Optional<String> updateProducto(Long id, Productos newData) {
        Optional<Productos> producto = productosRepo.findById(id);
        if(!producto.isPresent())
            throw new RuntimeException("Producto no encontrado");
        producto.get().setNombre(newData.getNombre());
        producto.get().setDescCorta(newData.getDescCorta());
        producto.get().setDescripcion(newData.getDescripcion());
        producto.get().setPrecio(newData.getPrecio());
        producto.get().setReferencia(newData.getReferencia());
        producto.get().setCategoria(newData.getCategoria());
        producto.get().setDisponible(newData.getDisponible());
        productosRepo.save(producto.get());
        return Optional.of("Producto actualizado");
    }

    @Override
    public Optional<String> deleteProductoById(Long id) {
        Optional<Productos> producto = productosRepo.findById(id);
        if(!producto.isPresent())
            throw new RuntimeException("Producto no encontrado");
        return Optional.of("Producto eliminado");
    }
}
