package com.example.crud_cine.service;

import com.example.crud_cine.model.Empleado;

import java.util.List;

public interface EmpleadoService {

    List<Empleado> listarTodos();

    // obtener id
    Empleado obtenerPorId(Long idEmpleado);

    Empleado agregar(Empleado empleado);

    Empleado actualizar(Long idEmpleado, Empleado empleado);

    void eliminar(Long idEmpleado);

    List<Empleado> listarActivos();

    List<Empleado> buscarPorPuesto(String puesto);

    List<Empleado> buscarPorSalarioMayorA(double salario);

    List<Empleado> buscarPorTipoJornadaActivos(String tipoJornada);

}
