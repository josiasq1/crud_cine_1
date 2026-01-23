package com.example.crud_cine.service.impl;

import com.example.crud_cine.model.Empleado;
import com.example.crud_cine.model.mongo.EmpleadoDoc;
import com.example.crud_cine.repository.EmpleadoMongoRepository;
import com.example.crud_cine.repository.EmpleadoRepository;
import com.example.crud_cine.service.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpleadoServiceImpl implements EmpleadoService {

    @Autowired
    private EmpleadoRepository empleadoRepository; // MySQL

    @Autowired
    private EmpleadoMongoRepository empleadoMongoRepository; // MongoDB

    @Override
    public Empleado agregar(Empleado empleado) {
        // 1. Guardamos en MySQL (Esto genera el ID autoincremental)
        Empleado guardadoSql = empleadoRepository.save(empleado);

        // 2. Sincronizamos con MongoDB usando el objeto que ya tiene ID
        EmpleadoDoc doc = new EmpleadoDoc(guardadoSql);
        empleadoMongoRepository.save(doc);

        return guardadoSql;
    }

    // listar
    @Override
    public List<Empleado> listarTodos() {
        return empleadoRepository.findAll();
    }

    // obtener id
    @Override
    public Empleado obtenerPorId(Long idEmpleado) {
        return empleadoRepository.findById(idEmpleado)
                .orElseThrow(() -> new RuntimeException("Empleado no encontrado con id: " + idEmpleado));
    }

    // actualizar (MODIFICADO PARA SINCRONIZAR)
    @Override
    public Empleado actualizar(Long idEmpleado, Empleado empleado) {

        Empleado existente = obtenerPorId(idEmpleado);

        existente.setNombre(empleado.getNombre());
        existente.setPuesto(empleado.getPuesto());
        existente.setTipoJornada(empleado.getTipoJornada());
        existente.setEmail(empleado.getEmail());
        existente.setTelefono(empleado.getTelefono());
        existente.setFechaContratacion(empleado.getFechaContratacion());
        existente.setSalarioHora(empleado.getSalarioHora());
        existente.setActivo(empleado.isActivo());

        // 1. Guardamos en MySQL
        Empleado actualizadoSql = empleadoRepository.save(existente);

        // 2. Sincronizamos (Al llevar el mismo ID, Mongo hará un "Replace")
        EmpleadoDoc doc = new EmpleadoDoc(actualizadoSql);
        empleadoMongoRepository.save(doc);

        return actualizadoSql;
    }

    // eliminar (MODIFICADO PARA SINCRONIZAR)
    @Override
    public void eliminar(Long idEmpleado) {
        // 1. Borramos de MySQL
        empleadoRepository.deleteById(idEmpleado);

        // 2. Borramos de MongoDB
        empleadoMongoRepository.deleteById(idEmpleado.toString());
    }

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
}