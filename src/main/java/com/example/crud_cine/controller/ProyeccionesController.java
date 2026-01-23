package com.example.crud_cine.controller;

import com.example.crud_cine.model.Proyecciones;
import com.example.crud_cine.service.ProyeccionesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/proyecciones")
public class ProyeccionesController {

    @Autowired
    private ProyeccionesService proyeccionesService;

    @GetMapping
    public List<Proyecciones> listar() {
        return proyeccionesService.listarTodos();
    }

    @PostMapping
    public Proyecciones agregar(@RequestBody Proyecciones proyecciones) {
        return proyeccionesService.agregar(proyecciones);
    }

    @PutMapping("/{id}")
    public Proyecciones actualizar(@PathVariable Long id, @RequestBody Proyecciones proyecciones) {
        return proyeccionesService.actualizar(id, proyecciones);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Proyecciones> obtenerPorId(@PathVariable Long id) {
        return ResponseEntity.ok(proyeccionesService.obtenerPorId(id));
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        proyeccionesService.eliminar(id);
    }
}
