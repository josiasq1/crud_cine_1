package com.example.crud_cine.controller;

import com.example.crud_cine.model.Empleado;
import com.example.crud_cine.model.mongo.EmpleadoDoc;
import com.example.crud_cine.service.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/empleados")
public class EmpleadoController {

    @Autowired
    private EmpleadoService empleadoService;

    // Listar todos los empleados
    @GetMapping
    public List<Empleado> listar() {
        return empleadoService.listarTodos();
    }

    // Agregar un empleado
    @PostMapping
    public Empleado agregar(@RequestBody Empleado empleado) {
        return empleadoService.agregar(empleado);
    }

    @Autowired
    private com.example.crud_cine.repository.EmpleadoMongoRepository mongoRepo;

    @GetMapping("/mongo")
    public List<EmpleadoDoc> listarDesdeMongo() {
        return mongoRepo.findAll();
    }

    // Actualizar empleado por ID
    @PutMapping("/{id}")
    public Empleado actualizar(@PathVariable Long id, @RequestBody Empleado empleado) {
        return empleadoService.actualizar(id, empleado);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Empleado> obtenerPorId(@PathVariable Long id) {
        Empleado empleado = empleadoService.obtenerPorId(id);
        return ResponseEntity.ok(empleado);
    }
    // Eliminar empleado por ID
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        empleadoService.eliminar(id);
    }

    // Listar empleados activos
    @GetMapping("/activos")
    public List<Empleado> empleadosActivos() {
        return empleadoService.listarActivos();
    }

    // Buscar por puesto
    @GetMapping("/puesto/{puesto}")
    public List<Empleado> buscarPorPuesto(@PathVariable String puesto) {
        return empleadoService.buscarPorPuesto(puesto);
    }

    // Buscar salario mayor a X
    @GetMapping("/salario-mayor/{salario}")
    public List<Empleado> buscarPorSalarioMayorA(@PathVariable double salario) {
        return empleadoService.buscarPorSalarioMayorA(salario);
    }

    // Buscar por tipo jornada + activos
    @GetMapping("/jornada/{tipo}")
    public List<Empleado> buscarPorTipoJornadaActivos(@PathVariable("tipo") String tipoJornada) {
        return empleadoService.buscarPorTipoJornadaActivos(tipoJornada);
    }
}
