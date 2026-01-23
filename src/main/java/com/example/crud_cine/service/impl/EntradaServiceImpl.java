package com.example.crud_cine.service.impl;

import com.example.crud_cine.model.Entradas;

import com.example.crud_cine.repository.EntradaRepository;
import com.example.crud_cine.service.EntradaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service // <--- AÑADE ESTO AQUÍ
public class EntradaServiceImpl  implements EntradaService {

    @Autowired(required = true)
    private EntradaRepository repository;

    @Override
    public List<Entradas> listarTodos() {
        return repository.findAll();
    }

    @Override
    public Entradas agregar(Entradas e) {
        return repository.save(e);
    }

    @Override
    public Entradas actualizar(Long idEntrada, Entradas entradas) {
        Entradas existente = obtenerPorId(idEntrada);
        existente.setIdProyeccion(entradas.getIdProyeccion());
        existente.setFechaHora(entradas.getFechaHora());
        existente.setAsiento(entradas.getAsiento());
        existente.setPrecio(entradas.getPrecio());
        existente.setVendida(entradas.getVendida());

        return repository.save(existente);
    }

    @Override
    public void eliminar(Long idEntrada) {
        repository.deleteById(idEntrada);
    }

    @Override
    public Entradas obtenerPorId(Long idEntrada) {
        return repository.findById(idEntrada)
                .orElseThrow(() -> new RuntimeException("Entrada no encontrada con id: " + idEntrada));
    }
}
