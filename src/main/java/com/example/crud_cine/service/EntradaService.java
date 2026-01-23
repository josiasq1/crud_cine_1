package com.example.crud_cine.service;

import com.example.crud_cine.model.Entradas;
import java.util.List;

public interface EntradaService {
    List<Entradas> listarTodos();
    Entradas agregar(Entradas entradas);
    Entradas actualizar(Long idEntrada, Entradas entrada);
    void eliminar(Long idEntrada);
    Entradas obtenerPorId(Long idEntrada);
}
