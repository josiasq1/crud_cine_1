package com.example.crud_cine.controller;

import com.example.crud_cine.model.Entradas;
import com.example.crud_cine.service.EntradaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/entradas")
public class EntradasController {

    @Autowired
    private EntradaService service;

    // Listar todos los entrada
    @GetMapping
    public List<Entradas> listar() {
        return service.listarTodos();
    }

    // Agregar un entrada
    @PostMapping
    public Entradas agregar(@RequestBody Entradas entradas) {
        return service.agregar(entradas);
    }

    // Actualizar entrada por ID
    @PutMapping("/{id}")
    public Entradas actualizar(@PathVariable Long idEntrada, @RequestBody Entradas entradas) {
        return service.actualizar(idEntrada, entradas);
    }

    // Encontrar entrada por ID
    @GetMapping("/{id}")
    public ResponseEntity<Entradas   > obtenerPorId(@PathVariable Long idEntrada) {
        Entradas entradas = service.obtenerPorId(idEntrada);
        return ResponseEntity.ok(entradas);
    }
    // Eliminar entrada por ID
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        service.eliminar(id);
    }
}
