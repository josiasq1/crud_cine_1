package com.example.crud_cine.service;

import com.example.crud_cine.model.Peliculas;

import java.util.List;

public interface PeliculasService {

    List<Peliculas> listarTodos();

    Peliculas agregar(Peliculas peliculas);

    Peliculas actualizar(Integer idPelicula, Peliculas peliculas);

    void eliminar(Integer idPelicula);

    /*
    Peliculas obtenerPorId(Integer id);

    List<Peliculas> listarActivas();

    List<Peliculas> buscarPorGenero(String genero);

    List<Peliculas> buscarPorPopularidadMayorA(String popularidadMinima);
*/
}
