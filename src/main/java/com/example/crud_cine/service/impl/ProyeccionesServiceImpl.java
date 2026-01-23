package com.example.crud_cine.service.impl;

import com.example.crud_cine.model.Proyecciones;
import com.example.crud_cine.repository.ProyeccionesRepository;
import com.example.crud_cine.service.ProyeccionesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProyeccionesServiceImpl implements ProyeccionesService {

    @Autowired
    private ProyeccionesRepository proyeccionesRepository;

    @Override
    public List<Proyecciones> listarTodos() {
        return proyeccionesRepository.findAll();
    }

    @Override
    public Proyecciones agregar(Proyecciones proyecciones) {
        return proyeccionesRepository.save(proyecciones);
    }

    @Override
    public Proyecciones actualizar(Long idProyeccion, Proyecciones proyecciones) {
        Proyecciones existente = obtenerPorId(idProyeccion);

        existente.setFechaHoraInicio(proyecciones.getFechaHoraInicio());
        existente.setFechaHoraFin(proyecciones.getFechaHoraFin());
        existente.setPrecioEntrada(proyecciones.getPrecioEntrada());
        existente.setAsientosDisponibles(proyecciones.getAsientosDisponibles());
        existente.setIdPelicula(proyecciones.getIdPelicula());
        existente.setIdSala(proyecciones.getIdSala());

        return proyeccionesRepository.save(existente);
    }

    @Override
    public void eliminar(Long idProyecciones) {
        proyeccionesRepository.deleteById(idProyecciones);
    }

    @Override
    public Proyecciones obtenerPorId(Long idProyeccion) {
        return proyeccionesRepository.findById(idProyeccion)
                .orElseThrow(() -> new RuntimeException("Proyección no encontrada con id: " + idProyeccion));
    }

    /* @Override
    public List<Proyecciones> buscarPorTipoJornadaActivos(String tipoJornada) {
        return proyeccionesRepository.findByTipoJornadaAndActivoTrue(tipoJornada);
    } */
}
