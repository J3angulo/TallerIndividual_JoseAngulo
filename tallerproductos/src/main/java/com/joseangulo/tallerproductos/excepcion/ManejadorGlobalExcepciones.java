package com.joseangulo.tallerproductos.excepcion;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ManejadorGlobalExcepciones {

    @ExceptionHandler(ProductoNoEncontradoExcepcion.class)
    public ResponseEntity<Map<String, Object>> manejarNoEncontrado(ProductoNoEncontradoExcepcion ex) {
        Map<String, Object> respuesta = new HashMap<>();
        respuesta.put("mensaje", ex.getMessage());
        respuesta.put("codigo", HttpStatus.NOT_FOUND.value()); // 404
        return new ResponseEntity<>(respuesta, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ProductoInvalidoExcepcion.class)
    public ResponseEntity<Map<String, Object>> manejarInvalido(ProductoInvalidoExcepcion ex) {
        Map<String, Object> respuesta = new HashMap<>();
        respuesta.put("mensaje", ex.getMessage());
        respuesta.put("codigo", HttpStatus.BAD_REQUEST.value()); // 400
        return new ResponseEntity<>(respuesta, HttpStatus.BAD_REQUEST);
    }
}