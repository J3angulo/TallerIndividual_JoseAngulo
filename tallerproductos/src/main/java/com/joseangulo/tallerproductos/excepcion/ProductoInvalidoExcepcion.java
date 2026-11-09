package com.joseangulo.tallerproductos.excepcion;

public class ProductoInvalidoExcepcion extends RuntimeException {
    public ProductoInvalidoExcepcion(String mensaje) {
        super(mensaje);
    }
}