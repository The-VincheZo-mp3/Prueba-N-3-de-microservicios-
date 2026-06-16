package com.duoc.msgestion.service;

import com.duoc.msgestion.model.Producto;
import com.duoc.msgestion.repository.ProductoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class ProductoService {

    private final ProductoRepository repository;

    public ProductoService(ProductoRepository repository) {
        this.repository = repository;
    }

    // Operación de lectura optimizada
    @Transactional(readOnly = true)
    public List<Producto> listarTodosLosProductos() {
        return repository.findAll();
    }

    // Control transaccional atómico para mitigar inconsistencias ante fallas
    @Transactional
    public Producto guardarProducto(Producto producto) {
        if (producto.getPrecio() < 0) {
            throw new IllegalArgumentException("El precio no puede ser negativo");
        }
        return repository.save(producto);
    }
}