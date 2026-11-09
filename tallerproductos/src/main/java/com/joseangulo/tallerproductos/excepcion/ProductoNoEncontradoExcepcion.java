package com.joseangulo.tallerproductos.excepcion;

public class ProductoNoEncontradoExcepcion extends RuntimeException {
    public ProductoNoEncontradoExcepcion(String mensaje) {
        super(mensaje);
    }
}