package com.joseangulo.tallerproductos.controlador;

import com.joseangulo.tallerproductos.modelo.Producto;
import com.joseangulo.tallerproductos.servicio.ProductoServicio;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products") // Dejamos la ruta en inglés porque el taller la pide así estrictamente
public class ProductoControlador {

    // INYECCIÓN POR CONSTRUCTOR (Como pide el taller)
    private final ProductoServicio productoServicio;

    public ProductoControlador(ProductoServicio productoServicio) {
        this.productoServicio = productoServicio;
    }

    @GetMapping
    public List<Producto> listar() {
        return productoServicio.obtenerTodos();
    }

    @GetMapping("/{id}")
    public Producto obtener(@PathVariable Long id) {
        return productoServicio.obtenerPorId(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Producto crear(@RequestBody Producto producto) {
        return productoServicio.guardar(producto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(@PathVariable Long id) {
        productoServicio.eliminar(id);
    }
}