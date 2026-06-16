package com.duoc.msgestion.controller;

import com.duoc.msgestion.model.Producto;
import com.duoc.msgestion.service.ProductoService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/productos")
@CrossOrigin(origins = "*")
public class ProductoController {

    private final ProductoService service;

    public ProductoController(ProductoService service) {
        this.service = service;
    }

    // Endpoint GET para listar todos los productos
    @GetMapping
    public List<Producto> obtenerTodos() {
        return service.listarTodosLosProductos();
    }

    // Endpoint POST para la creación de nuevos productos
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Producto crearNuevo(@RequestBody Producto producto) {
        return service.guardarProducto(producto);
    }
}