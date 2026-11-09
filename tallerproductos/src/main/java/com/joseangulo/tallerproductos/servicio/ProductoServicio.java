package com.joseangulo.tallerproductos.servicio;

import com.joseangulo.tallerproductos.excepcion.ProductoInvalidoExcepcion;
import com.joseangulo.tallerproductos.excepcion.ProductoNoEncontradoExcepcion;
import com.joseangulo.tallerproductos.modelo.Producto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductoServicio {

    private List<Producto> productos = new ArrayList<>();
    private Long contadorId = 1L;

    public List<Producto> obtenerTodos() {
        return productos;
    }

    public Producto obtenerPorId(Long id) {
        return productos.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new ProductoNoEncontradoExcepcion("Producto con ID " + id + " no encontrado."));
    }

    public Producto guardar(Producto producto) {
        if (producto.getPrecio() == null || producto.getPrecio() <= 0) {
            throw new ProductoInvalidoExcepcion("El precio debe ser mayor a cero.");
        }
        if (producto.getStock() == null || producto.getStock() < 0) {
            throw new ProductoInvalidoExcepcion("El stock no puede ser negativo.");
        }
        
        producto.setId(contadorId++);
        productos.add(producto);
        return producto;
    }

    public void eliminar(Long id) {
        boolean eliminado = productos.removeIf(p -> p.getId().equals(id));
        if (!eliminado) {
            throw new ProductoNoEncontradoExcepcion("No se puede eliminar. Producto con ID " + id + " no existe.");
        }
    }
}