package com.example.crud_cine.controller;

import com.example.crud_cine.model.Peliculas;
import com.example.crud_cine.service.PeliculasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/peliculas")
public class PeliculasController {

    @Autowired
    private PeliculasService peliculasService;

    // Listar todas las películas (sin mostrar el campo "activa")
    @GetMapping
    public List<Peliculas> listar() {
        return peliculasService.listarTodos();
    }

    // Agregar una nueva película
    @PostMapping
    public Peliculas agregar(@RequestBody Peliculas peliculas) {
        return peliculasService.agregar(peliculas);
    }

    // Actualizar película por ID
    @PutMapping("/{id}")
    public Peliculas actualizar(
            @PathVariable Integer id,
            @RequestBody Peliculas peliculas
    ) {
        return peliculasService.actualizar(id, peliculas);
    }

    // Eliminar película por ID
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) {
        peliculasService.eliminar(id);
    }
}
