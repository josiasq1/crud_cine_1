package com.example.crud_cine.service.impl;

import com.example.crud_cine.model.Peliculas;
import com.example.crud_cine.service.PeliculasService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class PeliculasServiceImpl implements PeliculasService {

    // ⭐ Lista en memoria
    private final List<Peliculas> peliculasDB = new ArrayList<>();

    @Override
    public List<Peliculas> listarTodos() {
        return peliculasDB;
    }

    @Override
    public Peliculas agregar(Peliculas peliculas) {
        peliculas.setIdPelicula(peliculasDB.size() + 1);
        peliculasDB.add(peliculas);
        return peliculas;
    }

    @Override
    public Peliculas actualizar(Integer id, Peliculas nuevas) {

        Peliculas existente = peliculasDB.stream()
                .filter(p -> p.getIdPelicula().equals(id))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Pelicula no encontrada"));

        existente.setTitulo(nuevas.getTitulo());
        existente.setDuracionMinutos(nuevas.getDuracionMinutos());
        existente.setGenero(nuevas.getGenero());
        existente.setClasificacion(nuevas.getClasificacion());
        existente.setDirector(nuevas.getDirector());
        existente.setSinopsis(nuevas.getSinopsis());
        existente.setFechaEstreno(nuevas.getFechaEstreno());
        existente.setPopularidad(nuevas.getPopularidad());
        existente.setActiva(nuevas.isActiva());
        existente.setFechaBaja(nuevas.getFechaBaja());

        return existente;
    }

    @Override
    public void eliminar(Integer idPeliculas) {
        peliculasDB.removeIf(p -> p.getIdPelicula().equals(idPeliculas));
    }
}

/*
    // listar empleados activos
    @Override
    public List<Empleado> listarActivos() {
        return empleadoRepository.findAll().stream()
                .filter(Empleado::isActivo)
                .toList();
    }

    // buscar por puesto
    @Override
    public List<Empleado> buscarPorPuesto(String puesto) {
        return empleadoRepository.findAll().stream()
                .filter(e -> e.getPuesto() != null && e.getPuesto().equalsIgnoreCase(puesto))
                .toList();
    }

    // salario mayor a
    @Override
    public List<Empleado> buscarPorSalarioMayorA(double salario) {
        return empleadoRepository.findAll().stream()
                .filter(e -> e.getSalarioHora() > salario)
                .toList();
    }

    // tipo jornada + activos
    @Override
    public List<Empleado> buscarPorTipoJornadaActivos(String tipoJornada) {
        return empleadoRepository.findAll().stream()
                .filter(e -> e.isActivo()
                        && e.getTipoJornada() != null
                        && e.getTipoJornada().equalsIgnoreCase(tipoJornada))
                .toList();
    }
    */

