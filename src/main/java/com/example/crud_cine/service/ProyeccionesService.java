package com.example.crud_cine.service;

import com.example.crud_cine.model.Proyecciones;
import java.util.List;

public interface ProyeccionesService {

    List<Proyecciones> listarTodos();
    Proyecciones agregar(Proyecciones proyecciones);
    Proyecciones actualizar(Long idProyeccion, Proyecciones proyecciones);
    void eliminar(Long idProyecciones);
    Proyecciones obtenerPorId(Long idProyeccion);
}
